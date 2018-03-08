package com.gtlk.entity;

public class User {
	private Integer oid;
	/**µÇÂ½ÕÊºÅ**/
	private String userName;
	/***µÇÂ½ÃÜÂë**/
	private String password;
	private String identity;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	
}
