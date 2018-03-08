<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/login.css" />
<title>CTCS-3 高铁列控智能评估系统</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/jquery-1.4.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/login.js"></script>
<script type="text/javascript">
	function validate(){
		if ($("#userName").val() == "") {
			alert("请输入账号!");
			return false;
		}
		if ($("#password").val() == "") {
			alert("请输入密码！");
			return false;
		}
		
		if ($("#rand").val() == "") {
			alert("请输入验证码！");
			return false;
		}
		
		if(validateCode()){
			return true;
		}else{
			return false;
		}
		
	}

	//-- 验证码
	function changeValidateCode(obj) {
		var timeNow = new Date().getTime();
		obj.src = "randomNum.action?time=" + timeNow;
	}
	// -- 验证验证码
	function validateCode() {
		var flag=false;
		$.ajax({
			type : "POST",
			async: false,
			url : "validataCode.action",
			data : {
				"rand" : $("#rand").val()
			},
			success : function(msg) {
				if (msg.responseStr != "") {
					//$("#msg").empty();
					//$("#msg").append(msg.responseStr);
					alert(msg.responseStr);
					flag = false;
				} else {
					//$("#msg").empty();
					flag = true;
				}
			}
		});
		return flag;
	}
</script>
</head>

<body>
<div class="logo">
</div>
<div class="login-containter"> 
<div class="login-table">
<div class="login_wrapper">
<form id="loginForm" name="loginForm" action="login" onsubmit="return validate()" method="post">
<table>
<tr>
<th><label for="userName">用户名：</label></th>      
<td>
   <input class="round_rect" id="username" name="username" type="text" /> <!--  onblur="getRoles()"-->
</td>
</tr>
<tr>
<th><label for="password">密　码：</label></th>
<td><input class="round_rect" id="password" name="password" type="password" /></td>
</tr>

<tr>
<th><label for="userName">角  色：</label></th>      
<td><select name="logrole" id="logrole"><option></option></select>
</td>
</tr>

<tr>
<th><label>验证码：</label></th>
<td><input name="rand" type="text" class="round_rect" id="rand" style="width: 90px;" value="" onshow="message_captchacode" />
<img src="randomNum.action" width="75" height="36"onclick="changeValidateCode(this);" title="刷新验证码"style="vertical-align:middle;" />
</td>
</tr>


<tr>
<th></th>
<td style="text-align: right;">
<input type="submit" class="button round_rect" value="登录" />
</td>
</tr>
</table>
</form>

</div>

<div class="footer"><p>@2015 高铁CTCS-3列控数据智能分析系统</p>
</div>
</div>
</div>
</body>
</html>