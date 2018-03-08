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
	//-- 如有别的业务方法需要就再自己写
	
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
	@SramLog(desc="修改取保候审人员信息")
	public void modify(TestMonitorInfo entity) {
		super.modify(entity);
	}

	@Override
	@SramLog(desc="删除取保候审人员信息")
	public void remove(TestMonitorInfo entity) {
		super.remove(entity);
	}

	@Override
	@SramLog(desc="添加取保候审人员信息")
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
