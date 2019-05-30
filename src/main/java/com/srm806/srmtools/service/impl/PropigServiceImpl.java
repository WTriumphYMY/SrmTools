package com.srm806.srmtools.service.impl;


import com.srm806.srmtools.domain.PropellantIgParas;
import com.srm806.srmtools.repository.PropigRepository;
import com.srm806.srmtools.service.PropigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PropigServiceImpl implements PropigService {

	@Autowired
	private PropigRepository propigRepository;


	@Override
	public void addPropig(PropellantIgParas propIg) {
		propigRepository.save(propIg);
	}

	@Override
	public PropellantIgParas getPropigBySrmName(String srmName) {
		return propigRepository.findBySrmName(srmName);
	}

	@Override
	public void updatePropigBySrmName(PropellantIgParas propIg) {
		PropellantIgParas oldPropig = getPropigBySrmName(propIg.getSrmName());
		propIg.setIgPropId(oldPropig.getIgPropId());
		propigRepository.save(propIg);
	}
}
