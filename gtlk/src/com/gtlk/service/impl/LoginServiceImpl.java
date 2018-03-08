package com.gtlk.service.impl;

import com.gtlk.dao.impl.LoginDaoImpl;
import com.gtlk.dao.prototype.LoginDao;
import com.gtlk.entity.User;
import com.gtlk.service.prototype.LoginService;
import com.gtlk.service.impl.GenericServiceImpl;

public class LoginServiceImpl extends GenericServiceImpl<User, Integer> implements LoginService{
	private LoginDao loginDao;
	public void setLoginDao(LoginDaoImpl loginDao){
		this.loginDao = loginDao;
	}
/*
	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		return loginDao.login(username, password);
	}


	public LoginDao getLoginDao() {
		return loginDao;
	}


	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	
	@Override

	public void setLoginDao(LoginDaoImpl loginDao) {
		this.loginDao = loginDao;
	}*/
	public boolean login(String username, String password) {
		return loginDao.login(username, password);
	}
}
