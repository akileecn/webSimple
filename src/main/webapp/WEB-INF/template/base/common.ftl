<#-- 资源链接 -->
<#macro resource relativeUrl>
	<@spring.url "/resources/"+relativeUrl />
</#macro>
<#-- select标签 -->
<#macro select label name lableAttr selectAttr dict=name>
<#if label??><label <#if lableAttr??>${lableAttr}</#if>>${label}:</label></#if>
    <select name="${name}" <#if selectAttr??>${selectAttr}</#if>>
		<option value="">请选择</option>
	<#if dictMap[dict]?exists >
		<#list dictMap[dict]?keys as key>
		<option value="${key}" <#if key==value>selected="selected"</#if>>${dictMap[dict][key]}</option>
		</#list>
	</#if>
	</select>
</#macro>