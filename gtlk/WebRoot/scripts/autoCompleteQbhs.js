var proName = "/qbhs";
function autoCaseInfo(inputId, tempinputId, hiddenId) {
	$("#" + inputId).autocomplete({
		source : function(request, response) {
			$.ajax({
				url : proName+"/qb/ajaxCaseInfo.action",
				type : "POST",
				dataType : "json",
				data : {
					"casenum" : $("#" + inputId).val()
				},
				success : function(data) {
					response($.map(data.objs, function(obj, i) {
						return {
							label : obj.casenum,
							value : obj.casenum,
							hiddenOid : obj.oid
						}
					}));
				}
			});
		},
		minLength : 1,
		// 閫変腑鏃�
		select : function(event, ui) {
			$('#' + hiddenId).val(ui.item.hiddenOid);
			$('#' + tempinputId).val(ui.item.value);
		}
	});
}

function autoCaseInfo2(inputId, tempinputId, hiddenId,caseType,dept,handler) {
	$("#" + inputId).autocomplete({
		source : function(request, response) {
			$.ajax({
				url : proName+"/qb/ajaxCaseInfo2.action",
				type : "POST",
				dataType : "json",
				data : {
					"casenum" : $("#" + inputId).val()
				},			
				success : function(data) {
					response($.map(data.objs, function(obj, i) {
						return {
							label : obj.casenum,
							value : obj.casenum,
							hiddenOid : obj.oid,
							caseType:obj.casetype.name,
							dept:obj.managestation,
							handler:obj.soldep
						}
					}));
				}
			});
		},
		minLength : 1,
		// 选中时
		select : function(event, ui) {
			//alert(event.srcElement.innerHTML);
			$('#' + hiddenId).val(ui.item.hiddenOid);
			$('#' + tempinputId).val(ui.item.value);
			$('#' + caseType).val(ui.item.caseType);
			$('#' + dept).val(ui.item.dept);
			$('#' + handler).val(ui.item.handler);
//			alert("ui.item.hiddenOid"+ui.item.hiddenOid);
			if(event.srcElement.innerHTML== ui.item.value){
				//alert("select");
				//getSuspects(ui.item.hiddenOid);
			}
			
		}
	});
}

function getSuspects(hiddenId,susid,sex){
	//var n = $('#' + hiddenId).val();
	//alert("hiddenId is :"+hiddenId);
	//alert("getSuspects");
	//alert(sex);
	$.ajax({
			   type: "POST",
			   async: false,
			   url: "getSusByCase.action",
			   data: "casenum="+hiddenId,
			   success: function(data){
				   //alert("data.ret:"+data.ret);
				    if(data.ret != ""){
				    	var person = data.ret.split("&");//将astr分割，
				    	
				    	if(person.length>0){
				    		$("#susname").empty();
				    		if(typeof susid === 'undefined'){
				    			$("#susname").append(new Option("请选择","0"));
				    		}
				    		
				    		for(i=0;i<person.length;i++){
				    			var arr = person[i].split(",");
				    			$("#susname").append(new Option(arr[1],arr[0]));
				    			if(typeof susid!== 'undefined' &&arr[0]==susid){
				    				$("#susname").find("option[value='"+arr[0]+"']").attr("selected",true);
					    			if(typeof sex!== 'undefined'){
					    				if(sex=="Y"){
					    					//alert("Y");
					    					$("#sussex").empty();
					    					$("#sussex").append("<option value='Y' selected='true'>男</option>");
					    					$("#sussex").append("<option value='N'>女</option>");
					    				}else{
					    					//alert("N");
					    					$("#sussex").empty();
					    					$("#sussex").append("<option value='Y'>男</option>");
					    					$("#sussex").append("<option value='N' selected='true'>女</option>");
					    				}
					    			}
				    			}else{
				    				
				    			}
				    		}
				    	}

					}else{
						$("#susname").empty();
						$("#susname").append(new Option("请选择","0"));
					} 
			   }
			});
		
	}


function checkBidUnit(inputId,hiddenId) {
	var t = $.trim($("#"+inputId).val());
	var t1 = $.trim($("#"+hiddenId).val());
	if(hiddenId == null || t != t1){
		$.ajax({
			url : proName+"/qb/checkCaseInfo.action",
			type : "POST",
			dataType : "json",
			data : {
				"casenum" : $("#" + inputId).val()
			},
			success : function(data) {
				if (data.oid != 0) {
					alert("该案件号已存在！");
					$("#" + inputId).val("");
				}
			}
		});
	}
}

function getBidUnitId(inputId,tempinputId ,hiddenId) {
	var t1 = $.trim($("#" + inputId).val());
	var t2 = $.trim($("#" + tempinputId).val());
	var t3 = $.trim($("#" + hiddenId).val());
	if(t3 == "" || t1 != t2){
		$.ajax({
			url : proName+"/qb/checkCaseInfo.action",
			type : "POST",
			dataType : "json",
			data : {
				"casenum" : $("#" + inputId).val()
			},
			success : function(data) {
				if (data.oid != 0) {
					$('#' + hiddenId).val(data.oid);
				}else{
					$('#' + inputId).val("");
					$('#' + hiddenId).val("");
				}
			}
		});
	}
}

function getBidUnitId2(inputId,tempinputId,hiddenId,caseType,dept,handler) {
	var t1 = $.trim($("#" + inputId).val());
	var t2 = $.trim($("#" + tempinputId).val());
	var t3 = $.trim($("#" + hiddenId).val());
	//alert("inputId : "+t1 + " & tempinputId : "+t2+ " & hiddenId : "+t3);
	if((t3 == "" || t1 != t2) || (t3!="" && t1==t2)){
		$.ajax({
			url : proName+"/qb/checkCaseInfo2.action",
			type : "POST",
			dataType : "json",
			data : {
				"casenum" : $("#" + inputId).val()
			},
			success : function(data) {
				//alert("data.ret:"+data.ret);
				//alert("getBidUnitId2");
				if(data.ret!=""){
					var s1 = data.ret.split(",");
					$('#' + hiddenId).val(s1[0]);
					if(typeof caseType !== 'undefined'){
						$('#' + caseType).val(s1[1]);
					}
					if(typeof dept !== 'undefined'){
						$('#' + dept).val(s1[2]);
					}
					if(typeof handler !== 'undefined'){
						$('#' + handler).val(s1[3]);
					}
					getSuspects(s1[0]);
				}else{
					$('#' + inputId).val("");
					$('#' + hiddenId).val("");
					if(typeof caseType !== 'undefined'){
						$('#' + caseType).val("");
					}
					if(typeof dept !== 'undefined'){
						$('#' + dept).val("");
					}
					if(typeof handler !== 'undefined'){
						$('#' + handler).val("");
					}
					$("#susname").empty();
					$("#susname").append(new Option("请选择","0"));
					//getSuspects("0");
				}
				
			}
		});
	}
}
