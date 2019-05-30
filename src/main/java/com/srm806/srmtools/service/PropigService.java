package com.srm806.srmtools.service;


import com.srm806.srmtools.domain.PropellantIgParas;

public interface PropigService {

	public void addPropig(PropellantIgParas propIg);
	public PropellantIgParas getPropigBySrmName(String srmName);
	public void updatePropigBySrmName(PropellantIgParas propIg);
}
