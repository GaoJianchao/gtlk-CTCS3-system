package com.gtlk.service.prototype;

import java.util.List;
import java.util.Date;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.gtlk.entity.RuleInfo;
import com.gtlk.entity.TestMonitorInfo;
import com.gtlk.service.prototype.IGenericService;

public interface TestMonitorInfoService extends IGenericService<TestMonitorInfo, Integer> {
	//-- 如有别的业务方法需要就再自己写
	public List<TestMonitorInfo> findTestMonitorInfo(Object[] params);
	public HSSFWorkbook export(String title, Object[] params);
	
	//public List<TestMonitorInfo> findByCasetype(Integer typeId,String timeType,String startTime,String endTime);
	public TestMonitorInfo findByNum(Date runningTime,String trainNum);
	public int findByDegradationType(String degradationType);
	public int findByDegradationType();
}
