package com.gtlk.service.impl;


import java.util.List;
import java.util.Date;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.gtlk.entity.TestDelayInfo;
import com.gtlk.dao.prototype.TestDelayInfoDao;
import com.gtlk.dao.prototype.TrainDelayInfoDao;
import com.sram.log.ann.SramLog;
import com.gtlk.service.prototype.TestDelayInfoService;
import com.gtlk.service.impl.GenericServiceImpl;
//import com.sram.util.common.ExportExcel;

public class TestDelayInfoServiceImpl extends GenericServiceImpl<TestDelayInfo, Integer> implements TestDelayInfoService {
	//-- ���б��ҵ�񷽷���Ҫ�����Լ�д
	
	public List<TestDelayInfo> findTestDelayInfo(Object[] params){
		return ((TestDelayInfoDao)getDao()).findTestDelayInfo(params);
	}
	public HSSFWorkbook export(String title, Object[] params){
		return null;
	}
	
	//public List<TestDelayInfo> findByCasetype(Integer typeId,String timeType,String startTime,String endTime);
	public TestDelayInfo findByNum(Date runningTime,String trainNum){
		return null;
	}
	@Override
	@SramLog(desc="�޸�ȡ��������Ա��Ϣ")
	public void modify(TestDelayInfo entity) {
		super.modify(entity);
	}

	@Override
	@SramLog(desc="ɾ��ȡ��������Ա��Ϣ")
	public void remove(TestDelayInfo entity) {
		super.remove(entity);
	}

	@Override
	@SramLog(desc="���ȡ��������Ա��Ϣ")
	public Integer save(TestDelayInfo entity) {
		return super.save(entity);
	}
	
	public int findTestDelayInfo(){
		return ((TestDelayInfoDao)getDao()).findTestDelayInfo();
	}
	
	public int findTestDelayInfo(String grade){
		return ((TestDelayInfoDao)getDao()).findTestDelayInfo(grade);
	}
}
