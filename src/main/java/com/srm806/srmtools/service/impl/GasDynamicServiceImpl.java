package com.srm806.srmtools.service.impl;

import com.srm806.srmtools.algorithm.SrmFunc;
import com.srm806.srmtools.domain.GasDynamic;
import com.srm806.srmtools.service.GasDynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName GasDynamicServiceImpl
 * @Author: wkx
 * @Date: 2020/1/12 21:41
 * @Version: v1.0
 * @Description: 启动参数实现类
 */
@Service
public class GasDynamicServiceImpl implements GasDynamicService {

    @Autowired
    private SrmFunc srmFunc;

    @Override
    public Map<String, Double> calTau(GasDynamic gasDynamic) {
        Map<String, Double> resultMap = new HashMap<>();
        resultMap.put("lambda", srmFunc.TLamda(gasDynamic.getLambdaOrMach(), gasDynamic.getK()));
        return resultMap;
    }

    @Override
    public Map<String, Double> calEpsilon(GasDynamic gasDynamic) {
        Map<String, Double> resultMap = new HashMap<>();
        resultMap.put("lambda", srmFunc.ELamda(gasDynamic.getLambdaOrMach(), gasDynamic.getK()));
        return resultMap;
    }

    @Override
    public Map<String, Double> calN(GasDynamic gasDynamic) {
        Map<String, Double> resultMap = new HashMap<>();
        resultMap.put("lambda", srmFunc.PLamda(gasDynamic.getLambdaOrMach(), gasDynamic.getK()));
        return resultMap;
    }

    @Override
    public Map<String, Double> calQ(GasDynamic gasDynamic) {
        Map<String, Double> resultMap = new HashMap<>();
        resultMap.put("lambda", srmFunc.QLamda(gasDynamic.getLambdaOrMach(), gasDynamic.getK()));
        return resultMap;
    }

    @Override
    public Map<String, Double> calY(GasDynamic gasDynamic) {
        Map<String, Double> resultMap = new HashMap<>();
        resultMap.put("lambda", srmFunc.YLamda(gasDynamic.getLambdaOrMach(), gasDynamic.getK()));
        return resultMap;
    }

    @Override
    public Map<String, Double> calF(GasDynamic gasDynamic) {
        Map<String, Double> resultMap = new HashMap<>();
        resultMap.put("lambda", srmFunc.FLamda(gasDynamic.getLambdaOrMach(), gasDynamic.getK()));
        return resultMap;
    }

    @Override
    public Map<String, Double> calR(GasDynamic gasDynamic) {
        Map<String, Double> resultMap = new HashMap<>();
        resultMap.put("lambda", srmFunc.RLamda(gasDynamic.getLambdaOrMach(), gasDynamic.getK()));
        return resultMap;
    }

    @Override
    public Map<String, Double> calM(GasDynamic gasDynamic) {
        Map<String, Double> resultMap = new HashMap<>();
        resultMap.put("lambda", srmFunc.MLamda(gasDynamic.getLambdaOrMach(), gasDynamic.getK()));
        return resultMap;
    }

    @Override
    public Map<String, Double> calLambda(GasDynamic gasDynamic) {
        Map<String, Double> resultMap = new HashMap<>();
        resultMap.put("lambda", srmFunc.GetLamdaByMa(gasDynamic.getLambdaOrMach(), gasDynamic.getK()));
        return resultMap;
    }

    @Override
    public Map<String, Double> calForwardShock(GasDynamic gasDynamic) {
        double k = gasDynamic.getK();
        double lambda = gasDynamic.getLambdaOrMach();
        double vCoe=1/lambda; //波后速度系数
        double pressureRatio=(lambda*lambda-(k-1)/(k+1))/(1-lambda*lambda*(k-1)/(k+1));//波后静压比
        double sigma=lambda*lambda*Math.pow((1-(k-1)/(k+1)*lambda*lambda)/(1-(k-1)/(k+1)/lambda/lambda),1/(k-1));//总压恢复系数
        Map<String, Double> resultMap = new HashMap<>();
        resultMap.put("vCoe", vCoe);
        resultMap.put("pressureRatio", pressureRatio);
        resultMap.put("sigma", sigma);
        return resultMap;
    }

    @Override
    public Map<String, Double> calObliqueShock(GasDynamic gasDynamic) {
        double k = gasDynamic.getK();
        double lambda = gasDynamic.getLambdaOrMach();
        double angle = gasDynamic.getAngle();
        double piOver180 = Math.PI/180;
        double piUnder180 = 1/piOver180;
        double delta = angle*piOver180;
        double beta = srmFunc.GetBeta(delta, srmFunc.MLamda(lambda, k), k); //马赫角
        double lambda2 = srmFunc.GetM2AfterShock(srmFunc.MLamda(lambda, k), beta, k);
        double vCoe = srmFunc.GetLamdaByMa(lambda2, k); //波后速度系数
        double sigma = srmFunc.GetSigmaP(beta, vCoe, k); //总压恢复系数
        double pressureRatio = sigma * srmFunc.TLamda(vCoe, k)/srmFunc.TLamda(lambda, k);//波后静压比
        beta *= piUnder180;
        Map<String, Double> resultMap = new HashMap<>();
        resultMap.put("vCoe", vCoe);
        resultMap.put("pressureRatio", pressureRatio);
        resultMap.put("sigma", sigma);
        resultMap.put("delta", beta);
        return resultMap;
    }
}
