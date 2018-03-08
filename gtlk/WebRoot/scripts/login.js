function validateUser() {
	var loginFlag;
	var authFlag;
	
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
	$.ajax({
		type : "POST",
		url : "validataCode.action",
		data : {
			"rand" : $("#rand").val()
		},
		success : function(msg) {
			if (msg.responseStr != "") {
				loginFlag = "loginError";
				$("#rand").val("");
				alert("验证码错误！");
				return false;
			}else{
				$.ajax({
					cache : false,
					async : false,
					type : "post",
					dataType : "text",
					url : "login.action?dt=" + new Date().getTime(),
					data : 'userName=' + $("#userName").val() + '&password='
					+ $("#password").val(),
					success : function(data) {
						if (data == "loginError") {
							loginFlag = "loginError";
							alert("用户名或密码错误");
							return false;
						}
						if (data == "authError") {
							authFlag = "authError";
							alert("此机器没有授权，请联系管理员");
							return false;
						}
					}
				});
				if(loginFlag == "loginError"){
					return false;
				}else if(authFlag == "authError"){
					return false;
				}else{
					document.forms[0].action = "login.action";
					document.forms[0].submit();
					return true;
				}
			}
		}
	});
}

function uNameTextGetFocus() {
	document.loginForm.userName.focus();
}