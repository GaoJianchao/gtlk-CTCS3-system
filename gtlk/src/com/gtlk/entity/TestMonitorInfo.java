package com.gtlk.entity;

import java.util.Date;

public class TestMonitorInfo{
	private Integer oid;
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
	public TestMonitorInfo(String runningTime, String trainName,
			String trainNum, String route, String breakStation,
			String situation, String priWithoutData, String obuUnresponsive,
			String rbcUnresponsive, String rbcReceiveAk, String rToOak,
			String erData, String rbcReceiveRr, String rToOrr,
			String retransmsstionDirection, String oToRnosensicalData,
			String repeatedSabme, String receiveFrmr, String releaseReason,
			String messageType, String reason, String releaseKey,
			String unfinishedSwitch, String switchKey, String t3103Overtime,
			String btsAbnormalMesg, String bscUnresponsive, String upQuality,
			String downQuality, String upElectricity, String downElectricity,
			String initiator) {
		super();
		this.runningTime = runningTime;
		this.trainName = trainName;
		this.trainNum = trainNum;
		this.route = route;
		this.breakStation = breakStation;
		this.situation = situation;
		this.priWithoutData = priWithoutData;
		this.obuUnresponsive = obuUnresponsive;
		this.rbcUnresponsive = rbcUnresponsive;
		this.rbcReceiveAk = rbcReceiveAk;
		this.rToOak = rToOak;
		this.erData = erData;
		this.rbcReceiveRr = rbcReceiveRr;
		this.rToOrr = rToOrr;
		this.retransmsstionDirection = retransmsstionDirection;
		this.oToRnosensicalData = oToRnosensicalData;
		this.repeatedSabme = repeatedSabme;
		this.receiveFrmr = receiveFrmr;
		this.releaseReason = releaseReason;
		this.messageType = messageType;
		this.reason = reason;
		this.releaseKey = releaseKey;
		this.unfinishedSwitch = unfinishedSwitch;
		this.switchKey = switchKey;
		this.t3103Overtime = t3103Overtime;
		this.btsAbnormalMesg = btsAbnormalMesg;
		this.bscUnresponsive = bscUnresponsive;
		this.upQuality = upQuality;
		this.downQuality = downQuality;
		this.upElectricity = upElectricity;
		this.downElectricity = downElectricity;
		this.initiator = initiator;
	}
	public TestMonitorInfo(){}
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
	
}
