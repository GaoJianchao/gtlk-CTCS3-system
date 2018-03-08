package com.gtlk.entity;
import java.util.Date;

public class TrainDelayInfo{
	private Integer oid;
	private String route;
	private String detectionTime;
	private Double switchSuccessRate;
	private Double switchAveDelay;
	private Double toneDegree;
	private Double tAveDelay;
	private Double tInerrantTimeRate;
	private Double linkAveDelayRate;
	private String grade;
	
	public TrainDelayInfo(String route, String detectionTime,
			Double switchSuccessRate, Double switchAveDelay, Double toneDegree,
			Double tAveDelay, Double tInerrantTimeRate,
			Double linkAveDelayRate, String grade) {
		super();
		this.route = route;
		this.detectionTime = detectionTime;
		this.switchSuccessRate = switchSuccessRate;
		this.switchAveDelay = switchAveDelay;
		this.toneDegree = toneDegree;
		this.tAveDelay = tAveDelay;
		this.tInerrantTimeRate = tInerrantTimeRate;
		this.linkAveDelayRate = linkAveDelayRate;
		this.grade = grade;
	}
	public TrainDelayInfo(){}
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public void setSwitchSuccessRate(Double switchSuccessRate) {
		this.switchSuccessRate = switchSuccessRate;
	}
	public String getDetectionTime() {
		return detectionTime;
	}
	public void setDetectionTime(String detectionTime) {
		this.detectionTime = detectionTime;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public Double getSwitchSuccessRate() {
		return switchSuccessRate;
	}
	public void setSwithSuccessRate(Double switchSuccessRate) {
		this.switchSuccessRate = switchSuccessRate;
	}
	public Double getSwitchAveDelay() {
		return switchAveDelay;
	}
	public void setSwitchAveDelay(Double switchAveDelay) {
		this.switchAveDelay = switchAveDelay;
	}
	public Double getToneDegree() {
		return toneDegree;
	}
	public void setToneDegree(Double toneDegree) {
		this.toneDegree = toneDegree;
	}
	public Double gettAveDelay() {
		return tAveDelay;
	}
	public void settAveDelay(Double tAveDelay) {
		this.tAveDelay = tAveDelay;
	}
	public Double gettInerrantTimeRate() {
		return tInerrantTimeRate;
	}
	public void settInerrantTimeRate(Double tInerrantTimeRate) {
		this.tInerrantTimeRate = tInerrantTimeRate;
	}
	public Double getLinkAveDelayRate() {
		return linkAveDelayRate;
	}
	public void setLinkAveDelayRate(Double linkAveDelayRate) {
		this.linkAveDelayRate = linkAveDelayRate;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}
