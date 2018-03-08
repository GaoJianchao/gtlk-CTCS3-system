package com.gtlk.dao.prototype;

import java.util.List;
import com.gtlk.dao.prototype.IGenericDao;
import com.gtlk.entity.User;

public interface LoginDao extends IGenericDao<User, Integer>{
	public User getUserByName(String username);  
	  
    public List<User> findAllUser();  
  
    public User findUserByNameAndPass(String username, String password);
    
    public boolean login(String username,String password);
}
