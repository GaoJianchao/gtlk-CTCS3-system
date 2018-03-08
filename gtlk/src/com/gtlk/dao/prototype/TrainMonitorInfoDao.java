package com.gtlk.dao.prototype;

import java.util.Date;
import java.util.List;
import com.gtlk.entity.TrainMonitorInfo;
import com.gtlk.dao.prototype.IGenericDao;

public interface TrainMonitorInfoDao extends IGenericDao <TrainMonitorInfo, Integer>{
	public List<TrainMonitorInfo> findTrainMonitorInfo(Object[] params);
	
	//public List<TrainMonitorInfo> findByCasetype(Integer typeId,String timeType,String startTime,String endTime);

	public TrainMonitorInfo findByNum(Date runningTime,String trainNum);

	public int findTrainMonitorInfo(String degradationType);
	public int findTrainMonitorInfo();
}
