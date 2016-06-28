<#-- 样式宏 -->
<#include "/resume/detail_common.ftl"/>
<@bootstrap.head>
<title>简历详情</title>
<#-- 文件上传插件 -->
<script src="<@c.resource "jquery/jquery.ui.widget.js"/>"></script>
<script src="<@c.resource "jquery/jquery.iframe-transport.js"/>"></script>
<script src="<@c.resource "jquery/jquery.fileupload.js"/>"></script>
</@bootstrap.head>
<@bootstrap.body>
<script type="text/javascript">
	//全局模版保存对象
	var T={};
	//带其他项的select
	$("body").on("change",".selectWithOther select",function(){
		var value=$(this).find("option:selected").val();
		var $input=$(this).siblings("input");
		if(value=="other"){
			$input.val("");
			$input.show();
		}else{
			$input.val(value);
			$input.hide();
		}
	});
	
	//其他联动
	$("body").on("change",".selectWithOther input",function(){
		var value=$(this).val();
		var $select=$(this).siblings("select");
		if(value){
			var $option=$select.find("option[value='"+value+"']");
			if($option.length>0){
				$option.attr("selected",true);
			}
		}
	});
	
	//省市区联动
	$("body").on("change",".selectCity select",function(){
		var $selectCity=$(this).parent(".selectCity");
		var prov=$selectCity.find(".prov").val();
		var city=$selectCity.find(".city").val();
		var dist=$selectCity.find(".dist").val();
		var value="";
		if(prov){
			value+=prov;
			$selectCity.find(".more").show();
		}
		if(city){
			value+=","+city;
		}
		if(dist){
			value+=","+dist;
		}else if($selectCity.is(":has(.more)")){
			value+=",";
		}
		$selectCity.find("input[name]").val(value);
	});
	
	//省市区更多联动
	$("body").on("change",".selectCity .more",function(){
		//重新赋值
		$(this).siblings(".dist").change();
		var $input=$(this).siblings("input[name]");
		var value=$input.val();
		if(value){
			$input.val(value+","+$(this).val());
		}
	});
