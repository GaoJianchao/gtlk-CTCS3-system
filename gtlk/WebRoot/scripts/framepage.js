// JavaScript Document

//jQuery plugin for enhance UI elements' function and behavior by their classes;
(function($) {
    $.fn.enhanceUIElements = function() {
        //calendar for input of date class
	    $(this).find('input[type=text].date').datepicker({changeYear:true}); 
        $(this).find('a.dialog-link').click($.onDialogLinkClick);
        return this;
    }
    
    //click event handler for dialog link
    $.onDialogLinkClick = function() {
            var dialogTitle = this.title ? this.title : $(this).html();
            $('#indicator').show();
            $.get(this.href,function(htmlData) {
            	if(htmlData.indexOf("您尚未登录")>0){
            		alert("会话已失效，请重新登录！");
            		if (top.location !== self.location) { 
            			top.location=window.location.protocol+"//"+window.location.host+"/qbhs/index.jsp";//跳出框架，并回到首页 
            		} 
            		return; 
            	}
                $('#indicator').hide();
                htmlData = "<div>" + htmlData + "</div>"
                var dialogInnerHtml = $(htmlData).find('form');
                var dialogWidth = dialogInnerHtml.attr('width')? dialogInnerHtml.attr('width'):'auto';
                var dialogHeight = dialogInnerHtml.attr('height')? dialogInnerHtml.attr('height'):'auto';
                var dialogTop = dialogInnerHtml.attr('top')? dialogInnerHtml.attr('top'):'auto';
                var dialog = $.openDialog(dialogTitle,htmlData,dialogWidth,dialogHeight,dialogTop);
                dialog.enhanceUIElements();
            });
            return false;
	}
    
    $.openDialog = function(title,htmlData,width,height,top,left) {
        var dialogDiv = '<div class="common-form"></div>';
        var dialogInstance = $(dialogDiv).appendTo($(document)).dialog({
            modal: true,
            title: title,
            height: height,
            width: width,
            minWidth:250,
            minHeight:150,
            resizable:false,
            show: 'scale',
            hide: 'scale',
            // 淇敼瀵硅瘽妗嗗脊鍑轰綅缃�
            position: ['auto', parseInt(top)],
            close: function(){
                dialogInstance.dialog('destroy');
                dialogInstance.remove();
            }
        });
        dialogInstance.append(htmlData);
        dialogInstance.find('.btn-cancel').click(function(){
            dialogInstance.dialog('close');
        });
        return dialogInstance;
    }   
})(jQuery);

$(function(){
	//change the row style when the checkbox is checked in the row
	$('table tr td input[type=checkbox]').change(function() {
	    var inRow = $(this).closest('tr');
		if (this.checked) {
			inRow.addClass('selected');
		}
		else {
			inRow.removeClass('selected');
		}
	});
	
	//select all rows 
	$('table tr th input[type=checkbox]').change(function() {
		$(this).closest('table').find('tr td input[type=checkbox]')
		.attr('checked',this.checked)
		.trigger('change');
	});

	//display or hide the more search panel
	var searchPanel = $('div.search-panel');
	var moreSearch = searchPanel.find('div.more-search');
        moreSearch.enhanceUIElements();
	searchPanel.find('a.advanced').click(function() {
		if (moreSearch.is(':visible')) {
			$(this).removeClass('active');
			moreSearch.slideUp();
		}
		else {
			$(this).addClass('active');
			moreSearch.slideDown();
		}
	});
	
	moreSearch.find('.btn-cancel').click(function() {
		searchPanel.find('a.advanced').removeClass('active');
		moreSearch.slideUp();
	});
	
    //load content to dialog when buttons of class dialog-link is clicked.
    $(document).enhanceUIElements();
});