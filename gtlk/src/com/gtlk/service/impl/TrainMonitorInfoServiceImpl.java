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
	//-- ���б��ҵ�񷽷���Ҫ�����Լ�д
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
	@SramLog(desc="�޸�ȡ��������Ա��Ϣ")
	public void modify(TrainMonitorInfo entity) {
		super.modify(entity);
	}
	@Override
	@SramLog(desc="ɾ��ȡ��������Ա��Ϣ")
	public void remove(TrainMonitorInfo entity) {
		super.remove(entity);
	}
	@Override
	@SramLog(desc="���ȡ��������Ա��Ϣ")
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
