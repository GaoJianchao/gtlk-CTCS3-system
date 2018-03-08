package com.gtlk.action;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

//import com.gtlk.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.gtlk.entity.User;
import com.sram.util.pager.PagerModel;
import com.sram.util.system.SystemContext;
import com.gtlk.service.prototype.UserService;


@SuppressWarnings("serial")
public class UserAction extends ActionSupport{
	private List<User> objs;
	private Integer oid;
	private User obj;
	private List<Integer> oids;
	private String userName;
	private String identity;
	private String password1;
	private String password2;
	private UserService UserService;
	
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public Integer getOid() {
		return oid;
	}
	public UserService getUserService() {
		return UserService;
	}
	public void setUserService(
			UserService UserService) {
		this.UserService = UserService;
	}
	
	
	public List<User> getObjs() {
		return objs;
	}
	public void setObjs(List<User> objs) {
		this.objs = objs;
	}
	
	public List<Integer> getOids() {
		return oids;
	}
	public void setOids(List<Integer> oids) {
		this.oids = oids;
	}
	
	public User getObj() {
		return obj;
	}
	public void setObj(User obj) {
		this.obj = obj;
	}
	@SuppressWarnings("unchecked")
	public String list() throws Exception {
		SystemContext.setPagesize(20);
		PagerModel pm = UserService.pageFind(new Object[]{
				userName,identity});
		objs = pm.getDatas();
		pm.setDatas(objs);
		ServletActionContext.getRequest().setAttribute("pm", pm);
		return SUCCESS;
	}
	
	public String addPage(){
		return SUCCESS;
	}
	
	public String add(){
		User temp=new User();
		temp.setIdentity(identity);
		temp.setUserName(userName);
		temp.setPassword(password1);
		return SUCCESS;
	}
	
	public String delete(){
		if(oids!=null){					
			for(Integer id:oids){
				System.out.println("sdfsdfsd3");
				UserService.remove(UserService.findById(id));
		  }
		}
		else
		   System.out.println("sdfsdfsd4");
		return SUCCESS;
	}
	
	public String editPage(){
		if(oid != null){
			obj = UserService.findById(oid);
		}
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String edit(){
		User b = obj;
		User temp = UserService.findById(b.getOid());
		temp.setUserName(b.getUserName());
		temp.setPassword(b.getPassword());
		temp.setIdentity(b.getIdentity());
		UserService.modify(temp);
		return SUCCESS;
	}
	
	
	
}
