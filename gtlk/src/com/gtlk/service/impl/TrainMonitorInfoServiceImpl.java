package com.gtlk.service.impl;
import java.util.List;
import java.util.Date;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import com.gtlk.dao.prototype.TrainMonitorInfoDao;
import com.gtlk.entity.TrainMonitorInfo;
import com.sram.log.ann.SramLog;
import com.gtlk.service.prototype.TrainMonitorInfoService;
import com.gtlk.service.impl.GenericServiceImpl;
public class TrainMonitorInfoServiceImpl extends GenericServiceImpl<TrainMonitorInfo, Integer> implements TrainMonitorInfoService {
	//-- 如有别的业务方法需要就再自己写
	public List<TrainMonitorInfo> findTrainMonitorInfo(Object[] params){
		return null;
	}
	public HSSFWorkbook export(String title, Object[] params){
		return null;
	}
	public TrainMonitorInfo findByNum(Date runningTime,String trainNum){
		return null;
	}
	@Override
	@SramLog(desc="修改取保候审人员信息")
	public void modify(TrainMonitorInfo entity) {
		super.modify(entity);
	}
	@Override
	@SramLog(desc="删除取保候审人员信息")
	public void remove(TrainMonitorInfo entity) {
		super.remove(entity);
	}
	@Override
	@SramLog(desc="添加取保候审人员信息")
	public Integer save(TrainMonitorInfo entity) {
		return super.save(entity);
	}
	public int findByDegradationType(String degradationType){
		return ((TrainMonitorInfoDao)getDao()).findTrainMonitorInfo(degradationType);
	}
	public int findByDegradationType(){
		return ((TrainMonitorInfoDao)getDao()).findTrainMonitorInfo();
	}
	
}
