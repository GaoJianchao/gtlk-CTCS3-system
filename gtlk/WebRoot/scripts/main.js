// JavaScript Document
$(function(){
	//鑿滃崟鎶樺彔
	$('#app-entry li a').click(function() {
		$(this).parent().parent().toggleClass('expanded');
		var c = $(this).parent().parent().attr("class");
		if(c=='expanded'){
			$(this).parent().next().slideDown();
			$(this).parent().parent().prevAll().attr("class","");
			$(this).parent().parent().nextAll().attr("class","");
			$(this).parent().parent().prevAll().children().next().slideUp();
			$(this).parent().parent().nextAll().children().next().slideUp();
		}else{
			$(this).parent().next().slideUp();
		}
	});
	//涓哄崟鍑昏彍鍗曟坊鍔犻�涓牱寮忥紝骞舵樉绀虹浉搴斿唴瀹圭殑"姝ｅ湪鍔犺浇"妗�
	$('#menu li ul li a').click(function() {
		$('#menu li ul li').removeClass('active');
		$(this).parent().addClass('active');
		$('#loading').show();
	});
	//涓衡�棣栭〉鈥濋摼鎺ワ紝鏄剧ず鈥滄鍦ㄥ姞杞解�妗�
	$('a#homeLink').click(function() {
	    $('#menu li ul li').removeClass('active');
		$('#loading').show();
	});
	//褰搃frame涓殑鍐呭鍔犺浇瀹屾瘯鍚庯紝闅愯棌"姝ｅ湪鍔犺浇"妗�
	$('iframe#contentFrame').load(function(){		
		$('#loading').hide();
	});
	$(document).load(function(){
		$('#loading').hide();
	});
})