package com.srm806.srmtools.service;

import java.io.File;
import java.util.List;
import java.util.Map;
import com.srm806.srmtools.domain.SrmVO;

public interface BalisticService {

	public Map<String, List> calBals(SrmVO srmVO, File igGrain, File mainGrain) throws Exception;
}
