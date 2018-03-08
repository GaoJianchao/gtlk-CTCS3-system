package com.gtlk.action;
import com.opensymphony.xwork2.ActionSupport;
import com.gtlk.service.prototype.TestDelayInfoService;
import com.gtlk.service.prototype.TestMonitorInfoService;
import com.gtlk.service.prototype.TrainDelayInfoService;
import com.gtlk.service.prototype.TrainMonitorInfoService;
@SuppressWarnings("serial")
public class StatisticsAction extends ActionSupport{
	private int type0=0;
	private int type1=0;
	private int type2=0;
	private int type3=0;
	private int type4=0;
	private int type5=0;
	private int type6=0;
	private int type7=0;
	private int type8=0;
	private int type9=0;
	private int total=0;
	private String rate0;
	private String rate1;
	private String rate2;
	private String rate3;
	private String rate4;
	private String rate5;
	private String rate6;
	private String rate7;
	private String rate8;
	private String rate9;
	
	private int score0=0;
	private int score1=0;
	private int score2=0;
	private int score3=0;
	
	private int trainmi=0;
	private int testmi=0;
	private int traindi=0;
	private int testdi=0;
	
	private TrainMonitorInfoService trainMonitorInfoService;
	private TestMonitorInfoService testMonitorInfoService;
	private TrainDelayInfoService trainDelayInfoService;
	private TestDelayInfoService testDelayInfoService;
	
