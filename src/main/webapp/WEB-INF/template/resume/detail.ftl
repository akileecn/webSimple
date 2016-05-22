<#-- 样式宏 -->
<#include "/resume/detail_common.ftl"/>
<@bootstrap.head>
<title>简历详情</title>
</@bootstrap.head>
<@bootstrap.body>
<script type="text/javascript">
	//全局模版保存对象
	var T={};
</script>
<div class="container">
	<#include "/resume/left.ftl"/>
	<div class='col-xs-9 padding-l  padding-t'>
	    <div class="box_3">
	        <div class="box_4 minheight">
	            <h3>我的简历</h3>
	            <div class="col_more fr"><a href="#">首页</a> - <a href="#">我的简历</a> - <a href="#"><span >更多 &nbsp;<img src="images/arrow1.png" alt=""/></span></a></div>
	            <div class="col_cv_main">
					<#include "/resume/detail_base.ftl"/>
					<#include "/resume/detail_sub_award.ftl"/>
	            </div>
	        </div>
	    </div>
	</div>
	<div class="clearfix"></div>
</div>
<script type="text/javascript">
	$(document).ready(function(){
		<#if id??>
		$.post("<@spring.url "/resume/detail/all"/>",{"id":"${id}"},function(text){
			if(text.success){
				var resume=text.data;
				//基本信息
				$("#baseForm").html($.template(T.base.text,resume));
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
		</#if>

		//保存基本信息
		$("#baseForm").ajaxForm(function(text) {
			if(text.success){
				alert("保存成功");
				var data=$("#baseForm").getFormData();
				$("#baseForm").html($.template(T.base.text,data));
			}else{
				alert("表单信息有误");
				$("#baseForm").find(".col_cv_alt").text("");
				if(text.error){
					for(var key in text.error){
						$("#baseForm").find(".col_cv_alt[data-error='"+key+"']").text(text.error[key]);
					}
				}
			}
		});
		
	});
	
	//基本信息切换为编辑
	function toEditBase(){
		var data=$("#baseForm").getFormTextData();
		$("#baseForm").html(T.base.input);
		$("#baseForm").autofill(data);
		//初始化时间插件
		$("#baseForm").find(".form_datetime").datetimepicker();
	}
	
	//添加
	function addSub(dataType,templateType,data){
		var $div=$("#"+dataType+"Div");
		var template=T[dataType][templateType];
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
			var template=T[dataType]["input"];
			var data=$form.getFormTextData();
			$form.html(template);
			$form.autofill(data);
			//初始化时间插件
			$form.find(".form_datetime").datetimepicker();
			$form.attr("data-type","input");
		}else if(oldType=="input"){
			var template=T[dataType]["text"];
			//不是form无法取到数据
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
			var id=$form.find("span[data-name='id']").attr("data-value");
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