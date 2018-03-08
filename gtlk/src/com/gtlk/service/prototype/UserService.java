package com.gtlk.service.prototype;

import java.util.List;
import java.util.Date;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.gtlk.entity.User;
import com.gtlk.service.prototype.IGenericService;

public interface UserService extends IGenericService<User, Integer> {
	//-- 如有别的业务方法需要就再自己写
	public List<User> findUser(Object[] params);
	public HSSFWorkbook export(String title, Object[] params);
	
	//public List<UserService> findByCasetype(Integer typeId,String timeType,String startTime,String endTime);
	public User findByNum(Date runningTime,String trainNum);
	public List<User> findUser(String s);
	public List<User> findByCreatTime();
}
