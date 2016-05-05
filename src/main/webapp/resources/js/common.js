(function(jQuery){
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
					text+=toString(obj[i]);
				}else{
					text+=","+toString(obj[i]);
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
	jQuery.toString=_toString;
	
	//模板替换
	function _template(html,data){
		return html.replace(/\%\{.+?\}/g,function(word){
			var word=word.substring(2,word.length-1);
			var keys=word.split(".");
			var value=data;
			for(var i=0;i<keys.length;i++){
				value=value[keys[i]];
				if(!value){
					return "";
				}
			}
			return value;
		});
	}
	jQuery.template=_template;
	jQuery.fn.template=function(html,data){
		//一个参数
		if(html instanceof Object){
			data=html;
			html=$(this).html();
		}
		$(this).html(_template(html,data));
	}
}(window.$));