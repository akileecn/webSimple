<!-- 更新 -->
<update id="update" parameterType="${bean}">
	update ${table}
	<set>
	<#list columns?keys as key>
		<if test="${columns[key]}!=null">
		<#if !(key?is_first)>,</#if>${key}=${r'#'}{${columns[key]}}
		</if>
	</#list>
	</set>
	<include refid="whereSql"/>
</update>