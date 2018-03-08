package com.gtlk.action;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

//import com.gtlk.service.impl.RuleInfoServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.gtlk.entity.RuleInfo;
import com.sram.util.pager.PagerModel;
import com.sram.util.system.SystemContext;
import com.gtlk.service.prototype.RuleInfoService;


@SuppressWarnings("serial")
public class RuleInfoAction extends ActionSupport{
	private List<RuleInfo> objs;
	private Integer oid;
	private RuleInfo obj;
	private List<Integer> oids;
	private String creatTime;
	private String rule;
	private RuleInfoService ruleInfoService;
	public Integer getoid() {
		return oid;
	}
	public void setOid(Integer oid) {
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
	public RuleInfoService getRuleInfoService() {
		return ruleInfoService;
	}
	public void setRuleInfoService(
			RuleInfoService ruleInfoService) {
		this.ruleInfoService = ruleInfoService;
	}
	
	
	public List<RuleInfo> getObjs() {
		return objs;
	}
	public void setObjs(List<RuleInfo> objs) {
		this.objs = objs;
	}
	
	public List<Integer> getOids() {
		return oids;
	}
	public void setOids(List<Integer> oids) {
		this.oids = oids;
	}
	
	public RuleInfo getObj() {
		return obj;
	}
	public void setObj(RuleInfo obj) {
		this.obj = obj;
	}
	@SuppressWarnings("unchecked")
	public String list() throws Exception {
		SystemContext.setPagesize(20);
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
		PagerModel pm = ruleInfoService.pageFind(new Object[]{
				creatTime,rule});
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
			
	
			ruleInfoService.save(obj);
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
				ruleInfoService.remove(ruleInfoService.findById(id));
			   //System.out.print(RuleInfoService.findAll()+" ");
			   
				//RuleInfoService.remove(RuleInfoService.findById(oids.get(i)));
		  }
		}
		else
		   System.out.println("sdfsdfsd4");
		return SUCCESS;
	}
	
	public String editPage(){
		if(oid != null){
			obj = ruleInfoService.findById(oid);
		}
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String edit(){
		RuleInfo b = obj;
		RuleInfo temp = ruleInfoService.findById(b.getoid());
		temp.setCreatTime(b.getCreatTime());
		temp.setRule(b.getRule());
		ruleInfoService.modify(temp);
		
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
