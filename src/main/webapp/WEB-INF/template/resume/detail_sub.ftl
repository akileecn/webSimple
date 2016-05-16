<script type="text/javascript">
	//全局模版保存对象
	var Tempate={};
	
	//添加
	function addSub(dataType,templateType){
		var template=Tempate[dataType][templateType];
		$("#"+dataType+"Div").appendTemplate(template);
		if(templateType=="input"){
			//初始化时间插件
			$("#"+dataType+"Div:last-child").find(".form_datetime").datetimepicker();
		}
	}
	
	//切换为编辑
	function toUpdateSub(dataType,self){
	
	}
	//删除
	function deleteSub(dataType,self){
		$form=$(self).parents("form");
		//移除时间插件(可选)
		$form.find(".form_datetime").datetimepicker("remove");
		$form.remove();
	}
	
	//保存
	function saveSub(dataType,self){
		$form=$(self).parents("form");
		$form.ajaxSubmit({
			url:"<@spring.url "/resume/save/"/>"+dataType
			,data:{"resumeId":"${id}"}
			,type:"post"
			,success:function(text){
				if(text.success){
					var data=$form.getFormData();
					data.resumeId=text.data;
					
				}
			}
		});
		
	}
</script>
<#include "resume/detail_sub_award.ftl"/>