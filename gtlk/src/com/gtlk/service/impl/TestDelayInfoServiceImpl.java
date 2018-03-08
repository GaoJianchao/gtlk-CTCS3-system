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
	//-- 如有别的业务方法需要就再自己写
	
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
	@SramLog(desc="修改取保候审人员信息")
	public void modify(TestDelayInfo entity) {
		super.modify(entity);
	}

	@Override
	@SramLog(desc="删除取保候审人员信息")
	public void remove(TestDelayInfo entity) {
		super.remove(entity);
	}

	@Override
	@SramLog(desc="添加取保候审人员信息")
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
