<!-- 保存 -->
<insert id="save" parameterType="${bean}">
	insert into ${table}(
	<#list columns?keys as key>
		<if test="${columns[key]}!=null">
		<#if !(key?is_first)>,</#if>${key}
		</if>
	</#list>
	)values(
	<#list columns?keys as key>
		<if test="${columns[key]}!=null">
		<#if !(key?is_first)>,</#if>${r'#'}{${columns[key]}}
		</if>
	</#list>
	)
</insert>