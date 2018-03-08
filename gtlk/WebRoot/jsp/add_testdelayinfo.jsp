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
	<s:form width="700px" top='10' action="addTestDelayInfo.action" theme="simple"
		method="post"  enctype="multipart/form-data">
		<fieldset>
		<div id="topCmd" class="command round_top">
				<center>
					<h3>线路时延数据训练集</h3>
				</center>
			</div>
				<table id="inputTable" class="table-container" width="100%">
				<tr>
					<td class="label">线路</td>
					<td><input type="text" name="obj.route" style="width: 170px;" /></td>
					<td class="label">检测时间</td>
					<td><input type="text"
						name="obj.detectionTime"   style="width: 170px;" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" /></td>
				</tr>
				<tr>
					<td class="label">切换成功率</td>
					<td><input type="text" name="obj.switchSuccessRate" style="width: 170px;"  /></td>
					<td class="label">切换平均时延</td>
					<td><input type="text" name="obj.switchAveDelay" style="width: 170px;"  /></td>
				</tr>
				<tr>
					<td class="label">话音等级</td>
					<td><input type="text" name="obj.toneDegree" style="width: 170px;"   /></td>			
					<td class="label">传输时延平均值</td>
					<td><input type="text" name="obj.tAveDelay" style="width: 170px;"  /></td>
				</tr>
				<tr>
					<td class="label">传输无差错时间＞7s概率</td>
					<td><input type="text" name="obj.tInerrantTimeRate" style="width: 170px;"   /></td>
					<td class="label">连接建立平均时延</td>
					<td><input type="text" name="obj.linkAveDelayRate" style="width: 170px;"  /></td>
				</tr>
			</table>
		
			<div id="bottomCmd" class="command round_bottom">&nbsp;</div>
			<p class="buttons">
				<s:submit cssClass="button" value="保存"></s:submit>
				<a class="button btn-cancel" href="listTestDelayInfo.action">取消</a>
			</p>
		</fieldset>
	</s:form>
</div>				