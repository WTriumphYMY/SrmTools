package com.srm806.srmtools.service;


import com.srm806.srmtools.domain.RocketParas;

public interface MotorService {

	public void addMotor(RocketParas motor);
	public RocketParas getMotorBySrmName(String srmName);
	public void updateMotorBySrmName(RocketParas motor);
}
