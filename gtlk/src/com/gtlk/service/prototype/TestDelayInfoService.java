package com.gtlk.service.prototype;

import java.util.List;
import java.util.Date;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.gtlk.entity.TestDelayInfo;
import com.gtlk.service.prototype.IGenericService;

public interface TestDelayInfoService extends IGenericService<TestDelayInfo, Integer> {
	//-- 如有别的业务方法需要就再自己写
	public List<TestDelayInfo> findTestDelayInfo(Object[] params);
	public HSSFWorkbook export(String title, Object[] params);
	
	//public List<TestDelayInfo> findByCasetype(Integer typeId,String timeType,String startTime,String endTime);
	public TestDelayInfo findByNum(Date runningTime,String trainNum);
	public int findTestDelayInfo(String grade);
	public int findTestDelayInfo();
}
