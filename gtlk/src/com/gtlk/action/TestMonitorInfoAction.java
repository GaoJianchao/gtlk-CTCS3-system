package com.gtlk.action;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.gtlk.entity.DataProcess;
import com.gtlk.entity.RuleInfo;
import com.gtlk.entity.TestMonitorInfo;
import com.sram.util.pager.PagerModel;
import com.sram.util.system.SystemContext;
import com.gtlk.service.prototype.RuleInfoService;
import com.gtlk.service.prototype.TestMonitorInfoService;


@SuppressWarnings("serial")
public class TestMonitorInfoAction extends ActionSupport{
	private List<TestMonitorInfo> objs;
	private Integer oid;
	private TestMonitorInfo obj;
	private List<Integer> oids;
	private String runningTime;
	private String trainName;
	private String trainNum;
	private String route;
	private String breakStation;
	private String initiator;
	private String degradationType;
	private TestMonitorInfoService testMonitorInfoService;


	private List<RuleInfo> objs2;
	private Integer oid2;
	private RuleInfo obj2;
	private List<Integer> oids2;
	private String creatTime;
	private String rule;
	private RuleInfoService ruleInfoService;
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public String getRunningTime() {
		return runningTime;
	}
	public void setRunningTime(String runningTime) {
		this.runningTime = runningTime;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public String getTrainNum() {
		return trainNum;
	}
	public void setTrainNum(String trainNum) {
		this.trainNum = trainNum;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public String getBreakStation() {
		return breakStation;
	}
	public void setBreakStation(String breakStation) {
		this.breakStation = breakStation;
	}
	public String getInitiator() {
		return initiator;
	}
	public void setInitiator(String initiator) {
		this.initiator = initiator;
	}
	public String getDegradationType() {
		return degradationType;
	}
	public void setDegradationType(String degradationType) {
		this.degradationType = degradationType;
	}
	
	public TestMonitorInfoService getTestMonitorInfoService() {
		return testMonitorInfoService;
	}
	public void setTestMonitorInfoService(
			TestMonitorInfoService testMonitorInfoService) {
		this.testMonitorInfoService = testMonitorInfoService;
	}
	
	
	public List<TestMonitorInfo> getObjs() {
		return objs;
	}
	public void setObjs(List<TestMonitorInfo> objs) {
		this.objs = objs;
	}
	
	public List<Integer> getOids() {
		return oids;
	}
	public void setOids(List<Integer> oids) {
		this.oids = oids;
	}
	
	public TestMonitorInfo getObj() {
		return obj;
	}
	public void setObj(TestMonitorInfo obj) {
		this.obj = obj;
	}
	
	
	public RuleInfoService getRuleInfoService() {
		return ruleInfoService;
	}
	public void setRuleInfoService(RuleInfoService ruleInfoService) {
		this.ruleInfoService = ruleInfoService;
	}
	
	
	
	public String getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(String creatTime) {
		this.creatTime = creatTime;
	}
	
	
	public List<RuleInfo> getObjs2() {
		return objs2;
	}
	public void setObjs2(List<RuleInfo> objs2) {
		this.objs2 = objs2;
	}
	public RuleInfo getObj2() {
		return obj2;
	}
	public void setObj2(RuleInfo obj2) {
		this.obj2 = obj2;
	}
	public List<Integer> getOids2() {
		return oids2;
	}
	public void setOids2(List<Integer> oids2) {
		this.oids2 = oids2;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	public Integer getOid2() {
		return oid2;
	}
	public void setOid2(Integer oid2) {
		this.oid2 = oid2;
	}
	@SuppressWarnings("unchecked")
	public String list() throws Exception {
		SystemContext.setPagesize(1000);
		if (ServletActionContext.getRequest().getParameter("pager.offset") != null
				&& !"".equals(ServletActionContext.getRequest().getParameter(
						"pager.offset"))) {
			trainName = new String(trainName.getBytes("ISO8859-1"), "gbk");
			trainName = new String(trainName.getBytes("ISO8859-1"), "gbk");
			trainNum = new String(trainNum.getBytes("ISO8859-1"), "gbk");
			route = new String(route.getBytes("ISO8859-1"), "gbk");
			breakStation = new String(breakStation.getBytes("ISO8859-1"), "gbk");
			initiator = new String(initiator.getBytes("ISO8859-1"), "gbk");
			degradationType = new String(degradationType.getBytes("ISO8859-1"), "gbk");
			
		}
		PagerModel pm = testMonitorInfoService.pageFind(new Object[]{
				runningTime,trainName,trainNum,route,breakStation,initiator,degradationType});
		objs = pm.getDatas();
		pm.setDatas(objs);		
		ServletActionContext.getRequest().setAttribute("pm", pm);
		
		objs2=ruleInfoService.findByCreatTime();		
		return SUCCESS;
	}
	
	
	public String addPage(){
		return SUCCESS;
	}
	
	public String add(){
		if(obj != null){
			testMonitorInfoService.save(obj);
			System.out.println("sdfsdfsd");
		}
		return SUCCESS;
	}
	
	public String delete(){
		if(oids!=null){					
			for(Integer id:oids){
				testMonitorInfoService.remove(testMonitorInfoService.findById(id));
		  }
		}
		else
		   System.out.println("sdfsdfsd4");
		return SUCCESS;
	}
	
	public String editPage(){
		if(oid != null){
			obj = testMonitorInfoService.findById(oid);
		}
		return SUCCESS;
	}
	
	public String edit(){
		TestMonitorInfo b = obj;
		TestMonitorInfo temp = testMonitorInfoService.findById(b.getOid());
		temp.setRunningTime(b.getRunningTime());
		temp.setTrainName(b.getTrainName());
		temp.setTrainNum(b.getTrainNum());
		temp.setRoute(b.getRoute());
		temp.setBreakStation(b.getBreakStation());
		temp.setSituation(b.getSituation());
		temp.setPriWithoutData(b.getPriWithoutData());
		temp.setObuUnresponsive(b.getObuUnresponsive());
		temp.setRbcUnresponsive(b.getRbcUnresponsive());
		temp.setRbcReceiveAk(b.getRbcReceiveAk());
		temp.setrToOak(b.getrToOak());
		temp.setErData(b.getErData());
		temp.setRbcReceiveRr(b.getRbcReceiveRr());
		temp.setrToOrr(b.getrToOrr());
		temp.setRetransmsstionDirection(b.getRetransmsstionDirection());
		temp.setoToRnosensicalData(b.getoToRnosensicalData());
		temp.setRepeatedSabme(b.getRepeatedSabme());
		temp.setReceiveFrmr(b.getReceiveFrmr());
		temp.setReleaseReason(b.getReleaseReason());
		temp.setMessageType(b.getMessageType());
		temp.setReason(b.getReason());
		temp.setReleaseKey(b.getReleaseKey());
		temp.setUnfinishedSwitch(b.getUnfinishedSwitch());
		temp.setSwitchKey(b.getSwitchKey());
		temp.setT3103Overtime(b.getT3103Overtime());
		temp.setBtsAbnormalMesg(b.getBtsAbnormalMesg());
		temp.setBscUnresponsive(b.getBscUnresponsive());
		temp.setUpQuality(b.getUpQuality());
		temp.setDownQuality(b.getDownQuality());
		temp.setUpElectricity(b.getUpElectricity());
		temp.setDownElectricity(b.getDownElectricity());
		temp.setInitiator(b.getInitiator());
		temp.setDegradationType(b.getDegradationType());
		testMonitorInfoService.modify(temp);
		return SUCCESS;
	}
	public String extractTestMonitorInfo(){
		ArrayList<TestMonitorInfo> t = new ArrayList<TestMonitorInfo>();
		for(Integer id:oids){
			System.out.println(id);
				t.add(testMonitorInfoService.findById(id));
		}		
		for(int i=0;i<t.size();i++){
			String[] test=new String[27];
			test[0]=t.get(i).getSituation();
			test[1]=t.get(i).getPriWithoutData();
			test[2]=t.get(i).getObuUnresponsive();
			test[3]=t.get(i).getRbcUnresponsive();
			test[4]=t.get(i).getRbcReceiveAk();
			test[5]=t.get(i).getrToOak();
			test[6]=t.get(i).getErData();
			test[7]=t.get(i).getRbcReceiveRr();
			test[8]=t.get(i).getrToOrr();
			test[9]=t.get(i).getRetransmsstionDirection();
			test[10]=t.get(i).getoToRnosensicalData();
			test[11]=t.get(i).getRepeatedSabme();
			test[12]=t.get(i).getReceiveFrmr();
			test[13]=t.get(i).getReleaseReason();
			test[14]=t.get(i).getMessageType();
			test[15]=t.get(i).getReason();
			test[16]=t.get(i).getReleaseKey();
			test[17]=t.get(i).getUnfinishedSwitch();
			test[18]=t.get(i).getSwitchKey();
			test[19]=t.get(i).getT3103Overtime();
			test[20]=t.get(i).getBtsAbnormalMesg();
			test[21]=t.get(i).getBscUnresponsive();
			test[22]=t.get(i).getUpQuality();
			test[23]=t.get(i).getDownQuality();
			test[24]=t.get(i).getUpElectricity();
			test[25]=t.get(i).getDownElectricity();
			test[26]=t.get(i).getInitiator();
			String tempType="";
			for(Integer id:oids){
				tempType = DataProcess.classify(ruleInfoService.findById(id).getRule(), test);
			}
			t.get(i).setDegradationType(tempType);
			testMonitorInfoService.modify(t.get(i));
		}
		return SUCCESS;
	}
	
	
	public String execute(){
		//取规则
		String temp="";
		for(Integer id:oids2){
		temp=ruleInfoService.findById(id).getRule();
		}
		//取测试集
		ArrayList<TestMonitorInfo> t= new ArrayList<TestMonitorInfo>();
		for(Integer id:oids){
			t.add(testMonitorInfoService.findById(id));
		}
		for(int i=0;i<t.size();i++){
			String []s = new String[27]; 
			s[0]=t.get(i).getSituation();		
			s[1]=t.get(i).getPriWithoutData(); 
			s[2]=t.get(i).getObuUnresponsive();
			s[3]=t.get(i).getRbcUnresponsive();
			s[4]=t.get(i).getRbcReceiveAk(); 		
			s[5]=t.get(i).getrToOak(); 		
			s[6]=t.get(i).getErData();	
			s[7]=t.get(i).getRbcReceiveRr(); 
			s[8]=t.get(i).getrToOrr();	
			s[9]=t.get(i).getRetransmsstionDirection(); 		
			s[10]=t.get(i).getoToRnosensicalData(); 		
			s[11]=t.get(i).getRepeatedSabme(); 
			s[12]=t.get(i).getReceiveFrmr();
			s[13]=t.get(i).getReleaseReason(); 															
			s[14]=t.get(i).getMessageType(); 																
			s[15]=t.get(i).getReason(); 
			s[16]=t.get(i).getReleaseKey(); 
			s[17]=t.get(i).getUnfinishedSwitch(); 
			s[18]=t.get(i).getSwitchKey(); 
			s[19]=t.get(i).getT3103Overtime(); 
			s[20]=t.get(i).getBtsAbnormalMesg(); 
			s[21]=t.get(i).getBscUnresponsive();
			s[22]=t.get(i).getUpQuality();
			s[23]=t.get(i).getDownQuality();
			s[24]=t.get(i).getUpElectricity();
			s[25]=t.get(i).getDownElectricity();
			s[26]=t.get(i).getInitiator();
			
			System.out.println(DataProcess.classify(temp, s));
			t.get(i).setDegradationType(DataProcess.classify(temp, s));
			testMonitorInfoService.modify(t.get(i));
		}
		return SUCCESS;
	}
	
}
