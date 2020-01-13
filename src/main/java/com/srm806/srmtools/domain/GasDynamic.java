package com.srm806.srmtools.domain;

/**
 * @ClassName GasDynamic
 * @Author: wkx
 * @Date: 2020/1/12 21:29
 * @Version: v1.0
 * @Description: 气动常用参数domain类
 */
public class GasDynamic {
    private double k; //燃气比热比
    private double lambdaOrMach; //气流λ或马赫数
    private double angle; //气流转折角（°）
    private String type; //计算类型
    public double getK() {
        return k;
    }

    public void setK(double k) {
        this.k = k;
    }

    public double getLambdaOrMach() {
        return lambdaOrMach;
    }

    public void setLambdaOrMach(double lambdaOrMach) {
        this.lambdaOrMach = lambdaOrMach;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
