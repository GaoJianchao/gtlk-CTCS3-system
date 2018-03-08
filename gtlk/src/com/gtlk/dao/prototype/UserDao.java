package com.gtlk.dao.prototype;

import java.util.Date;
import java.util.List;
import com.gtlk.entity.User;
import com.gtlk.dao.prototype.IGenericDao;

public interface UserDao extends IGenericDao <User, Integer>{
	public List<User> findUser(Object[] params);
	
	//public List<User> findByCasetype(Integer typeId,String timeType,String startTime,String endTime);

	public User findByNum(Date runningTime,String trainNum);
	
	public List<User> findUser(String s);

	public List<User> findByCreatTime();
}
