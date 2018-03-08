package com.gtlk.service.impl;


import java.util.List;
import java.util.Date;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.gtlk.dao.prototype.RuleInfoDao;
import com.gtlk.dao.prototype.TestMonitorInfoDao;
import com.gtlk.entity.RuleInfo;
import com.sram.log.ann.SramLog;
import com.gtlk.service.prototype.RuleInfoService;
import com.gtlk.service.impl.GenericServiceImpl;
//import com.sram.util.common.ExportExcel;

public class RuleInfoServiceImpl extends GenericServiceImpl<RuleInfo, Integer> implements RuleInfoService {
	//-- ���б��ҵ�񷽷���Ҫ�����Լ�д
	private RuleInfoDao ruleInfoDao;
	public RuleInfoDao getRuleInfoDao() {
		return ruleInfoDao;
	}
	public void setRuleInfoDao(RuleInfoDao ruleInfoDao) {
		this.ruleInfoDao = ruleInfoDao;
	}
	public List<RuleInfo> findRuleInfo(Object[] params){
		
		return null;
	}
	
	public List<RuleInfo> findByCreatTime() {
		return ((RuleInfoDao)getDao()).findByCreatTime();
	}
	
	public HSSFWorkbook export(String title, Object[] params){
		return null;
	}
	
	//public List<RuleInfo> findByCasetype(Integer typeId,String timeType,String startTime,String endTime);
	public RuleInfo findByNum(Date runningTime,String trainNum){
		return null;
	}
	@Override
	@SramLog(desc="�޸�ȡ��������Ա��Ϣ")
	public void modify(RuleInfo entity) {
		super.modify(entity);
	}

	@Override
	@SramLog(desc="ɾ��ȡ��������Ա��Ϣ")
	public void remove(RuleInfo entity) {
		super.remove(entity);
	}

	@Override
	@SramLog(desc="���ȡ��������Ա��Ϣ")
	public Integer save(RuleInfo entity) {
		return super.save(entity);
	}
	
	public List<RuleInfo> findRuleInfo(String s) {
		return ruleInfoDao.findRuleInfo(s);
	}
	
}
