package com.srm806.srmtools.service.impl;

import com.srm806.srmtools.domain.PropellantMainParas;
import com.srm806.srmtools.repository.PropMainRepository;
import com.srm806.srmtools.service.PropMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PropmainServiceImpl implements PropMainService {

	@Autowired
	private PropMainRepository propMainRepository;


	@Override
	public void addPropmain(PropellantMainParas propMain) {
		propMainRepository.save(propMain);
	}

	@Override
	public PropellantMainParas getPropmainBySrmName(String srmName) {
		return propMainRepository.findBySrmName(srmName);
	}

	@Override
	public void updatePropmainBySrmName(PropellantMainParas propMain) {
		PropellantMainParas oldPropMain = getPropmainBySrmName(propMain.getSrmName());
		propMain.setMainPropId(oldPropMain.getMainPropId());
		propMainRepository.save(propMain);
	}
}
