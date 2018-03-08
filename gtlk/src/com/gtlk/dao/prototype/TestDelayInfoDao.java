package com.gtlk.dao.prototype;

import java.util.Date;
import java.util.List;
import com.gtlk.entity.TestDelayInfo;
import com.gtlk.dao.prototype.IGenericDao;

public interface TestDelayInfoDao extends IGenericDao <TestDelayInfo, Integer>{
	public List<TestDelayInfo> findTestDelayInfo(Object[] params);
	
	//public List<TestDelayInfo> findByCasetype(Integer typeId,String timeType,String startTime,String endTime);

	public TestDelayInfo findByNum(Date runningTime,String trainNum);
	public int findTestDelayInfo(String grade);
	public int findTestDelayInfo();
}
