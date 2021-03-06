package com.gtlk.service.impl;


import java.util.List;
import java.util.Date;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import com.gtlk.entity.TrainDelayInfo;
import com.gtlk.dao.prototype.TrainDelayInfoDao;
import com.gtlk.dao.prototype.TrainMonitorInfoDao;
import com.sram.log.ann.SramLog;
import com.gtlk.service.prototype.TrainDelayInfoService;
import com.gtlk.service.impl.GenericServiceImpl;
//import com.sram.util.common.ExportExcel;

public class TrainDelayInfoServiceImpl extends GenericServiceImpl<TrainDelayInfo, Integer> implements TrainDelayInfoService {
	//-- 如有别的业务方法需要就再自己写
	
	public List<TrainDelayInfo> findTrainDelayInfo(Object[] params){
		return ((TrainDelayInfoDao)getDao()).findTrainDelayInfo(params);
	}
	public HSSFWorkbook export(String title, Object[] params){
		return null;
	}
	
	//public List<TrainDelayInfo> findByCasetype(Integer typeId,String timeType,String startTime,String endTime);
	public TrainDelayInfo findByNum(Date runningTime,String trainNum){
		return null;
	}
	@Override
	@SramLog(desc="修改取保候审人员信息")
	public void modify(TrainDelayInfo entity) {
		super.modify(entity);
	}

	@Override
	@SramLog(desc="删除取保候审人员信息")
	public void remove(TrainDelayInfo entity) {
		super.remove(entity);
	}

	@Override
	@SramLog(desc="添加取保候审人员信息")
	public Integer save(TrainDelayInfo entity) {
		return super.save(entity);
	}
	
	public int findTrainDelayInfo(){
		return ((TrainDelayInfoDao)getDao()).findTrainDelayInfo();
	}
	
	
}