	public int getType0() {
		return type0;
	}
	public void setType0(int type0) {
		this.type0 = type0;
	}
	public int getType1() {
		return type1;
	}
	public void setType1(int type1) {
		this.type1 = type1;
	}
	public int getType2() {
		return type2;
	}
	public void setType2(int type2) {
		this.type2 = type2;
	}
	public int getType3() {
		return type3;
	}
	public void setType3(int type3) {
		this.type3 = type3;
	}
	public int getType4() {
		return type4;
	}
	public void setType4(int type4) {
		this.type4 = type4;
	}
	public int getType5() {
		return type5;
	}
	public void setType5(int type5) {
		this.type5 = type5;
	}
	public int getType6() {
		return type6;
	}
	public void setType6(int type6) {
		this.type6 = type6;
	}
	public int getType7() {
		return type7;
	}
	public void setType7(int type7) {
		this.type7 = type7;
	}
	public int getType8() {
		return type8;
	}
	public void setType8(int type8) {
		this.type8 = type8;
	}
	public int getType9() {
		return type9;
	}
	public void setType9(int type9) {
		this.type9 = type9;
	}
	public int getScore0() {
		return score0;
	}
	public void setScore0(int score0) {
		this.score0 = score0;
	}
	public int getScore1() {
		return score1;
	}
	public void setScore1(int score1) {
		this.score1 = score1;
	}
	public int getScore2() {
		return score2;
	}
	public void setScore2(int score2) {
		this.score2 = score2;
	}
	public int getScore3() {
		return score3;
	}
	public void setScore3(int score3) {
		this.score3 = score3;
	}
	public int getTrainmi() {
		return trainmi;
	}
	public void setTrainmi(int trainmi) {
		this.trainmi = trainmi;
	}
	public int getTestmi() {
		return testmi;
	}
	public void setTestmi(int testmi) {
		this.testmi = testmi;
	}
	public int getTraindi() {
		return traindi;
	}
	public void setTraindi(int traindi) {
		this.traindi = traindi;
	}
	public int getTestdi() {
		return testdi;
	}
	public void setTestdi(int testdi) {
		this.testdi = testdi;
	}	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getRate0() {
		return rate0;
	}
	public void setRate0(String rate0) {
		this.rate0 = rate0;
	}
	public String getRate1() {
		return rate1;
	}
	public void setRate1(String rate1) {
		this.rate1 = rate1;
	}
	public String getRate2() {
		return rate2;
	}
	public void setRate2(String rate2) {
		this.rate2 = rate2;
	}
	public String getRate3() {
		return rate3;
	}
	public void setRate3(String rate3) {
		this.rate3 = rate3;
	}
	public String getRate4() {
		return rate4;
	}
	public void setRate4(String rate4) {
		this.rate4 = rate4;
	}
	public String getRate5() {
		return rate5;
	}
	public void setRate5(String rate5) {
		this.rate5 = rate5;
	}
	public String getRate6() {
		return rate6;
	}
	public void setRate6(String rate6) {
		this.rate6 = rate6;
	}
	public String getRate7() {
		return rate7;
	}
	public void setRate7(String rate7) {
		this.rate7 = rate7;
	}
	public String getRate8() {
		return rate8;
	}
	public void setRate8(String rate8) {
		this.rate8 = rate8;
	}
	public String getRate9() {
		return rate9;
	}
	public void setRate9(String rate9) {
		this.rate9 = rate9;
	}
	public TrainMonitorInfoService getTrainMonitorInfoService() {
		return trainMonitorInfoService;
	}
	public void setTrainMonitorInfoService(
			TrainMonitorInfoService trainMonitorInfoService) {
		this.trainMonitorInfoService = trainMonitorInfoService;
	}
	public TestMonitorInfoService getTestMonitorInfoService() {
		return testMonitorInfoService;
	}
	public void setTestMonitorInfoService(
			TestMonitorInfoService testMonitorInfoService) {
		this.testMonitorInfoService = testMonitorInfoService;
	}
	public TrainDelayInfoService getTrainDelayInfoService() {
		return trainDelayInfoService;
	}
	public void setTrainDelayInfoService(TrainDelayInfoService trainDelayInfoService) {
		this.trainDelayInfoService = trainDelayInfoService;
	}
	public TestDelayInfoService getTestDelayInfoService() {
		return testDelayInfoService;
	}
	public void setTestDelayInfoService(TestDelayInfoService testDelayInfoService) {
		this.testDelayInfoService = testDelayInfoService;
	}
	public String execute(){
		type0+=testMonitorInfoService.findByDegradationType("ATP/RBC复合因素");
		type1+=testMonitorInfoService.findByDegradationType("ATP方面");
		type2+=testMonitorInfoService.findByDegradationType("BSC故障");
		type3+=testMonitorInfoService.findByDegradationType("MSC向两端发起拆线");
		type4+=testMonitorInfoService.findByDegradationType("RBC方面");
		type5+=testMonitorInfoService.findByDegradationType("不明情况");
		type6+=testMonitorInfoService.findByDegradationType("不明情况2");
		type7+=testMonitorInfoService.findByDegradationType("不明情况3");
		type8+=testMonitorInfoService.findByDegradationType("切换相关");
		type9+=testMonitorInfoService.findByDegradationType("质量恶化，列控用户发起拆链");
		total+=type0+type1+type2+type3+type4+type5+type6+type7+type8+type9;
		if(total!=0){
			rate0=new Float(Math.round((float)type0/total*100)).toString()+"%";
			rate1=new Float(Math.round((float)type1/total*100)).toString()+"%";
			rate2=new Float(Math.round((float)type2/total*100)).toString()+"%";
			rate3=new Float(Math.round((float)type3/total*100)).toString()+"%";
			rate4=new Float(Math.round((float)type4/total*100)).toString()+"%";
			rate5=new Float(Math.round((float)type5/total*100)).toString()+"%";
			rate6=new Float(Math.round((float)type6/total*100)).toString()+"%";
			rate7=new Float(Math.round((float)type7/total*100)).toString()+"%";
			rate8=new Float(Math.round((float)type8/total*100)).toString()+"%";
			rate9=new Float(Math.round((float)type9/total*100)).toString()+"%";
		}	
		score0+=testDelayInfoService.findTestDelayInfo("优");
		score1+=testDelayInfoService.findTestDelayInfo("良");
		score2+=testDelayInfoService.findTestDelayInfo("中");
		score3+=testDelayInfoService.findTestDelayInfo("差");
		trainmi+=trainMonitorInfoService.findByDegradationType();
		testmi+=testMonitorInfoService.findByDegradationType();
		traindi+=trainDelayInfoService.findTrainDelayInfo();
		testdi+=testDelayInfoService.findTestDelayInfo();
		return SUCCESS;
	}
	
}
