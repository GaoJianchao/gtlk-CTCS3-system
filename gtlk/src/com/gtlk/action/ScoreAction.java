package com.gtlk.action;
import java.util.List;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.gtlk.entity.TestDelayInfo;
import com.gtlk.entity.TrainDelayInfo;
import com.sram.util.pager.PagerModel;
import com.sram.util.system.SystemContext;
import com.gtlk.service.prototype.TestDelayInfoService;
import com.gtlk.service.prototype.TrainDelayInfoService;


@SuppressWarnings("serial")
public class ScoreAction extends ActionSupport{
	private List<TestDelayInfo> objs;
	private List<TrainDelayInfo> objs2;
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
	public TestDelayInfoService getTestDelayInfoService() {
		return testDelayInfoService;
	}
	public void setTestDelayInfoService(
			TestDelayInfoService testDelayInfoService) {
		this.testDelayInfoService = testDelayInfoService;
	}
	
	
	public List<TrainDelayInfo> getObjs2() {
		return objs2;
	}
	public void setObjs2(List<TrainDelayInfo> objs2) {
		this.objs2 = objs2;
	}
	public TrainDelayInfoService getTrainDelayInfoService() {
		return trainDelayInfoService;
	}
	public void setTrainDelayInfoService(TrainDelayInfoService trainDelayInfoService) {
		this.trainDelayInfoService = trainDelayInfoService;
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
	public String dafen(){	
		System.out.println("jj");
		// return SUCCESS;
		objs2=trainDelayInfoService.findTrainDelayInfo(new Object[]{
				switchSuccessRate,switchAveDelay,toneDegree,tAveDelay,tInerrantTimeRate,linkAveDelayRate});
		System.out.println("trainsuccess");
		objs=testDelayInfoService.findTestDelayInfo(new Object[]{
				switchSuccessRate,switchAveDelay,toneDegree,tAveDelay,tInerrantTimeRate,linkAveDelayRate});
		//System.out.println(objs2.get(1).getSwitchAveDelay());
		double [][]data=new double[138][6];
		for(int i=0;i<138;i++){
				data[i][0]=objs2.get(i).getSwitchSuccessRate();
				//System.out.print(objs2.get(i).getSwitchSuccessRate()+" ");
				data[i][1]=objs2.get(i).getSwitchAveDelay();
				//System.out.print(objs2.get(i).getSwitchAveDelay()+" ");
				data[i][2]=objs2.get(i).getToneDegree();
				//System.out.print(objs2.get(i).getToneDegree()+" ");
				data[i][3]=objs2.get(i).gettAveDelay();
				//System.out.print(objs2.get(i).gettAveDelay()+" ");
				data[i][4]=objs2.get(i).gettInerrantTimeRate();
				//System.out.print(objs2.get(i).gettInerrantTimeRate()+" ");
				data[i][5]=objs2.get(i).getLinkAveDelayRate();
				//System.out.print(objs2.get(i).gettInerrantTimeRate()+" ");
				//System.out.println();
			}
		System.out.println("datasuccess");
		int []b=kmeans(data,4);
		for(int t=0;t<objs.size();t++){
		        double []testdata=new double[6];
		        testdata[0]=objs.get(t).getSwitchSuccessRate();
		        testdata[1]=objs.get(t).getSwitchAveDelay();
		        testdata[2]=objs.get(t).getToneDegree();
		        testdata[3]=objs.get(t).gettAveDelay();
		        testdata[4]=objs.get(t).gettInerrantTimeRate();
		        testdata[5]=objs.get(t).getLinkAveDelayRate();
	            String knn="";
	            knn=KNN(b,data,testdata);
	            objs.get(t).setGrade(knn);
	            obj=objs.get(t);
	            edit();
	          //  TestDelayInfo temp = testDelayInfoService.findById(objs.get(t).getOid());
	           // System.out.println(temp.getDetectionTime()); 
	           // System.out.println(temp.getOid());
	           // testDelayInfoService.findById(oid).setGrade(knn)
	           // temp.setGrade(knn);
	          //  testDelayInfoService.modify(temp);
	    	    System.out.println("knn="+knn); 
	    	    
	       }
	       return SUCCESS;
	}
	public  int[] kmeans(double [][]a,int k){
		if(k<1){
			System.out.println("ERROR!");
			return new int[]{1};
		}
		int []culser=new int[a.length];//返回的各个样本所属类的标签；
		int count1=1;
		//随机初始化聚类中心
		double [][]center1={{0.9975,0.1087,0.9975,0.0834,0.9875,0.2},
				{0.9725,0.3696,0.9725,0.3334,0.9625,0.5},
				{0.925,0.6739,0.925,0.6667,0.925,0.7},
				{0.89,0.9131,0.89,0.9167,0.7,0.9}
};
		boolean f=false;
		do{
			double [][]distence=new double[a.length][k];//样本到聚类中心的距离
			f=false;
		for(int i=0;i<a.length;i++){                    //计算每个样本到四个聚类中心的距离
			for(int j=0;j<k;j++){
				distence[i][j]=means(a[i],center1[j]);
			}
		}
		double []rdis=new double[a.length];             //存放每个样本到所属类中心的距离         
		for(int i=0;i<a.length;i++){                     //找出每个样本所属类
			double min=distence[i][0];
			for(int j=1;j<k;j++){
				if(distence[i][j]<min){
					min=distence[i][j];
					rdis[i]=distence[i][j];
					culser[i]=j;
				}
			}	
		}
		/*for(double u:culser)
			System.out.print(u+" ");
		System.out.println();*/
		//重新计算每个类的每个属性的均值
		double [][]reculser=new double[4][a[0].length];
		for(int i=0;i<k;i++){
			for(int j=0;j<a[0].length;j++){
              int count=0;
              double s=0;
			  for(int p=0;p<a.length;p++){
				if(culser[p]==i){
					   s+=a[p][j];
					   count++;
					}
				}
			  if(count!=0)
			     reculser[i][j]=(s/count);
			}
		}
		//判断两次聚类中心是否相等，若不相等则继续循环
		for(int i=0;i<k;i++){
			if(!(java.util.Arrays.equals(reculser[i],center1[i]))){
				f=true;
				break;
			}
		}
		if(f){
		  for(int i=0;i<k;i++){
			for(int j=0;j<a[i].length;j++)
				center1[i][j]=reculser[i][j];
		   }
		 }
		count1++;
		}while(f);
		boolean []b=new boolean[a.length];
		int []culser2=new int[4];
		System.out.println("count1="+count1);
		 for(int i=0;i<a.length;i++){
			 if(!b[i]){
	    	  double count3=culser[i];
	    	 for(int j=i;j<a.length;j++){
	    	   if(count3==culser[j]){
	    		culser2[(int)count3]++;
	    		b[i]=b[j]=true;
	    	  }
	    	}
	      }
	    }
		 for(int i=0;i<4;i++){
			 System.out.print(i+":"+culser2[i]+" ");
		 }
		 System.out.println();
		return culser;
	}
	//计算两个样本之间的激距离
	public  double means(double []a,double []b){
		double sum=0;
		for(int i=0;i<a.length;i++){
			sum+=(a[i]-b[i])*(a[i]-b[i]);
		}
		sum=Math.sqrt(sum);
		return sum;
	}
	
	public  String KNN(int []culser,double [][]traindata,double []testdata){
		double [][]distences=new double[traindata.length][2];
		int min;
		double t;
		int []culser2=new int[4];         //存放每个类别个数
		String result="";   //存放新数据的类标签和分数
		boolean []b=new boolean[5];
		//计算每个样本到测试数据的距离
		for(int i=0;i<traindata.length;i++){
		   distences[i][0]=means(traindata[i],testdata);
		   distences[i][1]=i;
		}
		//找出k个最近邻；
		for(int i=0;i<distences.length-1;i++){
			min=i;
			for(int j=1;j<distences.length;j++){
				if(distences[j][0]<distences[i][0]){
					min=j;
				}
			}
			t=distences[i][0];
			distences[i][0]=distences[min][0];
			distences[min][0]=t;
			t=distences[i][1];
			distences[i][1]=distences[min][1];
			distences[min][1]=t;
		}
		//计算k个最近邻所属类别的个数；
	    for(int i=0;i<5;i++){
	    	 int a=culser[(int)distences[i][1]];
	    	 if(!b[i]){
	    	 for(int j=i;j<5;j++){
	    	   if(a==culser[(int)distences[j][1]]){
	    		culser2[a]++;
	    		b[i]=b[j]=true;
	    	  }
	    	}
	      }
	    }
	    //对新测试数据进行打分
	    double sum=0;
	    double grade=0;
	    for(int i=0;i<5;i++){
	    	sum+=Math.exp(-distences[i][0]);
	    }
	    for(int i=0;i<5;i++){
	    	if(culser[(int)distences[i][1]]==0)
	    	 grade+=(Math.exp(-distences[i][0])/sum)*5;
	    	if(culser[(int)distences[i][1]]==1)
		    	 grade+=(Math.exp(-distences[i][0])/sum)*4;
	    	if(culser[(int)distences[i][1]]==2)
		    	 grade+=(Math.exp(-distences[i][0])/sum)*3;
	    	if(culser[(int)distences[i][1]]==3)
		    	 grade+=(Math.exp(-distences[i][0])/sum)*2;
	    }
	    //找出k个最近邻中所属类别最多的类
	    int max=culser2[0];
	    result="优";
	    //int label=0;
	    for(int i=1;i<4;i++){
	    	if(max<culser2[i]){
	    		max=culser2[i];
	    		if(i==1)
	    		   result="良";
	    		if(i==2)
		    	   result="中";
	    		if(i==3)
		    	   result="差";
	    	}
	    }
	    String temp;
	    temp=Double.toString(grade);
	    if(temp.length()>=5)
	    	temp=temp.substring(0, 4);
	    else if(temp.length()==3)
	    	temp+="0";
	    System.out.println(temp);
	    //grade=(int)(grade*1000)/1000;
	    //result[0]=label;
	    result=temp+"("+result+")";
		return result;
		
	}
	@SuppressWarnings("unchecked")
	public String edit(){
		TestDelayInfo b = obj;
		TestDelayInfo temp = testDelayInfoService.findById(b.getOid());
		System.out.println(b.getOid());
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

