package com.gtlk.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.gtlk.entity.RuleInfo;
import com.gtlk.entity.TestMonitorInfo;
import com.gtlk.entity.TrainMonitorInfo;
import com.gtlk.entity.User;
import com.gtlk.dao.prototype.TestMonitorInfoDao;
import com.gtlk.dao.impl.GenericDaoImpl;
import com.sram.util.pager.PagerModel;

public class TestMonitorInfoDaoImpl extends GenericDaoImpl<TestMonitorInfo, Integer> implements TestMonitorInfoDao{
	public TestMonitorInfoDaoImpl(String type) {
		
		super(type);
		System.out.println("TestMonitorInfoDaoImpl");
	}
	//-- 普通的分页查找
	@Override
	public PagerModel pageFind() {
		 return findPaginated("from TrainMonitor order by oid desc");
	}
	//-- 带单个查询条件的分页查找
	@Override
	public PagerModel pageFind(Object param) {
		 return null;
	}
	//-- 带多个查询条件的分页查找
	@Override
	public PagerModel pageFind(Object[] params) {
		String s = concat(params);
		 return findPaginated(s);
	}
	
	private String concat(Object[] params){
		StringBuffer sb = new StringBuffer("from TestMonitorInfo as b where 1=1");
		if(params[0] != null && !"".equals(params[0])){
			sb.append(" and b.casenum.casenum like '%" + params[0] + "%'");
		}
		if(params[1] != null && !"".equals(params[1])){
			sb.append(" and b.casenum.casetype.name like '%" + params[1] + "%'");
		}
		if(params[2] != null && !"".equals(params[2])){
			sb.append(" and b.casenum.managestation like '%" + params[2] + "%'");
		}
		if(params[3] != null && !"".equals(params[3])){
			sb.append(" and b.suspect.name like '%" + params[3] + "%'");
		}
		if(params[4] != null && !"".equals(params[4])){
			sb.append(" and b.suspect.identity like '%" + params[4] + "%'");
		}
		if(params[5] != null && !"".equals(params[5])){
			sb.append(" and b.bailways like '%" + params[5] + "%'");
		}
		
		if(params[6] != null && !"".equals(params[6]) && params[7] != null && !"".equals(params[7])){
			sb.append(" and b.bailtime >= '" + convert(params[6]) + " 00:00:00' and b.bailtime <= '" + convert(params[7]) + " 23:59:59'");
		}
		sb.append(" order by oid desc");
		
		//System.out.println("====="+sb.toString()+"======");
		return sb.toString();
	}
	
	private String convert(Object o){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String s = sdf.format(o);
		return s;	
	}
	
	public List<TestMonitorInfo> findTestMonitorInfo(Object[] params){
		
		
		return null;
	}
	
	//public List<TestMonitorInfo> findByCasetype(Integer typeId,String timeType,String startTime,String endTime);

	public TestMonitorInfo findByNum(Date runningTime,String trainNum){
		
		return null;
	}
	
	public int findByDegradationType(String degradationType){
		String s = "from TestMonitorInfo where degradationType = '" + degradationType + "'";
		@SuppressWarnings("unchecked")
		List<TestMonitorInfo> list = getHibernateTemplate().find(s);
		return list.size();
	}
	
	public int findByDegradationType(){
		String s = "from TestMonitorInfo";
		@SuppressWarnings("unchecked")
		List<TestMonitorInfo> list = getHibernateTemplate().find(s);
		return list.size();
	}
}

