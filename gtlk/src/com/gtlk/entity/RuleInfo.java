package com.gtlk.entity;

public class RuleInfo {
	private Integer oid;
	private String creatTime;
	private String rule;
	
	public RuleInfo(String creatTime, String rule) {
		//super();
		this.creatTime = creatTime;
		this.rule = rule;
	}
	public RuleInfo() {
	}
	public Integer getoid() {
		return oid;
	}
	public void setoid(Integer oid) {
		this.oid = oid;
	}
	public String getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(String creatTime) {
		this.creatTime = creatTime;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	public String toString(){
		return this.creatTime+" "+this.rule;
	}
	
}
