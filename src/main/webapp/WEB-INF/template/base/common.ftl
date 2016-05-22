<#-- 资源链接 -->
<#macro resource relativeUrl>
	<@spring.url "/resources/"+relativeUrl />
</#macro>
<#-- select标签 -->
<#macro select label options name="" value="">
<#if label??><label for="${name}">${label}:</label></#if>
<select name="${name}" >
	<#if options??>
		<#list options?keys as key>
	<option value="${key}">${options[key]}</option>	
		</#list>
	<#else>
	<option value=""></option>
		<#if dictMap[name]?exists >
			<#list dictMap[name]?keys as key>
	<option value="${key}" <#if key==value>selected="selected"</#if>>${dictMap[name][key]}</option>
			</#list>
		</#if>
	</#if>
</select>
</#macro>

<#-- input标签 -->
<#macro input label attr name="" value="" type="text">
<#if label??><label for="${name}">${label}:</label></#if>
<input type="${type}" name="${name}" value="${value}" <#if attr??>${attr}</#if>/>
</#macro>

<#-- 文本 -->
<#macro text label attr value name="">
<#if label??><label for="${name}">${label}:</label></#if>
<span data-name="${name}" <#if attr??>${attr}</#if>><#if value??>${value}<#else>%{${name}}</#if></span>
</#macro>