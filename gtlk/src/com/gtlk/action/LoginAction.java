package com.gtlk.action;
import com.opensymphony.xwork2.ActionSupport;
import com.gtlk.service.prototype.LoginService;
@SuppressWarnings("serial")
public class LoginAction extends ActionSupport{
	private LoginService loginService;
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	public String login(){
		boolean flag = loginService.login(username, password);//�������ݿ��ѯ��������֤�û���������
		
		if(flag){
			return "success";
			//return SUCCESS;
		}else{
			//return ERROR;
			return "error";
		}
	}
	
}
