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
	//-- ���б��ҵ�񷽷���Ҫ�����Լ�д
	
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
	@SramLog(desc="�޸�ȡ��������Ա��Ϣ")
	public void modify(TrainDelayInfo entity) {
		super.modify(entity);
	}

	@Override
	@SramLog(desc="ɾ��ȡ��������Ա��Ϣ")
	public void remove(TrainDelayInfo entity) {
		super.remove(entity);
	}

	@Override
	@SramLog(desc="���ȡ��������Ա��Ϣ")
	public Integer save(TrainDelayInfo entity) {
		return super.save(entity);
	}
	
	public int findTrainDelayInfo(){
		return ((TrainDelayInfoDao)getDao()).findTrainDelayInfo();
	}
	
	
}
