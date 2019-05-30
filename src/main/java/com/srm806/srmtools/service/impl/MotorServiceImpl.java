package com.srm806.srmtools.service.impl;

import com.srm806.srmtools.domain.RocketParas;
import com.srm806.srmtools.repository.MotorRepository;
import com.srm806.srmtools.service.MotorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MotorServiceImpl implements MotorService {

	@Autowired
	private MotorRepository motorRepository;


	@Override
	public void addMotor(RocketParas motor) {
		motorRepository.save(motor);
	}

	@Override
	public RocketParas getMotorBySrmName(String srmName) {
		return motorRepository.findBySrmName(srmName);
	}

	@Override
	public void updateMotorBySrmName(RocketParas motor) {
		RocketParas oldMotor = getMotorBySrmName(motor.getSrmName());
		motor.setRocketId(oldMotor.getRocketId());
		motorRepository.save(motor);
	}
}
