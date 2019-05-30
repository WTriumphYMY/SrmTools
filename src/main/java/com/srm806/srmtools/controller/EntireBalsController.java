package com.srm806.srmtools.controller;

import com.srm806.srmtools.domain.*;
import com.srm806.srmtools.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

/**
 * 全过程内弹道控制器
 */
@RestController
public class EntireBalsController {

    @Autowired
    PropMainService propMainService;
    @Autowired
    PropigService propigService;
    @Autowired
    MotorService motorService;
    @Autowired
    EnviromentService enviromentService;
    @Autowired
    BalisticService balisticService;

    @PostMapping("/module/bals")
    public Map<String, List> calculateBals(SrmVO srmVO, String srmName,
                                           MultipartFile igGrain, MultipartFile mainGrain) {

        saveData(srmVO, srmName);
        String igGrainName = UUID.randomUUID() + "igprop.grain";
        String mainGrainName = UUID.randomUUID() + "mainprop.grain";
        String path = null;
        try {
            path = ResourceUtils.getURL("classpath:").getPath() + "static/grain/";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        File iggrainPath = new File(path,igGrainName);
        File maingrainPath = new File(path, mainGrainName);
        //判断路径是否存在，如果不存在就创建一个
        if (!iggrainPath.getParentFile().exists()) {
            iggrainPath.getParentFile().mkdirs();
        }
        //判断文件是否存在，存在就把原来的删了
        Map<String, List> result;
        List<Boolean> success = new ArrayList<>();
        List<String> message = new ArrayList<>();
        try {
            Files.deleteIfExists(iggrainPath.toPath());
            Files.deleteIfExists(maingrainPath.toPath());
            igGrain.transferTo(iggrainPath);
            mainGrain.transferTo(maingrainPath);
        } catch (IOException e) {
            result = new HashMap<>();
            success.add(false);
            message.add("服务器向您抛出了一个问题，请联系管理员");
            e.printStackTrace();
            result.put("success", success);
            result.put("message", message);
            return result;
        }

        //计算内弹道，返回Map
        try {
            result = balisticService.calBals(srmVO, iggrainPath, maingrainPath);
            success.add(true);
            message.add("可以查看结果啦");
        }catch (Exception e){
            result = new HashMap<>();
            success.add(false);
            message.add("请检查参数是否合理");
        }

        result.put("success", success);
        result.put("message", message);
        return result;

    }

    @PostMapping("/module/bals/blur")
    public SrmVO getData(String srmName) {
        SrmVO srmVO = new SrmVO();
        PropellantMainParas tbPropmain = propMainService.getPropmainBySrmName(srmName);
        PropellantIgParas tbPropig = propigService.getPropigBySrmName(srmName);
        RocketParas tbMotor = motorService.getMotorBySrmName(srmName);
        EnvironmentParas tbEnv = enviromentService.getEnvBySrmName(srmName);
        srmVO.setPropmain(tbPropmain);
        srmVO.setPropig(tbPropig);
        srmVO.setMotor(tbMotor);
        srmVO.setEnv(tbEnv);
        return srmVO;
    }


    /**
     * 将全过程内弹道中发动机的参数持久化到数据库
     * @param srmVO 发动机参数的包装类
     */
    public void saveData(SrmVO srmVO, String srmName){
        //如果数据库中已有此型号发动机，则更新参数，没有就新增
        PropellantMainParas propMain = srmVO.getPropmain();
        propMain.setSrmName(srmName);
        if (propMainService.getPropmainBySrmName(srmName) == null){
            propMainService.addPropmain(propMain);
        }else {
            propMainService.updatePropmainBySrmName(propMain);
        }

        PropellantIgParas propIg = srmVO.getPropig();
        propIg.setSrmName(srmName);
        if (propigService.getPropigBySrmName(srmName) == null){
            propigService.addPropig(propIg);
        }else {
            propigService.updatePropigBySrmName(propIg);
        }

        RocketParas motor = srmVO.getMotor();
        motor.setSrmName(srmName);
        if (motorService.getMotorBySrmName(srmName) == null){
            motorService.addMotor(motor);
        }else {
            motorService.updateMotorBySrmName(motor);
        }

        EnvironmentParas env = srmVO.getEnv();
        env.setSrmName(srmName);
        if (enviromentService.getEnvBySrmName(srmName) == null){
            enviromentService.addEnv(env);
        }else {
            enviromentService.updateEnvBySrmName(env);
        }

    }
}
