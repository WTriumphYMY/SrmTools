package com.srm806.srmtools.service;

import com.srm806.srmtools.domain.SrmToolParas;

/**
 * @InterfaceName SrmToolsService
 * @Author: wkx
 * @Date: 2020/1/10 21:05
 * @Version: v1.0
 * @Description: 发动机常用参数计算Service
 */
public interface SrmToolsService {
    /**
     * 计算燃烧室压强Pc
     * @param srmToolParas
     * @return
     */
    double calPc(SrmToolParas srmToolParas);

    /**
     * 壳体壁厚
     * @param srmToolParas
     * @return
     */
    double calCd(SrmToolParas srmToolParas);

    /**
     * 计算燃面
     * @param srmToolParas
     * @return
     */
    double calAb(SrmToolParas srmToolParas);

    /**
     * 计算喉径
     * @param srmToolParas
     * @return
     */
    double calRt(SrmToolParas srmToolParas);

    /**
     * 由质量流率计算喉径
     * @param srmToolParas
     * @return
     */
    double calMbRt(SrmToolParas srmToolParas);

    /**
     * 计算环境压强
     * @param srmToolParas
     * @return
     */
    double calPa(SrmToolParas srmToolParas);

    /**
     * 计算出口压强
     * @param srmToolParas
     * @return
     */
    double calPe(SrmToolParas srmToolParas);

    /**
     * 计算比冲
     * @param srmToolParas
     * @return
     */
    double calIsp(SrmToolParas srmToolParas);

    /**
     * 计算推力
     * @param srmToolParas
     * @return
     */
    double calF(SrmToolParas srmToolParas);

    /**
     * 计算燃速
     * @param srmToolParas
     * @return
     */
    double calR(SrmToolParas srmToolParas);

    /**
     * 计算喷管初始膨胀半角
     * @param srmToolParas
     * @return
     */
    double calEps(SrmToolParas srmToolParas);
}
