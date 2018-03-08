package com.gtlk.dao.impl;

import java.util.List;
import com.gtlk.dao.impl.GenericDaoImpl;
import com.gtlk.entity.User;
import com.gtlk.dao.prototype.LoginDao;
import com.sram.util.pager.PagerModel;

public class LoginDaoImpl extends GenericDaoImpl<User,Integer> implements LoginDao{

	public LoginDaoImpl(String type) {
		super(type);
	}
	
	@Override
	public User getUserByName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByNameAndPass(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PagerModel pageFind() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PagerModel pageFind(Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PagerModel pageFind(Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean login(String username, String password) {
		List<User> u = this.getHibernateTemplate().find("from User where username=? and password=?",username,password);
		boolean flag = false;
		if(u.size() > 0){
			flag = true;
		}
		/*boolean flag = false;
		if(username.equals("admin")&&password.equals("123456"))
			flag = true;*/
		return flag;
	}

	
}
