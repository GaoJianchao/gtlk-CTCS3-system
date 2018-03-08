package com.gtlk.service.impl;


import java.util.List;
import java.util.Date;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.gtlk.dao.prototype.UserDao;
import com.gtlk.dao.prototype.TestMonitorInfoDao;
import com.gtlk.entity.User;
import com.sram.log.ann.SramLog;
import com.gtlk.service.prototype.UserService;
import com.gtlk.service.impl.GenericServiceImpl;
//import com.sram.util.common.ExportExcel;

public class UserServiceImpl extends GenericServiceImpl<User, Integer> implements UserService {
	//-- 如有别的业务方法需要就再自己写
	private UserDao UserDao;
	public UserDao getUserDao() {
		return UserDao;
	}
	public void setUserDao(UserDao UserDao) {
		this.UserDao = UserDao;
	}
	public List<User> findUser(Object[] params){
		
		return null;
	}
	
	public List<User> findByCreatTime() {
		return ((UserDao)getDao()).findByCreatTime();
	}
	
	public HSSFWorkbook export(String title, Object[] params){
		return null;
	}
	
	//public List<User> findByCasetype(Integer typeId,String timeType,String startTime,String endTime);
	public User findByNum(Date runningTime,String trainNum){
		return null;
	}
	@Override
	@SramLog(desc="修改取保候审人员信息")
	public void modify(User entity) {
		super.modify(entity);
	}

	@Override
	@SramLog(desc="删除取保候审人员信息")
	public void remove(User entity) {
		super.remove(entity);
	}

	@Override
	@SramLog(desc="添加取保候审人员信息")
	public Integer save(User entity) {
		return super.save(entity);
	}
	
	public List<User> findUser(String s) {
		return UserDao.findUser(s);
	}
	
}
