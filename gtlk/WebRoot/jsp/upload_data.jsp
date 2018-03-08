<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>
<%@ taglib prefix="ranji" uri="http://www.ranji.org/jstl/functions"%>
<script type="text/javascript">
	function validate() {
		var flag1 = false;
		$.each($('.notNull'), function(i, dom) {
			if ($.trim($(dom).val()) == "") {
				flag1 = true;
			}
		});
		if (flag1) {
			alert("请确认所有带*项非空！");
			return false;
		} else {
			return true;
		}
	}
</script>
<style>
	.label{width: 100px;text-align: left;}
</style>
<div class="table-container special" >
	
	<s:form width="400px" top='100px' left="100px"  action="uploadData.action" theme="simple"
		method="post"  enctype="multipart/form-data"><!-- onsubmit="return validate();" -->
		<fieldset>
		<div id="topCmd" class="command round_top">
				<center>
					<h3>导入数据集</h3>
				</center>
			</div>
				<table id="inputTable" class="table-container" width="100%">
				<tr>
					<td class="label">数据类型</td>
					<td>
					<select name="dataType" style="width:200">
						<option>接口监测数据训练集</option>
						<option>接口监测数据测试集</option>
						<option>线路时延数据训练集</option>
						<option>线路时延数据测试集</option>
					</select>
					</td>
				</tr>
				<tr>
					<td class="label">*excle文档：</td>
					  <td><input type="file"
						name="attachFile" class="notNull" id="attachFile" style="width: 100%;"/></td>
				</tr>
			</table>
			<div id="bottomCmd" class="command round_bottom">&nbsp;</div>
			<p class="buttons">
				<s:submit cssClass="button" value="上传"></s:submit>
				<a class="button btn-cancel">关闭</a>
			</p>
		</fieldset>
	</s:form>
</div>