package com.srm806.srmtools.service;

import com.srm806.srmtools.domain.PropellantMainParas;

public interface PropMainService {
    public void addPropmain(PropellantMainParas propMain);
    public PropellantMainParas getPropmainBySrmName(String srmName);
    public void updatePropmainBySrmName(PropellantMainParas propMain);
}
