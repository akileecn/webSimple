(function($){
	//json转化为字符串
	function _toString(obj){
		if(obj==undefined||obj==null){
			return "";
		}
		var text="";
		var type=typeof(obj);
		//数字或布尔
		if(type=="number"||type=="boolean"){
			text=obj;
		//字符串
		}else if(type=="string"){
			text="\""+obj+"\"";
		//数组
		}else if(obj instanceof Array){
			text+="[";
			for(var i=0;i<obj.length;i++){
				if(i==0){
					text+=_toString(obj[i]);
				}else{
					text+=","+_toString(obj[i]);
				}
			}
			text+="]";
		//一般对象
		}else if(obj instanceof Object){
			text+="{";
			var isFirst=true;
			for(var key in obj){
				if(isFirst){
					text+="\""+key+"\":"+_toString(obj[key]);
					isFirst=false;
				}else{
					text+=",\""+key+"\":"+_toString(obj[key]);
				}
			}
			text+="}";
		}
		return text;
	}
	//alert对象属性
	$.alert=function(data){
		alert(_toString(data));
	}
	
	//模板替换
	function _template(html,data){
		return html.replace(/\%\{.+?\}/g,function(word){
			if(!data){
				return "";
			}
			var word=word.substring(2,word.length-1);
			var keys=word.split(".");
			var value=data;
			for(var i=0;i<keys.length;i++){
				value=value[keys[i]];
				if(value==null){
					return "";
				}
			}
			return value;
		});
	}
	$.template=_template;
	$.fn.template=function(html,data){
		//一个参数
		if(html instanceof Object){
			data=html;
			html=$(this).html();
		}
		$(this).html(_template(html,data));
	}
	
	//设置时间插件的默认格式
	if($.fn.datetimepicker){
		$.fn.datetimepicker.defaults={
				format:"yyyy-mm-dd"
					,minView:"month"
						,language:"zh-CN"
		}
	}
	
	//获得表单数据
	$.fn.getFormData=function(){
		var obj={};
		//正常表单值
		var arr=$(this).serializeArray();
		if(arr&&arr.length>0){
			for(var i=0;i<arr.length;i++){
				var item=arr[i];
				if(item.value!=null&&item.value!=""){
					if(obj[item.name]==null){
						obj[item.name]=item.value;
					}else if(obj[item.name] instanceof Array){
						obj[item.name].push(item.value);
					}else{
						var valueArr=[];
						valueArr.push(obj[item.name]);
						valueArr.push(item.value);
						obj[item.name]=valueArr;
					}
				}
			}
		}
		//翻译信息
		obj.t={};
		$(this).find("option:selected").each(function(){
			var value=$(this).val();
			//排除空选项
			if(value){
				var name=$(this).parent("select").attr("name");
				var text=$(this).text();
				//兼容other
				if(!name){
					name=$(this).parent("select").siblings("input").attr("name");
					if(value=="other"){
						text=$(this).parent("select").siblings("input").val();
					}
				}
				obj.t[name]=text;
			}
		});
		$(this).find("input:checked").each(function(){
			var name=$(this).attr("name");
			var value=$(this)[0].nextSibling.nodeValue;
			obj.t[name]=value;
		});
		return obj;
	}
	
	//获得文本表单数据
	$.fn.getFormTextData=function(){
		var $spans=$(this).find("span[data-name]");
		var obj={};
		for(var i=0;i<$spans.length;i++){
			var $span=$($spans[i]);
			var name=$span.attr("data-name");
			var value=$span.attr("data-value");
			if(value==null||value==""){
				value=$span.text();
			}
			if(name&&value){
				obj[name]=value;
			}
		}
		return obj;
	}
	
	//清空错误信息
	$.fn.clearError=function(error){
		$(this).find(".col_cv_alt").empty();
	}
	
	//显示错误信息
	$.fn.showError=function(error){
		$(this).clearError();
		if(error){
			for(var key in error){
				$(this).find(".col_cv_alt[data-error='"+key+"']").text(error[key]);
			}
		}
		
	}
}(window.$));