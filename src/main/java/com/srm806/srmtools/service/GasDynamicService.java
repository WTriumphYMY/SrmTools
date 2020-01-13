package com.srm806.srmtools.service;

import com.srm806.srmtools.domain.GasDynamic;

import java.util.Map;

/**
 * @InterfaceName GasDynamicService
 * @Author: wkx
 * @Date: 2020/1/12 21:34
 * @Version: v1.0
 * @Description: 气动参数计算接口
 */
public interface GasDynamicService {
    /**
     * 计算τ(λ)
     * @param gasDynamic
     * @return
     */
    Map<String, Double> calTau(GasDynamic gasDynamic);

    /**
     * 计算ε(λ)
     * @param gasDynamic
     * @return
     */
    Map<String, Double> calEpsilon(GasDynamic gasDynamic);

    /**
     * 计算n(λ)
     * @param gasDynamic
     * @return
     */
    Map<String, Double> calN(GasDynamic gasDynamic);

    /**
     * 计算q(λ)
     * @param gasDynamic
     * @return
     */
    Map<String, Double> calQ(GasDynamic gasDynamic);

    /**
     * 计算y(λ)
     * @param gasDynamic
     * @return
     */
    Map<String, Double> calY(GasDynamic gasDynamic);

    /**
     * 计算f(λ)
     * @param gasDynamic
     * @return
     */
    Map<String, Double> calF(GasDynamic gasDynamic);

    /**
     * 计算r(λ)
     * @param gasDynamic
     * @return
     */
    Map<String, Double> calR(GasDynamic gasDynamic);

    /**
     * 计算M(λ)
     * @param gasDynamic
     * @return
     */
    Map<String, Double> calM(GasDynamic gasDynamic);

    /**
     * 计算λ(M)
     * @param gasDynamic
     * @return
     */
    Map<String, Double> calLambda(GasDynamic gasDynamic);

    /**
     * 计算正激波参数
     * @param gasDynamic
     * @return
     */
    Map<String, Double> calForwardShock(GasDynamic gasDynamic);

    /**
     * 计算斜激波参数
     * @param gasDynamic
     * @return
     */
    Map<String, Double> calObliqueShock(GasDynamic gasDynamic);
}
