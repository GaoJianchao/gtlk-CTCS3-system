package com.gtlk.service.prototype;

import java.util.List;
import java.util.Date;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.gtlk.entity.TrainDelayInfo;
import com.gtlk.service.prototype.IGenericService;

public interface TrainDelayInfoService extends IGenericService<TrainDelayInfo, Integer> {
	//-- 如有别的业务方法需要就再自己写
	public List<TrainDelayInfo> findTrainDelayInfo(Object[] params);
	public HSSFWorkbook export(String title, Object[] params);
	
	//public List<TrainDelayInfo> findByCasetype(Integer typeId,String timeType,String startTime,String endTime);
	public TrainDelayInfo findByNum(Date runningTime,String trainNum);
	public int findTrainDelayInfo();
}
