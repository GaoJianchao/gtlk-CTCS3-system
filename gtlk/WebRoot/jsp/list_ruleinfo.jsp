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
<h4 style="background: url(${pageContext.request.contextPath}/styles/images/home.png) no-repeat;"> 当前位置：<a>分类规则库</a><span></span></h4>
<h3 style="background: url(${pageContext.request.contextPath}/styles/images/h3-bg.png) repeat-x;">分类规则</h3>
<div id="main">
	<div id="topCmd" class="command roubd_top">			
		<a class="button" href="javascript:delItems();">批量删除</a>			
		<div class="search-pannel">
			<a class="button" href="#">导出excel表</a>					
	</div>
	<div class="table-container">
    	<s:form id="delForm" action="delRuleInfo.action" method="post"
						theme="simple">
				<table border="1" width="100%">
					<thead>
						<tr style="height: 30px">
							<th style="width: 30px;" class="checkbox">
								<input id="select-all" type="checkbox"
									class="select-all" title="全选" /></th>
							<th style="text-align: center; width: 30px;">序号</th>
							<th style="text-align: center">创建时间</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="objs" var="r" status="st">
							<tr style="height: 30px">
								<td><input type="checkbox" name="oids" class="select"
											value="${r.oid }" />
											</td>
								<td style="text-align: center">${st.count }</td>
								<td style="text-align: center">${r.creatTime }</td>				
							</tr>
						</s:iterator>
					</tbody>
				</table>
				</s:form>
    
    
    </div>
	<div id="bottomCmd" class="command round_bottom">
				
			</div>

</div>
</div>
</body>
</html>