<div class="container">
	<form id="baseForm" action="<@spring.url "/resume/save/base"/>" method="post">
		<input type="hidden" name="id" value="${id}"/>
<#assign fields=[
	["text","name","姓名"],["select","gender","性别"],["date","birthday","出生日期"],["select","nation","民族"],["text","height","身高"]
	,["text","weight","体重"],["select","idType","证件类型"],["text","idNumber","证件号码"],["select","marriage","婚姻状况"],["select","politicsStatus","政治面貌"]
	,["date","joinPartyDate","入党时间"],["text","mobile","手机"],["text","email","邮箱"],["select","highestEducation","最高学历"],["select","highestDegree","最高学位"]
	,["date","graduateDate","毕业时间"],["select","ceeProvince","高考省份"],["text","ceeScore","高考分数"],["selectIf","isFirstLine","是否一本分数线以上"],["select","artsOrScience","文理科"]
	,["select","admissionOrder","录取批次"],["text","emergencyContact","紧急联系人"],["text","emergencyMobile","紧急联系人电话"],["text","childrenCount","子女个数"],["selectIf","isEelativeHere","是否有亲友受雇与本公司"]
	,["text","currentResidence","现居住地址"],["text","familyResidence","家庭住址"],["text","nativePlace","籍贯"],["text","studentOrigin","生源地"],["text","registeredResidence","户口所在地"]
	,["text","certificate","持证情况"],["text","hobby","爱好特长"],["text","personality","性格特点"]
]/>
<#list fields as item>
	<#if item[0]=="text">
		<@c.input type="text" name=item[1] label=item[2]/>
	<#elseif item[0]=="date">
		<@c.input type="text" name=item[1] label=item[2] attr="class='form_datetime'"/>
	<#elseif item[0]=="select">
		<@c.select name=item[1] label=item[2]/>
	<#elseif item[0]=="selectIf">
		<@c.select name=item[1] label=item[2] options={"true":"是","false":"否"}/>
	</#if>
	<#if item?is_even_item><br/></#if>
</#list>
		<button type="submit" class="btn">保存</button>
	</form>
</div>
<script type="text/javascript">
	$(document).ready(function(){
		//初始化时间插件
		$(".form_datetime").datetimepicker({
			format:"yyyy-mm-dd"
			,minView:"month"
			,language:"zh-CN"
		});
	
		$.post("<@spring.url "/resume/detail/base"/>",{"id":${id}},function(text){
			if(text.success){
				$("#baseForm").autofill(text.data);
			}
		});
	});
</script>            