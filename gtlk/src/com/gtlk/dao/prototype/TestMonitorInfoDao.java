package com.gtlk.dao.prototype;

import java.util.Date;
import java.util.List;

import com.gtlk.entity.RuleInfo;
import com.gtlk.entity.TestMonitorInfo;
import com.gtlk.dao.prototype.IGenericDao;

public interface TestMonitorInfoDao extends IGenericDao <TestMonitorInfo, Integer>{
	public List<TestMonitorInfo> findTestMonitorInfo(Object[] params);
	
	//public List<TestMonitorInfo> findByCasetype(Integer typeId,String timeType,String startTime,String endTime);

	public TestMonitorInfo findByNum(Date runningTime,String trainNum);
	public int findByDegradationType(String degradationType);
	public int findByDegradationType();
	
}
