package com.gtlk.service.prototype;

import java.util.List;
import java.util.Date;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.gtlk.entity.TrainMonitorInfo;
import com.gtlk.service.prototype.IGenericService;

public interface TrainMonitorInfoService extends IGenericService<TrainMonitorInfo, Integer> {
	//-- ���б��ҵ�񷽷���Ҫ�����Լ�д
	public List<TrainMonitorInfo> findTrainMonitorInfo(Object[] params);
	public HSSFWorkbook export(String title, Object[] params);
	
	//public List<TrainMonitorInfo> findByCasetype(Integer typeId,String timeType,String startTime,String endTime);
	public TrainMonitorInfo findByNum(Date runningTime,String trainNum);
	public int findByDegradationType(String degradationType);
	public int findByDegradationType();
}
