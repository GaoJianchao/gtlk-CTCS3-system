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
	<s:form width="1000px" top='10' action="editTestMonitorInfo.action" theme="simple"
		method="post"  enctype="multipart/form-data">
		<input type="hidden" value="${obj.oid }" name="obj.oid"/>
		<fieldset>
		<div id="topCmd" class="command round_top">
				<center>
					<h3>接口监测数据测试集</h3>
				</center>
			</div>
				<table id="inputTable" class="table-container" width="100%">
				<tr>
					<td class="label">日期/时间</td>
					<td><input type="text"
						name="obj.runningTime"   style="width: 170px;" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="${obj.runningTime}"/></td>
					<td class="label">*机车号</td>
					<td><input type="text"
						name="obj.trainName" class="notNull" style="width: 170px;" value="${obj.trainName}"/></td>
					<td class="label">车次号</td>
					<td><input type="text" name="obj.trainNum" style="width: 170px;" value="${obj.trainNum}"/></td>
				</tr>
				<tr>
					<td class="label">线路</td>
					<td><input type="text" name="obj.route" style="width: 170px;"  value="${obj.route}"/></td>
					<td class="label">*断开基站</td>
					<td><input type="text" name="obj.breakStation" style="width: 170px;"  value="${obj.breakStation}"/></td>
					<td class="label">降级发生时的状态</td>
					<td><input type="text" name="obj.situation" style="width: 170px;"   value="${obj.situation}"/></td>
				</tr>				
				<tr>
					<td class="label">链路断开前5-10s内PRI接口无任何数据</td>
					<td><input type="text" name="obj.priWithoutData" style="width: 170px;"  value="${obj.priWithoutData}"/></td>
					<td class="label">是否有OBU不响应RBC发送的应用层消息</td>
					<td><input type="text" name="obj.obuUnresponsive" style="width: 170px;"   value="${obj.obuUnresponsive}"/></td>
					<td class="label">是否有RBC不响应OBU发送的应用层消息</td>
					<td><input type="text" name="obj.rbcUnresponsive" style="width: 170px;"  value="${obj.rbcUnresponsive}"/></td>
				</tr>
				<tr>
					<td class="label">连接断开前19-20s以内，RBC是否正常收到OBU→RBC的AK（或其它响应）</td>
					<td><input type="text" name="obj.rbcReceiveAk" style="width: 170px;" value="${obj.rbcReceiveAk}"/></td>
					<td class="label">连接断开前19-20s以内，是否有RBC→OBU方向的AK</td>
					<td><input type="text" name="obj.rToOak" style="width: 170px;"  value="${obj.rToOak}"/></td>
					<td class="label">是否有ER类型数据</td>
					<td><input type="text" name="obj.erData" style="width: 170px;"   value="${obj.erData}"/></td>
				</tr>
				<tr>
					<td class="label">连接断开前，RBC是否正常收到OBU→RBC方向的RR确认帧</td>
					<td><input type="text" name="obj.rbcReceiveRr" style="width: 170px;"  value="${obj.rbcReceiveRr}"/></td>
					<td class="label">连接断开前，是否有RBC→OBU方向的RR确认帧</td>
					<td><input type="text" name="obj.rToOrr" style="width: 170px;"   value="${obj.rToOrr}"/></td>
					<td class="label">多个HDLC帧数据重传方向</td>
					<td><input type="text" name="obj.retransmsstionDirection" style="width: 170px;"  value="${obj.retransmsstionDirection}"/></td>
				</tr>		
				<tr>
					<td class="label">是否有长时间（7-20s）OBU→RBC方向的无效数据（处理成0,1两种）</td>
					<td><input type="text" name="obj.oToRnosensicalData" style="width: 170px;"   value="${obj.oToRnosensicalData}"/></td>
					<td class="label">除初始的SABME消息外是否还收到过该消息，若有标明方向</td>
					<td><input type="text" name="obj.repeatedSabme" style="width: 170px;"  value="${obj.repeatedSabme}"/></td>
					<td class="label">是否有收到FRMR消息，若有，标明方向</td>
					<td><input type="text" name="obj.receiveFrmr" style="width: 170px;"   value="${obj.receiveFrmr}"/></td>
				</tr>
				<tr>
					<td class="label">释放原因</td>
					<td><input type="text" name="obj.releaseReason" style="width: 170px;"  value="${obj.releaseReason}"/></td>
					<td class="label">消息类型</td>
					<td><input type="text" name="obj.messageType" style="width: 170px;"   value="${obj.messageType}"/></td>
					<td class="label">原因值</td>
					<td><input type="text" name="obj.reason" style="width: 170px;"  value="${obj.reason}"/></td>
				</tr>
				<tr>
					<td class="label">连接释放关键字</td>
					<td><input type="text" name="obj.releaseKey" style="width: 170px;"   value="${obj.releaseKey}"/></td>
					<td class="label">是否有未完成的切换</td>
					<td><input type="text" name="obj.unfinishedSwitch" style="width: 170px;"  value="${obj.unfinishedSwitch}"/></td>
					<td class="label">切换关键字</td>
					<td><input type="text" name="obj.switchKey" style="width: 170px;"   value="${obj.switchKey}"/></td>
				</tr>
				<tr>
					<td class="label">是否T3103超时（MT未执行）</td>
					<td><input type="text" name="obj.t3103Overtime" style="width: 170px;"  value="${obj.t3103Overtime}"/></td>
					<td class="label">来自BTS的异常消息（RLT超时）</td>
					<td><input type="text" name="obj.btsAbnormalMesg" style="width: 170px;"   value="${obj.btsAbnormalMesg}"/></td>
					<td class="label">是否BSC不响应切换请求</td>
					<td><input type="text" name="obj.bscUnresponsive" style="width: 170px;"  value="${obj.bscUnresponsive}"/></td>
				</tr>
				<tr>
					<td class="label">连接释放前上行通信质量</td>
					<td><input type="text" name="obj.upQuality" style="width: 170px;"   value="${obj.upQuality}"/></td>
					<td class="label">连接释放前下行通信质量</td>
					<td><input type="text" name="obj.downQuality" style="width: 170px;"   value="${obj.downQuality}"/></td>
					<td class="label">连接释放前上行电平</td>
					<td><input type="text" name="obj.upElectricity" style="width: 170px;"  value="${obj.upElectricity}"/></td>
				</tr>
				<tr>				
					<td class="label">连接释放前下行电平</td>
					<td><input type="text" name="obj.downElectricity" style="width: 170px;"   value="${obj.downElectricity}"/></td>
					<td class="label">拆链发起方</td>
   				    <td><input type="text" name="obj.initiator" style="width: 170px;" value="${obj.initiator}"/></td>
				 </tr>
			</table>
		
			<div id="bottomCmd" class="command round_bottom">&nbsp;</div>
			<p class="buttons">
				<s:submit cssClass="button" value="保存"></s:submit>
				<a class="button btn-cancel" href="listTestMonitorInfo.action">取消</a>
			</p>
		</fieldset>
	</s:form>
</div>				