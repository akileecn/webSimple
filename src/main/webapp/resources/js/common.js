(function(jQuery){
	//json转化为字符串
	function toString(obj){
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
					text+="\""+key+"\":"+toString(obj[key]);
					isFirst=false;
				}else{
					text+=",\""+key+"\":"+toString(obj[key]);
				}
			}
			text+="}";
		}
		return text;
	}
	jQuery.toString=toString;
}(window.$));