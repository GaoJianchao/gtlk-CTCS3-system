package com.gtlk.service.prototype;

import java.util.List;
import java.util.Date;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.gtlk.entity.RuleInfo;
import com.gtlk.service.prototype.IGenericService;

public interface RuleInfoService extends IGenericService<RuleInfo, Integer> {
	//-- 如有别的业务方法需要就再自己写
	public List<RuleInfo> findRuleInfo(Object[] params);
	public HSSFWorkbook export(String title, Object[] params);
	
	//public List<RuleInfoService> findByCasetype(Integer typeId,String timeType,String startTime,String endTime);
	public RuleInfo findByNum(Date runningTime,String trainNum);
	public List<RuleInfo> findRuleInfo(String s);
	public List<RuleInfo> findByCreatTime();
}
