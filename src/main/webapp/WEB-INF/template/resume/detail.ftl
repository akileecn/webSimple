<@bootstrap.head>
<title>简历详情</title>
</@bootstrap.head>
<@bootstrap.body>
<script type="text/javascript">
	//全局模版保存对象
	var Tempate={};
</script>
<#include "/resume/detail_base.ftl"/>
<#include "/resume/detail_sub_award.ftl"/>
<script type="text/javascript">
	$(document).ready(function(){
		//初始化时间插件
		$(".form_datetime").datetimepicker();
	
		$.post("<@spring.url "/resume/detail/all"/>",{"id":"${id}"},function(text){
			if(text.success){
				//基本信息
				var resume=text.data;
				$("#baseForm").autofill(resume);
				//从属信息
				var subs=["award"];
				for(var i=0;i<subs.length;i++){
					var dataType=subs[i];
					var datas=resume[dataType+"List"];
					if(datas){
						for(var i=0;i<datas.length;i++){
							addSub(dataType,"text",datas[i]);
						}
					}
				}
			}
		});
		
	});
	
	//添加
	function addSub(dataType,templateType,data){
		var $div=$("#"+dataType+"Div");
		var template=Tempate[dataType][templateType];
		if(templateType=="input"){
			$div.append(template);
			//初始化时间插件
			$div.find(":last-child .form_datetime").datetimepicker();
		}else if(templateType=="text"){
			$div.append($.template(template,data));
		}
	}
	
	//切换
	function switchSub(dataType,self,extData){
		var $form=$(self).parents("form");
		//表单原来类型
		var oldType=$form.attr("data-type");
		if(oldType=="text"){
			var template=Tempate[dataType]["input"];
			var data=$form.getFormTextData();
			$form.html(template);
			$form.autofill(data);
			//初始化时间插件
			$form.find(".form_datetime").datetimepicker();
			$form.attr("data-type","input");
		}else if(oldType=="input"){
			var template=Tempate[dataType]["text"];
			var data=$form.getFormData();
			if(extData){
				$.extend(data,extData);
			}
			//移除时间插件(可选)
			$form.find(".form_datetime").datetimepicker("remove");
			$form.html($.template(template,data));
			$form.attr("data-type","text");
		}
	}
	
	//删除
	function deleteSub(dataType,self){
		$form=$(self).parents("form");
		//表单原来类型
		var oldType=$form.attr("data-type");
		if(oldType=="text"){
			var id=$form.find("span[data-name='id']").text();
		}else if(oldType=="input"){
			var id=$form.find("input[name='id']").val();
		}
		if(id){
			$.ajax({
				url:"<@spring.url "/resume/delete/"/>"+dataType
				,data:{"id":id,"resumeId":"${id}"}
				,type:"post"
				,success:function(text){
					if(text.success){
						afterDelete($form);
					}
				}
			});
		}else{
			afterDelete($form);
		}
	}
	function afterDelete($form){
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
					switchSub(dataType,self,{id:text.data});
				}
			}
		});
	}
</script> 
</@bootstrap.body>