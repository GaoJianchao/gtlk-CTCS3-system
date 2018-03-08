package com.gtlk.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

//import com.gtlk.service.impl.TrainMonitorInfoServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.gtlk.entity.DataProcess;
import com.gtlk.entity.RuleInfo;
import com.gtlk.entity.TrainMonitorInfo;
import com.gtlk.entity.make_RF;
import com.sram.util.pager.PagerModel;
import com.sram.util.system.SystemContext;
import com.gtlk.service.prototype.RuleInfoService;
import com.gtlk.service.prototype.TrainMonitorInfoService;


@SuppressWarnings("serial")
public class TrainMonitorInfoAction extends ActionSupport{
	private List<TrainMonitorInfo> objs;
	private Integer oid;
	private TrainMonitorInfo obj;
	private List<Integer> oids;
	private String runningTime;
	private String trainName;
	private String trainNum;
	private String route;
	private String breakStation;
	private String situation;
	private String priWithoutData;
	private String obuUnresponsive;
	private String rbcUnresponsive;
	private String rbcReceiveAk;
	private String rToOak;
	private String erData;
	private String rbcReceiveRr;
	private String rToOrr;
	private String retransmsstionDirection;
	private String oToRnosensicalData;
	private String repeatedSabme;
	private String receiveFrmr;
	private String releaseReason;
	private String messageType;
	private String reason;
	private String releaseKey;
	private String unfinishedSwitch;
	private String switchKey;
	private String t3103Overtime;
	private String btsAbnormalMesg;
	private String bscUnresponsive;
	private String upQuality;
	private String downQuality;
	private String upElectricity;
	private String downElectricity;
	private String initiator;
	private String degradationType;
	private TrainMonitorInfoService trainMonitorInfoService;
	private RuleInfoService ruleInfoService;
	private RuleInfo ruleinfo;
	
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
	
	public TrainMonitorInfoService getTrainMonitorInfoService() {
		return trainMonitorInfoService;
	}
	public void setTrainMonitorInfoService(
			TrainMonitorInfoService trainMonitorInfoService) {
		this.trainMonitorInfoService = trainMonitorInfoService;
	}
	
	
	public List<TrainMonitorInfo> getObjs() {
		return objs;
	}
	public void setObjs(List<TrainMonitorInfo> objs) {
		this.objs = objs;
	}
	
	public List<Integer> getOids() {
		return oids;
	}
	public void setOids(List<Integer> oids) {
		this.oids = oids;
	}
	
