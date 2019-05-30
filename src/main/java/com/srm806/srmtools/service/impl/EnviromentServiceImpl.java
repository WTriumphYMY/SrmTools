package com.srm806.srmtools.service.impl;

import com.srm806.srmtools.domain.EnvironmentParas;
import com.srm806.srmtools.repository.EnvRepository;
import com.srm806.srmtools.service.EnviromentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EnviromentServiceImpl implements EnviromentService {

	@Autowired
	private EnvRepository envRepository;

	@Override
	public void addEnv(EnvironmentParas env) {
		envRepository.save(env);
	}

	@Override
	public EnvironmentParas getEnvBySrmName(String srmName) {
		return envRepository.findBySrmName(srmName);
	}

	@Override
	public void updateEnvBySrmName(EnvironmentParas env) {
		EnvironmentParas oldEnv = getEnvBySrmName(env.getSrmName());
		env.setEnvId(oldEnv.getEnvId());
		envRepository.save(env);
	}
}
