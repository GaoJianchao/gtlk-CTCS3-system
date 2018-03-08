package com.gtlk.service.impl;


import java.util.List;
import java.util.Date;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.gtlk.dao.prototype.TestMonitorInfoDao;
import com.gtlk.dao.prototype.TrainMonitorInfoDao;
import com.gtlk.entity.RuleInfo;
import com.gtlk.entity.TestMonitorInfo;
import com.sram.log.ann.SramLog;
import com.gtlk.service.prototype.TestMonitorInfoService;
import com.gtlk.service.impl.GenericServiceImpl;
//import com.sram.util.common.ExportExcel;

public class TestMonitorInfoServiceImpl extends GenericServiceImpl<TestMonitorInfo, Integer> implements TestMonitorInfoService {
	//-- ���б��ҵ�񷽷���Ҫ�����Լ�д
	
	public List<TestMonitorInfo> findTestMonitorInfo(Object[] params){
		return null;
	}
	public HSSFWorkbook export(String title, Object[] params){
		return null;
	}
	
	//public List<TestMonitorInfo> findByCasetype(Integer typeId,String timeType,String startTime,String endTime);
	public TestMonitorInfo findByNum(Date runningTime,String trainNum){
		return null;
	}
	@Override
	@SramLog(desc="�޸�ȡ��������Ա��Ϣ")
	public void modify(TestMonitorInfo entity) {
		super.modify(entity);
	}

	@Override
	@SramLog(desc="ɾ��ȡ��������Ա��Ϣ")
	public void remove(TestMonitorInfo entity) {
		super.remove(entity);
	}

	@Override
	@SramLog(desc="���ȡ��������Ա��Ϣ")
	public Integer save(TestMonitorInfo entity) {
		return super.save(entity);
	}
	
	public int findByDegradationType(String degradationType){
		return ((TestMonitorInfoDao)getDao()).findByDegradationType(degradationType);
	}
	
	public int findByDegradationType(){
		return ((TestMonitorInfoDao)getDao()).findByDegradationType();
	}
}
