<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
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
<h4 style="background: url(${pageContext.request.contextPath}/styles/images/home.png) no-repeat;"> 当前位置：故障分类<a></a><span></span></h4>
<h3 style="background: url(${pageContext.request.contextPath}/styles/images/h3-bg.png) repeat-x;">接口监测数据——测试集</h3>
<div id="main">
	<div id="topCmd" class="command roubd_top">
		<a class="button" href="#">添加测试集</a>			
		<a class="button dialog-link" href="${pageContext.request.contextPath}/jsp/select_ruleinfo.jsp">批量分类</a>			
		<div class="search-pannel">
			<a class="button" href="#">导入excel表</a>
			<a class="button" href="#">导出excel表</a>
			<a class="advanced" href="#" title="高级查询">高级查询</a>
            <div class="more-search commom-form has_shadow" style="display:none;width:410px">
            	<form action="#" method="post">
                	<fieldset>
                    	<legend>高级查询</legend>
                        <table>
                        	<tbody>
                            	<tr>
									<th>线路运行时间/日期：</th>
									<td colspan="3">
										<input type="text" size="19" name="startAcctime" value="" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>~
										<input type="text" size="19" name="endAcctime" value="" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
									</td>
								</tr>
								<tr>
									<th>机车号：</th>
									<td>
										<input type="text" size="20" name="casenum" value=""/>
									</td>
									<th>车次号：</th>
									<td>
										<input type="text" size="20" name="caseregnum" value=""/>
									</td>
								</tr>
								<tr>
									<th>线路：</th>
									<td>
										<input type="text" size="20" name="caseaccnum" value=""/>
									</td>
									<th>断开基站：</th>
									<td>
										<input type="text" size="20" name="casetype" value=""/>
									</td>
								</tr>
								<tr>
									<th>降级发生时的状态：</th>
									<td>
										<input type="text" size="20" name="occurplace" value=""/>
									</td>
									<th>链路断开前5-10s内PRI接口无任何数据：</th>
									<td>
										<input type="text" size="20" name="occurarea" value=""/>
									</td>
								</tr>
								<tr>
									<th>是否有OBU不响应RBC发送的应用层消息：</th>
									<td>
										<input type="text" size="14" name="managestation" value=""/>
									</td>
									<th>是否有RBC不响应OBU发送的应用层消息：</th>
									<td>
										<input type="text" size="14" name="casestate" value=""/>
									</td>
								</tr>
                                <tr>
									<th>连接断开前19-20s以内，RBC是否正常收到OBU→RBC的AK（或其它响应）：</th>
									<td>
										<input type="text" size="14" name="managestation" value=""/>
									</td>
									<th>连接断开前19-20s以内，是否有RBC→OBU方向的AK：</th>
									<td>
										<input type="text" size="14" name="casestate" value=""/>
									</td>
								</tr>
                              	<tr>
									<th>拆链发起方：</th>
									<td>
										<input type="text" size="14" name="managestation" value=""/>
									</td>
									<th>降级类型：</th>
									<td>
										<input type="text" size="14" name="casestate" value=""/>
									</td>
								</tr>
							</tbody>
                        </table>
                    </fieldset>
                	<p class="button">
                    
                    
                    </p>
                </form>
		</div>						
	</div>
	<div class="table-container">
    
    
    
    </div>
	<div id="bottonCmd" class="command round_bottom">
    </div>
</div>
</div>
</body>
</html>