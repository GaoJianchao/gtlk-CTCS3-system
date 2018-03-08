package com.gtlk.dao.prototype;

import java.util.Date;
import java.util.List;
import com.gtlk.entity.RuleInfo;
import com.gtlk.dao.prototype.IGenericDao;

public interface RuleInfoDao extends IGenericDao <RuleInfo, Integer>{
	public List<RuleInfo> findRuleInfo(Object[] params);
	
	//public List<RuleInfo> findByCasetype(Integer typeId,String timeType,String startTime,String endTime);

	public RuleInfo findByNum(Date runningTime,String trainNum);
	
	public List<RuleInfo> findRuleInfo(String s);

	public List<RuleInfo> findByCreatTime();
}
