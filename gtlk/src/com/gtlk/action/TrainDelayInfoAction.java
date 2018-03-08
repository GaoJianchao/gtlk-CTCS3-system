package com.gtlk.action;
import java.util.List;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.gtlk.entity.TrainDelayInfo;
import com.sram.util.pager.PagerModel;
import com.sram.util.system.SystemContext;
import com.gtlk.service.prototype.TrainDelayInfoService;


@SuppressWarnings("serial")
public class TrainDelayInfoAction extends ActionSupport{
	private List<TrainDelayInfo> objs;
	private Integer oid;
	private TrainDelayInfo obj;
	private List<Integer> oids;
	private String route;
	private String detectionTime;
	private Double switchSuccessRate;
	private Double switchAveDelay;
	private Double toneDegree;
	private Double tAveDelay;
	private Double tInerrantTimeRate;
	private Double linkAveDelayRate;
	private String grade;
	private TrainDelayInfoService trainDelayInfoService;
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public String getDetectionTime() {
		return detectionTime;
	}
	public void setDetectionTime(String detectionTime) {
		this.detectionTime = detectionTime;
	}
	public Double getSwitchSuccessRate() {
		return switchSuccessRate;
	}
	public void setSwitchSuccessRate(Double switchSuccessRate) {
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
	public TrainDelayInfoService getTrainDelayInfoService() {
		return trainDelayInfoService;
	}
	public void setTrainDelayInfoService(
			TrainDelayInfoService trainDelayInfoService) {
		this.trainDelayInfoService = trainDelayInfoService;
	}
	
	
	public List<TrainDelayInfo> getObjs() {
		return objs;
	}
	public void setObjs(List<TrainDelayInfo> objs) {
		this.objs = objs;
	}
	
	public List<Integer> getOids() {
		return oids;
	}
	public void setOids(List<Integer> oids) {
		this.oids = oids;
	}
	
	public TrainDelayInfo getObj() {
		return obj;
	}
	public void setObj(TrainDelayInfo obj) {
		this.obj = obj;
	}
	@SuppressWarnings("unchecked")
	public String list() throws Exception {
		SystemContext.setPagesize(1000);
		/*if (ServletActionContext.getRequest().getParameter("pager.offset") != null
				&& !"".equals(ServletActionContext.getRequest().getParameter(
						"pager.offset"))) {
			runningTime = new String(runningTime.toString().getBytes("ISO8859-1"), "gbk");
			trainName = new String(trainName.getBytes("ISO8859-1"), "gbk");
			trainName = new String(trainName.getBytes("ISO8859-1"), "gbk");
			trainNum = new String(trainNum.getBytes("ISO8859-1"), "gbk");
			route = new String(route.getBytes("ISO8859-1"), "gbk");
			breakStation = new String(breakStation.getBytes("ISO8859-1"), "gbk");
			initiator = new String(initiator.getBytes("ISO8859-1"), "gbk");
			degradationType = new String(degradationType.getBytes("ISO8859-1"), "gbk");
			
		}*/
		PagerModel pm = trainDelayInfoService.pageFind(new Object[]{
				route,detectionTime,switchSuccessRate,switchAveDelay,toneDegree,tAveDelay,tInerrantTimeRate,linkAveDelayRate,grade});
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
			
	
			trainDelayInfoService.save(obj);
			System.out.println("sdfsdfsd");
		}
		return SUCCESS;
	}
	
	public String delete(){
		if(oids!=null){
					
			for(Integer id:oids){
				System.out.println("sdfsdfsd3");
			//for(int i=0;i<oids.size();i++)
				 //System.out.print(oids.);
				trainDelayInfoService.remove(trainDelayInfoService.findById(id));
			   //System.out.print(TrainDelayInfoService.findAll()+" ");
			   
				//TrainDelayInfoService.remove(TrainDelayInfoService.findById(oids.get(i)));
		  }
		}
		else
		   System.out.println("sdfsdfsd4");
		return SUCCESS;
	}
	
	public String editPage(){
		if(oid != null){
			obj = trainDelayInfoService.findById(oid);
		}
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String edit(){
		TrainDelayInfo b = obj;
		TrainDelayInfo temp = trainDelayInfoService.findById(b.getOid());
		temp.setRoute(b.getRoute());
		temp.setDetectionTime(b.getDetectionTime());	
		temp.setSwitchSuccessRate(b.getSwitchSuccessRate());
		temp.setSwitchAveDelay(b.getSwitchAveDelay());
		temp.setToneDegree(b.getToneDegree());
		temp.settAveDelay(b.gettAveDelay());
		temp.settInerrantTimeRate(b.gettInerrantTimeRate());
		temp.setLinkAveDelayRate(b.getLinkAveDelayRate());
		temp.setGrade(b.getGrade());
		trainDelayInfoService.modify(temp);
		
		// 页面跳转页码处理
		//Map<String, Object> params = (Map<String, Object>) ServletActionContext
		//				.getRequest().getSession().getAttribute("params");
		//if (params != null) {
		//	String[] offset = (String[]) params.get("pager.offset");
		//	if (offset != null && offset[0] != null && !"".equals(offset[0])) {
		//		interOffset = Integer.parseInt(offset[0]);
		//	}
		//}
		return SUCCESS;
	}
	
	
	
}
