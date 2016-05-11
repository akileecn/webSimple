<script type="text/javascript">
	//全局模版保存对象
	var Tempate={};
	
	//添加模板
	function addTemplate(dataType,templateType){
		var template=Tempate[dataType][templateType];
		$("#"+dataType+"Div").append($.template(template));
		if(templateType=="input"){
			//初始化时间插件
			$("#"+dataType+"Div:last-child").find(".form_datetime").datetimepicker();
		}
	}
	
	//删除模版
	function deleteTemplate(self){
		$form=$(self).parent("form");
		//移除时间插件(可选)
		$form.find(".form_datetime").datetimepicker("remove");
		$form.remove();
	}
</script>
<#include "resume/detail_sub_award.ftl"/>