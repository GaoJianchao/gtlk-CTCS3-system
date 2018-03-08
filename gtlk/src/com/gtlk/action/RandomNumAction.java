package com.gtlk.action;

import java.io.ByteArrayInputStream;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.gtlk.util.RandomNumUtil;

@SuppressWarnings("serial")
public class RandomNumAction extends ActionSupport {
	private RandomNumUtil randomNum;
	private ByteArrayInputStream inputStream;
	// éªŒè¯ç ?
	private String rand;
	private String responseStr;
	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(ByteArrayInputStream inputStream) {
		this.inputStream = inputStream;
	}

	public RandomNumUtil getRandomNum() {
		return randomNum;
	}

	public void setRandomNum(RandomNumUtil randomNum) {
		this.randomNum = randomNum;
	}

	public String getRand() {
		return rand;
	}

	public void setRand(String rand) {
		this.rand = rand;
	}

	public String getResponseStr() {
		return responseStr;
	}

	public void setResponseStr(String responseStr) {
		this.responseStr = responseStr;
	}

	@Override
	public String execute() throws Exception {
		randomNum = new RandomNumUtil(70, 24, 4, 22);
		this.setInputStream(randomNum.getInputStream());
		ActionContext.getContext().getSession()
				.put("random", randomNum.getRandomCode());

		return SUCCESS;
	}

	public String goRegister() {
		return "success";
	}
	
	//--éªŒè¯éªŒè¯ç ?
	public String validataCode(){
		String randStr = ((String) ActionContext.getContext().getSession().get(
		"random")).toLowerCase();
			if ("".equals(getRand().toLowerCase())
					|| getRand().toLowerCase() == null) {
				responseStr = "ÇëÊäÈëÑéÖ¤Âë";
			} else if (!randStr.equals(getRand().toLowerCase())) {
				// addFieldError("randomNum","éªŒè¯ç é”™è¯?);
				responseStr = "ÑéÖ¤Âë´íÎó";
			} else if (randStr.equals(getRand().toLowerCase())) {
				responseStr = "";
			}
		return SUCCESS;
	}
}
