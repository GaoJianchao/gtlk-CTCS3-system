package com.gtlk.action;
import java.util.List;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.gtlk.entity.TestDelayInfo;
import com.sram.util.pager.PagerModel;
import com.sram.util.system.SystemContext;
import com.gtlk.service.prototype.TestDelayInfoService;
@SuppressWarnings("serial")
public class TestDelayInfoAction extends ActionSupport{
	private List<TestDelayInfo> objs;
	private Integer oid;
	private TestDelayInfo obj;
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
	private TestDelayInfoService testDelayInfoService;
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
	public TestDelayInfoService getTestDelayInfoService() {
		return testDelayInfoService;
	}
	public void setTestDelayInfoService(
			TestDelayInfoService testDelayInfoService) {
		this.testDelayInfoService = testDelayInfoService;
	}
	
	
	public List<TestDelayInfo> getObjs() {
		return objs;
	}
	public void setObjs(List<TestDelayInfo> objs) {
		this.objs = objs;
	}
	
	public List<Integer> getOids() {
		return oids;
	}
	public void setOids(List<Integer> oids) {
		this.oids = oids;
	}
	
	public TestDelayInfo getObj() {
		return obj;
	}
	public void setObj(TestDelayInfo obj) {
		this.obj = obj;
	}
	@SuppressWarnings("unchecked")
	public String list() throws Exception {
		SystemContext.setPagesize(1000);
		PagerModel pm = testDelayInfoService.pageFind(new Object[]{
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
			testDelayInfoService.save(obj);
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
				testDelayInfoService.remove(testDelayInfoService.findById(id));
			   //System.out.print(TestDelayInfoService.findAll()+" ");
			   
				//TestDelayInfoService.remove(TestDelayInfoService.findById(oids.get(i)));
		  }
		}
		else
		   System.out.println("sdfsdfsd4");
		return SUCCESS;
	}
	
	public String editPage(){
		if(oid != null){
			obj = testDelayInfoService.findById(oid);
		}
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String edit(){
		TestDelayInfo b = obj;
		TestDelayInfo temp = testDelayInfoService.findById(b.getOid());
		temp.setRoute(b.getRoute());
		temp.setDetectionTime(b.getDetectionTime());	
		temp.setSwitchSuccessRate(b.getSwitchSuccessRate());
		temp.setSwitchAveDelay(b.getSwitchAveDelay());
		temp.setToneDegree(b.getToneDegree());
		temp.settAveDelay(b.gettAveDelay());
		temp.settInerrantTimeRate(b.gettInerrantTimeRate());
		temp.setLinkAveDelayRate(b.getLinkAveDelayRate());
		temp.setGrade(b.getGrade());
		testDelayInfoService.modify(temp);
		
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
