package com.srm806.srmtools.service.impl;

import com.srm806.srmtools.algorithm.SrmFunc;
import com.srm806.srmtools.domain.SrmToolParas;
import com.srm806.srmtools.service.SrmToolsService;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

/**
 * @ClassName SrmToolsServiceImpl
 * @Author: wkx
 * @Date: 2020/1/10 21:15
 * @Version: v1.0
 * @Description:
 */
@Service
public class SrmToolsServiceImpl implements SrmToolsService {

    private double s1;
    private double s2;
    private double s3;
    private double s4;
    private double s5;
    private double s6;
    private double s7;
    private double s8;
    private double s9;

    @Override
    public double calPc(SrmToolParas srmToolParas) {
        setData(srmToolParas);
        double at = Math.PI*s7*s7*1e-6;
        double pc = SrmFunc.PressureExt(s1, s6, s2, s3, at, s5, s8, s9, s4);
        return pc;
    }

    @Override
    public double calCd(SrmToolParas srmToolParas) {
        setData(srmToolParas);
        double cDelta = SrmFunc.CalcucDelta(s1, s2, s3, s4);
        return cDelta;
    }

    @Override
    public double calAb(SrmToolParas srmToolParas) {
        setData(srmToolParas);
        double at = Math.PI*s7*s7*1e-6;
        double ab = SrmFunc.CalcuAb(at, s3, s5, s1, s6, s2);
        return ab;
    }

    @Override
    public double calRt(SrmToolParas srmToolParas) {
        setData(srmToolParas);
        double at=SrmFunc.CalcuAt(s3, s7, s5, s1, s6, s2);
        double rt=Math.sqrt(at/ Math.PI)*1000.0;
        return rt;
    }

    @Override
    public double calMbRt(SrmToolParas srmToolParas) {
        setData(srmToolParas);
        double at = SrmFunc.CalcuAt(s3, s1, s2);
        double rt=Math.sqrt(at/ Math.PI)*1000.0;
        return rt;
    }

    @Override
    public double calPa(SrmToolParas srmToolParas) {
        setData(srmToolParas);
        SrmFunc srmFunc = new SrmFunc();
        SrmFunc.airParasClass P=srmFunc.new airParasClass();
        srmFunc.AirParas(s1,P);
        return P.P0;
    }

    @Override
    public double calPe(SrmToolParas srmToolParas) {
        setData(srmToolParas);
        double pe = SrmFunc.CalcuPe(s3, s1, s2);
        return pe;
    }

    @Override
    public double calIsp(SrmToolParas srmToolParas) {
        setData(srmToolParas);
        SrmFunc srmFunc = new SrmFunc();
        SrmFunc.airParasClass P=srmFunc.new airParasClass();
        srmFunc.AirParas(s2,P);
        double cf = srmFunc.CoeForce(s7, s3, P.P0/s5);
        double isp = srmFunc.CalcuIsp(s1, cf);
        return isp;
    }

    @Override
    public double calF(SrmToolParas srmToolParas) {
        setData(srmToolParas);
        SrmFunc srmFunc = new SrmFunc();
        SrmFunc.airParasClass P=srmFunc.new airParasClass();
        srmFunc.AirParas(s1,P);
        double cf = srmFunc.CoeForce(s7, s2, P.P0/s5);
        double at = Math.PI*s4*s4*1e-6;
        double f = srmFunc.Force(s5, at, cf);
        return f;
    }

    @Override
    public double calR(SrmToolParas srmToolParas) {
        setData(srmToolParas);
        double rb = SrmFunc.CalcuRb(s1, s2, s3);
        return rb;
    }

    @Override
    public double calEps(SrmToolParas srmToolParas) {
        setData(srmToolParas);
        double alpha = SrmFunc.GetNozzleAlphaM(s1, s2);
        return alpha;
    }

    private void setData(SrmToolParas srmToolParas){
        s1 = srmToolParas.getS1();
        s2 = srmToolParas.getS2();
        s3 = srmToolParas.getS3();
        s4 = srmToolParas.getS4();
        s5 = srmToolParas.getS5();
        s6 = srmToolParas.getS6();
        s7 = srmToolParas.getS7();
        s8 = srmToolParas.getS8();
        s9 = srmToolParas.getS9();
    }
}