</script>
<div class="container">
	<#include "/user/left.ftl"/>
	<@c.right title="我的简历">
	<div class="col_cv_main">
		<#include "/resume/detail_base.ftl"/>
		<#include "/resume/detail_sub.ftl"/>
		<div class="col_cv_tab" style="background:none;">
		 	<form id="submitForm" action="<@spring.url "/resume/submit"/>" method="post" style="text-align: center;">
                <input type="hidden" name="id" value="${id}"/>
                <input type="submit" value="提交" class="submit"/>
		    </form>
	    </div>
    </div>
	</@c.right>
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
				var subs=["education","foreignLanguage","computer",<#if recruitType=="society">"work",<#else>"practice","studentCadre",</#if>"award","train","family"];
				for(var i=0;i<subs.length;i++){
					var dataType=subs[i];
					var datas=resume[dataType+"List"];
					if(datas){
						for(var j=0;j<datas.length;j++){
							addSub(dataType,"text",datas[j]);
						}
					}
				}
			}
		});
		</#if>

		//提交
		$("#submitForm").ajaxForm(function(text) {
			if(text.success){
				<#if applyJobId??>
				var T_complet='<@compress single_line=true>
					<div class="pop_job pop_w2">
					    <span class="close" onclick="art.dialog.list[\'abc\'].close();"></span>
					    <h2> 提示 </h2>
					    <div class="pop_job_col">
					        <table width="100%" border="0" cellspacing="0" cellpadding="0">
					            <tr><td><div class="pop_job_p"><div class="pop_job_yix">
			                        <div style="margin-right:50px;">
			                            <div class="tt"><img src="<@c.resource "images/good.png"/>" width="52" height="52" style="margin:15px 0 0 0;"></div>
			                            <div class="cop">感谢您应聘我行职位<div class=" clearfix"></div>
			                            <p>我们会尽快和您联系， 请您耐心等待！ </p>
			                            </div>
			                        </div>
			                        <div class="btn">
			                            <input name="" type="submit" value="关闭" onclick="window.location.href=\'<@spring.url "/application/list?recruitType="+userCenterType/>\'">
			                        </div>
								</div></div></td></tr>
					        </table>
					    </div>
					</div>
				</@compress>';
				//正式申请
				$.post("<@spring.url "/application/apply"/>",{"jobId":"${applyJobId}"},function(text){
					if(text.success){
						if(typeof art.dialog.list['abc'] != 'undefined')art.dialog.list['abc'].close();
					    art.dialog({
					        id: 'abc',
					        lock: true,
					        content: T_complet
					    });
					}else{
						$.alert(text.message);
					}
				});	
				<#else>
				$.alert("提交成功");
				window.location.href="<@spring.url "/index"/>";
				</#if>
			}else if(text.message){
				$.alert(text.message);
			}
		});

		//保存基本信息
		$("#baseForm").ajaxForm(function(text) {
			if(text.success){
				$.alert("保存成功");
				var data=$("#baseForm").getFormData();
				$("#baseForm").html($.template(T.base.text,data));
				$(".user_pic img").attr("src","<@spring.url "/resume/phote/show?id="+id />&r="+Math.random());
			}else{
				$.alert("表单信息有误");
				$("#baseForm").showError(text.error);
			}
		});
		
	});
	
	//基本信息切换为编辑
	function toEditBase(){
		var $form=$("#baseForm");
		var data=$form.getFormTextData();
		$form.html(T.base.input);
		$form.autofill(data);
		//初始化时间插件
		$form.find(".form_datetime").datetimepicker();
		//初始化省市区联动
		$form.find(".selectCity").each(function(){
			var value=$(this).find("input[name]").val();
			var parts=value.split(",");
			var settings={url:"<@c.resource "cityselect/js/city.min.js"/>",nodata:"none"};
			for(var i=0;i<parts.length;i++){
				if(i==0){
					settings.prov=parts[i];
				}else if(i==1){
					settings.city=parts[i];
				}else if(i==2){
					settings.dist=parts[i];
				}else if(i==3){
					var $more=$(this).find(".more");
					$more.val(parts[i]);
					$more.show();
				}
			}
			$(this).citySelect(settings);
		});
		//头像上传
		$('#fileupload').fileupload({
			dataType : 'json',
			done : function(e, data) {
				var message=data.result.message;
				if(message){
					$.alert(message);
				}
				if(data.result.success){
					$(".user_pic img").attr("src","<@spring.url "/resume/phote/show?id="+id />&r="+Math.random());
				}
			}
		});
	}
	
	//添加
	function addSub(dataType,templateType,data){
		var $div=$("#"+dataType+"Div");
		if(!T[dataType]){
			$.alert(dataType);
		}
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
			//初始化奇怪的select
			initSelect();
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
		
		//初始化奇怪的select
		function initSelect(){
			$form.find(".selectWithOther input").each(function(){
				var value=$(this).val();
				var $select=$(this).siblings("select");
				if(value){
					var $option=$select.find("option[value='"+value+"']");
					if($option.length>0){
						$select.val(value);
					}else{
						$select.val("other");
						$(this).show();
					}
				}
			});
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
		$(self).attr("disabled","disabled");
		$form=$(self).parents("form");
		$form.ajaxSubmit({
			url:"<@spring.url "/resume/save/"/>"+dataType
			,data:{"resumeId":"${id}","recruitType":"${recruitType}"}
			,type:"post"
			,success:function(text){
				$(self).removeAttr("disabled");
				if(text.success){
					switchSub(dataType,self,{id:text.data});
				}else{
					$.alert("表单信息有误");
					$form.showError(text.error);
				}
			}
		});
	}
</script> 
</@bootstrap.body>