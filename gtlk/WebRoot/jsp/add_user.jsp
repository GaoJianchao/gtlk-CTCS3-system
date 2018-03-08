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

<script type="text/javascript">
$(function() {
	// 全选
	$("#select-all").click(function() {
		$('[name=oids]:checkbox').attr("checked", this.checked);
	});
});
		function delItems() {
			if ($('#password1').val()==$('#password2').val()) {
					$('#delForm').submit();			
				}
				else {
					jAlert('两次密码输入不一致', '提示消息');
				}
			}
		
</script>
<div class="table-container special" >
	<s:form id="delForm" width="700px" top='10' action="addUser.action" theme="simple"
		method="post"  enctype="multipart/form-data">
		<fieldset>
		<div id="topCmd" class="command round_top">
				<center>
					<h3>新建用户信息</h3>
				</center>
			</div>
				<table id="inputTable" class="table-container" width="100%">
				<tr>
					<td class="label">用户名</td>
					<td><input type="text" name="userName" style="width: 170px;" /></td>
					<td class="label">角色</td>
					<!--  <td><input type="text" name="obj.identity" style="width: 170px;" /></td>-->
					<td>
					<select name="identity" style="width:200">
						<option>管理员</option>
						<option>普通用户</option>
					</select>
					</td>
				</tr>
				<tr>
					<td class="label">密码</td>
					<td><input id="password1" type="password" name="password1" style="width: 170px;"  /></td>
					<td class="label">重复输入</td>
					<td><input id="password2" type="password" name="password2" style="width: 170px;"  /></td>
				</tr>
			</table>
		
			<div id="bottomCmd" class="command round_bottom">&nbsp;</div>
			<p class="buttons">
				<!--  <a class="button" href="javascript:delItems();">保存</a>-->
				<a class="button" href="addUser.action">保存</a>
				<a class="button btn-cancel" href="listUser.action">取消</a>
			</p>
		</fieldset>
	</s:form>
</div>				