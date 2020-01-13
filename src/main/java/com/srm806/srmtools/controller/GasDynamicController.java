package com.srm806.srmtools.controller;

import com.srm806.srmtools.domain.GasDynamic;
import com.srm806.srmtools.service.GasDynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName GasDynamicController
 * @Author: wkx
 * @Date: 2020/1/13 11:17
 * @Version: v1.0
 * @Description: 气动参数计算Controller
 */
@RestController
public class GasDynamicController {

    @Autowired
    private GasDynamicService gasDynamicService;

    @PostMapping("gasdynamic")
    public Map<String, Double> calGasDynamic(GasDynamic gasDynamic){
        switch (gasDynamic.getType()){
            case "tau" :return gasDynamicService.calTau(gasDynamic);
            case "epsilon" :return gasDynamicService.calEpsilon(gasDynamic);
            case "n" :return gasDynamicService.calN(gasDynamic);
            case "q" :return gasDynamicService.calQ(gasDynamic);
            case "y" :return gasDynamicService.calY(gasDynamic);
            case "f" :return gasDynamicService.calF(gasDynamic);
            case "r" :return gasDynamicService.calR(gasDynamic);
            case "m" :return gasDynamicService.calM(gasDynamic);
            case "lambda" :return gasDynamicService.calLambda(gasDynamic);
            case "zjb" :return gasDynamicService.calForwardShock(gasDynamic);
            case "xjb" :return gasDynamicService.calObliqueShock(gasDynamic);
            default: return null;
        }
    }
}
