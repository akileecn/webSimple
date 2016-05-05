<sql id="whereSql">
	<where>
<#list columns?keys as key>
		<if test="${columns[key]}!=null">
		<#if !(key?is_first)>and </#if>${key}=${r'#'}{${columns[key]}}
		</if>
	</#list>
	</where>
</sql>
<!-- 获取 -->
<select id="get" parameterType="${bean}" resultType="${bean}">
	select
	<#list columns?keys as key>
		<#if !(key?is_first)>,</#if>${key}<#if key!=columns[key]> as ${columns[key]}</#if>
	</#list>	
	from ${table}
	<include refid="whereSql"/>
</select>