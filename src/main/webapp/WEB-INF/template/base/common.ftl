<#-- select标签 -->
<#macro select name="" value="">
<select name="${name}" >
	<option value=""></option>
	<#if dictMap[name]?exists >
	<#list dictMap[name]?keys as key>
	<option value="${key}" <#if key==value>selected="selected"</#if>>${dictMap[name][key]}</option>
	</#list>
	</#if>
</select>
</#macro>