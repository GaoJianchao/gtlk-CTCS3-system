package com.gtlk.dao.prototype;

import java.util.Date;
import java.util.List;
import com.gtlk.entity.TrainDelayInfo;
import com.gtlk.dao.prototype.IGenericDao;

public interface TrainDelayInfoDao extends IGenericDao <TrainDelayInfo, Integer>{
	public List<TrainDelayInfo> findTrainDelayInfo(Object[] params);
	
	//public List<TrainDelayInfo> findByCasetype(Integer typeId,String timeType,String startTime,String endTime);

	public TrainDelayInfo findByNum(Date runningTime,String trainNum);
	public int findTrainDelayInfo();
}
