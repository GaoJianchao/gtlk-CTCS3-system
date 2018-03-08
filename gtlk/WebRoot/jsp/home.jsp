<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/styles/home.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/main.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$('.menu>li').mouseover(function(e) {
        $(this).children("ul").stop().slideDown(300);
        $(this).children("a").first().css("color","rgb(255,6,13)");
        
    });
	$('.menu>li').mouseout(function(e) {
        $(this).children("ul").stop().slideUp(300);
        $(this).children("a").first().css("color","#fff");
    });
});
</script>
<script type="text/javascript">
$(function(){
	$('.sub-menu>li').mouseover(function(e) {
        $(this).children("a").first().css("color","rgb(255,6,13)");
        $(this).css("color","rgb(61,61,61)");
        
    });
	$('.sub-menu>li').mouseout(function(e) {
        $(this).children("a").first().css("color","#fff");
    });
});
</script>
<title>CTCS-3 高铁列控智能评估系统</title>
</head>

<body>
<div class="doc_main">
<div class="title"></div>
<div class="section">
<nav id="navigation">
<ul class="menu">
 <li style="list-style:none;margin:8px">
  <a class="app" hidefocus="hideFocus" href="#" target="_self">
  <em class="app-icon" style="background-image:url(${pageContext.request.contextPath}/styles/images/datelist.png)" ></em>
    接口监测数据
  </a>
   <ul class="sub-menu" style="display:none">
  	<li style="list-style:none;">
    	<a class="app2" hidefocus="hideFocus" href="listTrainMonitorInfo.action" target="contentFrame">
  			<em class="app-icon2" style="background-image:url(${pageContext.request.contextPath}/styles/images/datebase.png)" ></em>
    		训练集
  		</a>        	                	
    </li>
    <li style="list-style:none;">
    	<a class="app2" hidefocus="hideFocus" href="listTestMonitorInfo.action" target="contentFrame">
  			<em class="app-icon2" style="background-image:url(${pageContext.request.contextPath}/styles/images/datebase.png)" ></em>
    		测试集
  		</a>       	                	
    </li>
  </ul>
</li>
<li style="list-style:none;margin:8px">
  <a class="app" hidefocus="hideFocus" href="#" target="_self">
  <em class="app-icon" style="background-image:url(${pageContext.request.contextPath}/styles/images/delayinfo.png)"></em>
    线路时延数据
  </a>
  <ul class="sub-menu" style="display:none">
  	<li style="list-style:none;">
    	<a class="app2" hidefocus="hideFocus" href="listTrainDelayInfo.action" target="contentFrame">
  			<em class="app-icon2" style="background-image:url(${pageContext.request.contextPath}/styles/images/datebase.png)" ></em>
    		训练集
  		</a>         	                	
    </li>
    <li style="list-style:none;">
    	<a class="app2" hidefocus="hideFocus" href="listTestDelayInfo.action" target="contentFrame">
  			<em class="app-icon2" style="background-image:url(${pageContext.request.contextPath}/styles/images/datebase.png)" ></em>
    		测试集
  		</a>       	                	
    </li>
  </ul>
</li>
<li style="list-style:none;margin:8px">
  <a class="app" hidefocus="hideFocus" href="listRuleInfo.action" target="contentFrame">
  <em class="app-icon" style="background-image:url(${pageContext.request.contextPath}/styles/images/regulation.png)"></em>
    分类规则库
  </a>
</li>
<li style="list-style:none;margin:8px">
  <a class="app" hidefocus="hideFocus" href="${pageContext.request.contextPath}/jsp/exceptionclassify.jsp" target="contentFrame">
  <em class="app-icon" style="background-image:url(${pageContext.request.contextPath}/styles/images/decisiontree.png)"></em>
    故障分类
  </a>
</li>
<li style="list-style:none;margin:8px">
  <a class="app" hidefocus="hideFocus" href="${pageContext.request.contextPath}/jsp/score.jsp" target="contentFrame">
  <em class="app-icon" style="background-image:url(${pageContext.request.contextPath}/styles/images/score.png)"></em>
    线路评分
  </a>
</li>
<li style="list-style:none;margin:8px">
  <a class="app" hidefocus="hideFocus" href="statistics.action" target="contentFrame">
  <em class="app-icon" style="background-image:url(${pageContext.request.contextPath}/styles/images/statistic.png)"></em>
    数据统计
  </a>
</li>
<li style="list-style:none;margin:8px">
  <a class="app" hidefocus="hideFocus" href="listUser.action" target="contentFrame">
  <em class="app-icon" style="background-image:url(${pageContext.request.contextPath}/styles/images/role.png)"></em>
    用户管理
  </a>
</li>

</ul>
</nav>

<div class="section2">
<iframe id="contentFrame" name="contentFrame" frameborder="0"></iframe>
</div>

</div>

</div>
<footer id="ft"><p>@2015 </p></footer>

</body>
</html>