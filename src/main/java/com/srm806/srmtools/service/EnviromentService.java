package com.srm806.srmtools.service;


import com.srm806.srmtools.domain.EnvironmentParas;

public interface EnviromentService {

	public void addEnv(EnvironmentParas env);
	public EnvironmentParas getEnvBySrmName(String srmName);
	public void updateEnvBySrmName(EnvironmentParas env);
}
