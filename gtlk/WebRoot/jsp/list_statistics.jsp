<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>
<%@ taglib prefix="ranji" uri="http://www.ranji.org/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" href="${pageContext.request.contextPath}/styles/list_trainmonitorinfo.css" rel="stylesheet"/>
<link type="text/css"
	href="${pageContext.request.contextPath}/styles/jquery_ui_cupertino/jquery-ui.css"
	rel="stylesheet" />
<link type="text/css"
	href="${pageContext.request.contextPath}/styles/global.css"
	rel="stylesheet" />
<link type="text/css"
	href="${pageContext.request.contextPath}/styles/framepage.css"
	rel="stylesheet" />
<link type="text/css"
	href="${pageContext.request.contextPath}/styles/jquery.alerts/jquery.alerts.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/styles/jquery.treeview/jquery.treeview.css"
	rel="stylesheet" charset="utf-8" />
<link type="text/css"
	href="${pageContext.request.contextPath}/scripts/My97DatePicker/skin/WdatePicker.css"
	rel="stylesheet" />

<script language="javascript" src="${pageContext.request.contextPath}/scripts/jquery-1.7.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/jquery_ui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/i18n/jquery.ui.datepicker-zh-CN.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/framepage.js"></script>
<!--[if lt IE 8]>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/ie.js"></script>
<![endif]-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/jquery.scroller2-1.61.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/jquery.alerts.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/My97DatePicker/WdatePicker.js"></script>
<!-- autocomplete -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/jquery.ui.autocomplete.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/autoCompleteQbhs.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/checkidcard.js"></script>
<title></title>
<script type="text/javascript">
$(function() {
	// 全选
	$("#select-all").click(function() {
		$('[name=oids]:checkbox').attr("checked", this.checked);
	});
});
		function delItems() {
		jConfirm('危险，真的要删除吗？', '确认框', function(result) {
			if (result) {
				var checkArr = document.getElementsByName('oids');
				var flag = false;
				for (i = 0; i < checkArr.length; i++) {
					if (checkArr[i].checked) {
						flag = true;
						break;
					}
				}
				if (flag) {
					$('#delForm').submit();
				} else {
					jAlert('您还没有选择要删除的条目', '提示消息');
				}
			}
		});
	}
</script>
<title>无标题文档</title>
</head>

<body>
<h4 style="background: url(${pageContext.request.contextPath}/styles/images/home.png) no-repeat;"> 当前位置：<a>数据统计</a><span></span></h4>
<h3 style="background: url(${pageContext.request.contextPath}/styles/images/h3-bg.png) repeat-x;">降级故障统计</h3>
<div id="main">					
	<div class="table-container">
    	<s:form id="delForm" action="#" method="post" theme="simple">
				<table border="1" width="100%">
					<thead>
						<tr style="height: 30px">
							<th style="text-align: center">故障类型</th>
							<th style="text-align: center">记录条数</th>
							<th style="text-align: center">占比</th>
						</tr>
					</thead>
					<tbody>
							<tr style="height: 30px">
								<td style="text-align: center">ATP/RBC复合因素</td>
								<td style="text-align: center">${type0}</td>	
								<td style="text-align: center">${rate0}</td>			
							</tr>
							<tr style="height: 30px">
								<td style="text-align: center">ATP方面</td>
								<td style="text-align: center">${type1}</td>
								<td style="text-align: center">${rate1}</td>				
							</tr>
							<tr style="height: 30px">
								<td style="text-align: center">BSC故障</td>
								<td style="text-align: center">${type2}</td>
								<td style="text-align: center">${rate2}</td>				
							</tr>
							<tr style="height: 30px">
								<td style="text-align: center">MSC向两端发起拆线</td>
								<td style="text-align: center">${type3}</td>
								<td style="text-align: center">${rate3}</td>				
							</tr>
							<tr style="height: 30px">
								<td style="text-align: center">RBC方面</td>
								<td style="text-align: center">${type4}</td>
								<td style="text-align: center">${rate4}</td>				
							</tr>
							<tr style="height: 30px">
								<td style="text-align: center">不明情况</td>
								<td style="text-align: center">${type5}</td>
								<td style="text-align: center">${rate5}</td>				
							</tr>
							<tr style="height: 30px">
								<td style="text-align: center">不明情况2</td>
								<td style="text-align: center">${type6}</td>
								<td style="text-align: center">${rate6}</td>				
							</tr>
							<tr style="height: 30px">
								<td style="text-align: center">不明情况3</td>
								<td style="text-align: center">${type7}</td>	
								<td style="text-align: center">${rate7}</td>			
							</tr>
							<tr style="height: 30px">
								<td style="text-align: center">切换相关</td>
								<td style="text-align: center">${type8}</td>
								<td style="text-align: center">${rate8}</td>				
							</tr>
							<tr style="height: 30px">
								<td style="text-align: center">质量恶化，列控用户发起拆链</td>
								<td style="text-align: center">${type9}</td>	
								<td style="text-align: center">${rate9}</td>			
							</tr>
							<tr style="height: 30px">
								<td style="text-align: center">总计</td>
								<td style="text-align: center">${total}</td>
								<td style="text-align: center">1</td>				
							</tr>
					</tbody>
				</table>
				</s:form>   
    </div>
</div>

<h3 style="background: url(${pageContext.request.contextPath}/styles/images/h3-bg.png) repeat-x;">QoS评分统计</h3>
<div id="main">					
	<div class="table-container">
    	<s:form id="delForm" action="trainMonitorInfo" method="post" theme="simple">
				<table border="1" width="100%">
					<thead>
						<tr style="height: 30px">
							<th style="text-align: center">评分等级</th>
							<th style="text-align: center">记录条数</th>
						</tr>
					</thead>
					<tbody>
						<tr style="height: 30px">
								<td style="text-align: center">优</td>
								<td style="text-align: center">${score0}</td>				
						</tr>
						<tr style="height: 30px">
								<td style="text-align: center">良</td>
								<td style="text-align: center">${score1}</td>				
						</tr>
						<tr style="height: 30px">
								<td style="text-align: center">中</td>
								<td style="text-align: center">${score2}</td>				
						</tr>
						<tr style="height: 30px">
								<td style="text-align: center">差</td>
								<td style="text-align: center">${score3}</td>				
						</tr>
					</tbody>
				</table>
				</s:form>   
    </div>
</div>

<h3 style="background: url(${pageContext.request.contextPath}/styles/images/h3-bg.png) repeat-x;">数据集数量统计</h3>
<div id="main">					
	<div class="table-container">
    	<s:form id="delForm" action="trainMonitorInfo" method="post" theme="simple">
				<table border="1" width="100%">
					<thead>
						<tr style="height: 30px">
							<th style="text-align: center">数据集类型</th>
							<th style="text-align: center">记录条数</th>
						</tr>
					</thead>
					<tbody>
						<tr style="height: 30px">
							<td style="text-align: center">接口监测数据训练集</td>
							<td style="text-align: center">${trainmi}</td>				
						</tr>
						<tr style="height: 30px">
							<td style="text-align: center">接口监测数据测试集</td>
							<td style="text-align: center">${testmi}</td>				
						</tr>
						<tr style="height: 30px">
							<td style="text-align: center">线路时延数据训练集</td>
							<td style="text-align: center">${traindi}</td>				
						</tr>
						<tr style="height: 30px">
							<td style="text-align: center">线路时延数据测试集</td>
							<td style="text-align: center">${testdi}</td>				
						</tr>
					</tbody>
				</table>
				</s:form>   
    </div>
</div>
</body>
</html>