	public TrainMonitorInfo getObj() {
		return obj;
	}
	public void setObj(TrainMonitorInfo obj) {
		this.obj = obj;
	}
	public String getSituation() {
		return situation;
	}
	public void setSituation(String situation) {
		this.situation = situation;
	}
	public String getPriWithoutData() {
		return priWithoutData;
	}
	public void setPriWithoutData(String priWithoutData) {
		this.priWithoutData = priWithoutData;
	}
	public String getObuUnresponsive() {
		return obuUnresponsive;
	}
	public void setObuUnresponsive(String obuUnresponsive) {
		this.obuUnresponsive = obuUnresponsive;
	}
	public String getRbcUnresponsive() {
		return rbcUnresponsive;
	}
	public void setRbcUnresponsive(String rbcUnresponsive) {
		this.rbcUnresponsive = rbcUnresponsive;
	}
	public String getRbcReceiveAk() {
		return rbcReceiveAk;
	}
	public void setRbcReceiveAk(String rbcReceiveAk) {
		this.rbcReceiveAk = rbcReceiveAk;
	}
	public String getrToOak() {
		return rToOak;
	}
	public void setrToOak(String rToOak) {
		this.rToOak = rToOak;
	}
	public String getErData() {
		return erData;
	}
	public void setErData(String erData) {
		this.erData = erData;
	}
	public String getRbcReceiveRr() {
		return rbcReceiveRr;
	}
	public void setRbcReceiveRr(String rbcReceiveRr) {
		this.rbcReceiveRr = rbcReceiveRr;
	}
	public String getrToOrr() {
		return rToOrr;
	}
	public void setrToOrr(String rToOrr) {
		this.rToOrr = rToOrr;
	}
	public String getRetransmsstionDirection() {
		return retransmsstionDirection;
	}
	public void setRetransmsstionDirection(String retransmsstionDirection) {
		this.retransmsstionDirection = retransmsstionDirection;
	}
	public String getoToRnosensicalData() {
		return oToRnosensicalData;
	}
	public void setoToRnosensicalData(String oToRnosensicalData) {
		this.oToRnosensicalData = oToRnosensicalData;
	}
	public String getRepeatedSabme() {
		return repeatedSabme;
	}
	public void setRepeatedSabme(String repeatedSabme) {
		this.repeatedSabme = repeatedSabme;
	}
	public String getReceiveFrmr() {
		return receiveFrmr;
	}
	public void setReceiveFrmr(String receiveFrmr) {
		this.receiveFrmr = receiveFrmr;
	}
	public String getReleaseReason() {
		return releaseReason;
	}
	public void setReleaseReason(String releaseReason) {
		this.releaseReason = releaseReason;
	}
	public String getMessageType() {
		return messageType;
	}
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getReleaseKey() {
		return releaseKey;
	}
	public void setReleaseKey(String releaseKey) {
		this.releaseKey = releaseKey;
	}
	public String getUnfinishedSwitch() {
		return unfinishedSwitch;
	}
	public void setUnfinishedSwitch(String unfinishedSwitch) {
		this.unfinishedSwitch = unfinishedSwitch;
	}
	public String getSwitchKey() {
		return switchKey;
	}
	public void setSwitchKey(String switchKey) {
		this.switchKey = switchKey;
	}
	public String getT3103Overtime() {
		return t3103Overtime;
	}
	public void setT3103Overtime(String t3103Overtime) {
		this.t3103Overtime = t3103Overtime;
	}
	public String getBtsAbnormalMesg() {
		return btsAbnormalMesg;
	}
	public void setBtsAbnormalMesg(String btsAbnormalMesg) {
		this.btsAbnormalMesg = btsAbnormalMesg;
	}
	public String getBscUnresponsive() {
		return bscUnresponsive;
	}
	public void setBscUnresponsive(String bscUnresponsive) {
		this.bscUnresponsive = bscUnresponsive;
	}
	public String getUpQuality() {
		return upQuality;
	}
	public void setUpQuality(String upQuality) {
		this.upQuality = upQuality;
	}
	public String getDownQuality() {
		return downQuality;
	}
	public void setDownQuality(String downQuality) {
		this.downQuality = downQuality;
	}
	public String getUpElectricity() {
		return upElectricity;
	}
	public void setUpElectricity(String upElectricity) {
		this.upElectricity = upElectricity;
	}
	public String getDownElectricity() {
		return downElectricity;
	}
	public void setDownElectricity(String downElectricity) {
		this.downElectricity = downElectricity;
	}
	@SuppressWarnings("unchecked")
	public String list() throws Exception {
		SystemContext.setPagesize(1000);
		if (ServletActionContext.getRequest().getParameter("pager.offset") != null
				&& !"".equals(ServletActionContext.getRequest().getParameter(
						"pager.offset"))) {
			//runningTime = new String(runningTime.toString().getBytes("ISO8859-1"), "gbk");
			trainName = new String(trainName.getBytes("ISO8859-1"), "gbk");
			trainName = new String(trainName.getBytes("ISO8859-1"), "gbk");
			trainNum = new String(trainNum.getBytes("ISO8859-1"), "gbk");
			route = new String(route.getBytes("ISO8859-1"), "gbk");
			breakStation = new String(breakStation.getBytes("ISO8859-1"), "gbk");
			initiator = new String(initiator.getBytes("ISO8859-1"), "gbk");
			degradationType = new String(degradationType.getBytes("ISO8859-1"), "gbk");
			
		}
		PagerModel pm = trainMonitorInfoService.pageFind(new Object[]{
				runningTime,trainName,trainNum,route,breakStation,initiator,degradationType});
		objs = pm.getDatas();
		//objs = simpleRowVist.setUpdateType(pm.getDatas());
		//objs = simpleRowVist.getChild(pm.getDatas());
		pm.setDatas(objs);
		//pm.setTotal(objs.size());
		
		ServletActionContext.getRequest().setAttribute("pm", pm);
		//ServletActionContext.getRequest().setAttribute("allow", simpleRowVist.isallowUpDate(onlineUserOrgsn, orgsn));
		return SUCCESS;
	}
	
