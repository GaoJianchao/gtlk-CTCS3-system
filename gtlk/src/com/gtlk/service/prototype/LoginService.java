package com.gtlk.service.prototype;

import com.gtlk.entity.User;
import com.gtlk.service.prototype.IGenericService;
import com.gtlk.dao.impl.LoginDaoImpl;

public interface LoginService extends IGenericService<User, Integer>{
	
	public void setLoginDao(LoginDaoImpl loginDao);
	
	public boolean login(String username, String password);

}
