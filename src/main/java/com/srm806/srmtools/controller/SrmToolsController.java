package com.srm806.srmtools.controller;

import com.srm806.srmtools.domain.SrmToolParas;
import com.srm806.srmtools.service.SrmToolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SrmToolsController
 * @Author: wkx
 * @Date: 2020/1/10 20:49
 * @Version: v1.0
 * @Description: 发动机常用参数计算Controller
 */
@RestController
public class SrmToolsController {

    @Autowired
    private SrmToolsService srmToolsService;

    @PostMapping("/srmtool")
    public Double calSrmTool(SrmToolParas srmToolParas){
        switch (srmToolParas.getType()){
            case "pc": return srmToolsService.calPc(srmToolParas);
            case "cd": return srmToolsService.calCd(srmToolParas);
            case "ab": return srmToolsService.calAb(srmToolParas);
            case "rt": return srmToolsService.calRt(srmToolParas);
            case "mb": return srmToolsService.calMbRt(srmToolParas);
            case "pa": return srmToolsService.calPa(srmToolParas);
            case "pe": return srmToolsService.calPe(srmToolParas);
            case "isp": return srmToolsService.calIsp(srmToolParas);
            case "f": return srmToolsService.calF(srmToolParas);
            case "r": return srmToolsService.calR(srmToolParas);
            case "eps": return srmToolsService.calEps(srmToolParas);
            default: return null;
        }
    }

}