	public String addPage(){
		return SUCCESS;
	}
	
	public String add(){
		if(obj != null){
			
	
			trainMonitorInfoService.save(obj);
			System.out.println("sdfsdfsd");
		}
		return SUCCESS;
	}
	
	public String delete(){					
		for(Integer id:oids){
			trainMonitorInfoService.remove(trainMonitorInfoService.findById(id));
		}
		return "deletesuccess";
	}
	
	public String editPage(){
		if(oid != null){
			obj = trainMonitorInfoService.findById(oid);
		}
		return SUCCESS;
	}
	
	public String edit(){
		TrainMonitorInfo b = obj;
		TrainMonitorInfo temp = trainMonitorInfoService.findById(b.getOid());
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
		trainMonitorInfoService.modify(temp);

		return SUCCESS;
	}
	
	public RuleInfoService getRuleInfoService() {
		return ruleInfoService;
	}
	public void setRuleInfoService(RuleInfoService ruleInfoService) {
		this.ruleInfoService = ruleInfoService;
	}
	public RuleInfo getRuleinfo() {
		return ruleinfo;
	}
	public void setRuleinfo(RuleInfo ruleinfo) {
		this.ruleinfo = ruleinfo;
	}
	
	
	
	public String execute(){
		//saveRuleInfo(creatRule(extractTrainMonitorInfo()));
		extractTrainMonitorInfo();
		return "save"+SUCCESS;
	}

	public String extractTrainMonitorInfo(){
		ArrayList<TrainMonitorInfo> t = new ArrayList<TrainMonitorInfo>();
		for(Integer id:oids){
			System.out.println(id);
				t.add(trainMonitorInfoService.findById(id));
		}
		System.out.println(t.size());
		
		ArrayList<Integer[]> trainsample =DataProcess.dataPretreat(t);
		System.out.println("x"+trainsample.size());
		System.out.println(trainsample.get(0).length);
		for(int i=0;i<28;i++)
			System.out.println(trainsample.get(0)[i]+" ");
		int [][] temp=new int[trainsample.size()][trainsample.get(0).length];
		System.out.println("temp.length: "+temp.length);
		for(int i=0;i<trainsample.size();i++)
			for(int j=0;j<trainsample.get(0).length;j++){
				System.out.println(i+" "+j+" "+trainsample.get(i)[j]);
				temp[i][j]=trainsample.get(i)[j];}
		make_RF m= new make_RF(temp);
		System.out.println(m.rules);
		Date date=new Date();
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=formatter.format(date);
		ruleInfoService.save(new RuleInfo(time,DataProcess.changeABCToChinese(m.rules.substring(0, m.rules.length()-1))));
		return "savesuccess";
	}
	public String creatRule(ArrayList<TrainMonitorInfo> t){
		ArrayList<Integer[]> trainsample =DataProcess.dataPretreat(t);
		System.out.println(trainsample.size());
		int [][] temp=new int[trainsample.size()][trainsample.get(0).length];
		make_RF m= new make_RF(temp);
		System.out.println(m.rules);
		return m.rules;
	}
	public String saveRuleInfo(String rule){
		ruleInfoService.save(new RuleInfo("2015-4-23",rule));
		return SUCCESS;
	}
	
}
