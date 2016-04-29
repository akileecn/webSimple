insert into ${table}(
	<#list columns?keys as key>
	<if test="${columns[key]}!=null">
	<#if key?is_first>
	${key}
	<#else>
	,${key}
	</#if>
	</if>
	</#list>
)values(
	<#list columns?keys as key>
	<if test="${columns[key]}!=null">
	<#if key?is_first>
	#{${columns[key]}}
	<#else>
	,#{${columns[key]}}
	</#if>
	</#list>
)