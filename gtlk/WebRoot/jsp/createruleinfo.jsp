<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>
<%@ taglib prefix="ranji" uri="http://www.ranji.org/jstl/functions"%>
<link type="text/css" href="${pageContext.request.contextPath}/styles/list_trainmonitorinfo.css" rel="stylesheet" />
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

<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/jquery-1.4.min.js"></script>
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
<style>
	.label{width: 100px;text-align: left;}
</style>
<div class="table-container special" >
	<s:form width="700px" top='10' action="createRuleInfo.action" theme="simple"
		method="post"  enctype="multipart/form-data">
		<fieldset>
		<div id="topCmd" class="command round_top">
				<center>
					<h3>分类规则选择</h3>
				</center>
			</div>
				<table id="inputTable" class="table-container" width="100%">
					<div class="table-container">
							<table border="1"width="100%">
					<thead>
						<tr style="height: 30px">
							<th style="width: 30px;" class="checkbox">
								<input id="select-all" type="checkbox"
									class="select-all" title="全选" /></th>
							<th style="text-align: center; width: 30px;">序号</th>
							<th style="text-align: center">日期</th>
							<th style="text-align: center">车次号</th>
							<th style="text-align: center">线路</th>
							<th style="text-align: center">拆链发起方</th>
							<th style="text-align: center">降级类型</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="objs" var="trainmi" status="st">
							<tr style="height: 30px">
								<td><input type="checkbox" name="oids" class="select"
											value="${trainmi.oid }" />
											</td>
								<td style="text-align: center">${st.count }</td>
								<td style="text-align: center">${trainmi.runningTime }</td>					
								<td style="text-align: center">${trainmi.trainNum}</td>
								<td style="text-align: center">${trainmi.route}</td>
								<td style="text-align: center">${trainmi.initiator}</td>
								<td style="text-align: center">${trainmi.degradationType}</td>
								
							</tr>
						</s:iterator>
					</tbody>
				</table>
    				</div>
				</table>
		
			<div id="bottomCmd" class="command round_bottom">&nbsp;</div>
			<p class="buttons">
				<s:submit cssClass="button" value="选择"></s:submit>
				<a class="button btn-cancel" href="listTrainMonitorInfo.action">取消</a>
			</p>
		</fieldset>
	</s:form>
</div>