//应用路径
var baseUrl="/web/" ;


//清空验证提示信息
$.fn.clearError = function(error){
	$(this).find(".col_cv_alt").empty();
}

//显示验证提示信息

$.fn.showError = function(error){
	$(this).clearError();
	if(error){
		for(var key in error){
			$(this).find(".col_cv_alt[data-error='"+ key +"']").text(error[key]);			
		}
	}
}


function goHome($t){
	location.href="main.html";
}



