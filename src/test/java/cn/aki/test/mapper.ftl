<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="cn.aki.dao.ResumeMapper">
	<cache/>
	<sql id="whereSql">
		<where>
<#list columns?keys as key>
			<if test="${columns[key]}!=null">
			<#if !(key?is_first)>and </#if>${key}=${r'#'}{${columns[key]}}
			</if>
		</#list>
		</where>
	</sql>
	
	<sql id="selectSql">
		select
		<#list columns?keys as key>
			<#if !(key?is_first)>,</#if>${key}<#if key!=columns[key]> as ${columns[key]}</#if>
		</#list>	
		from ${table}
	</sql>
	
	<!-- 获得 -->
	<select id="get" parameterType="int" resultType="${bean}">
		<include refid="selectSql"/>
		where id=${r'#'}{id}
	</select>
	
	<!-- 查询 -->
	<select id="query" parameterType="${bean}" resultType="${bean}">
		<include refid="selectSql"/>
		<include refid="whereSql"/>
	</select>
	
	<!-- 保存 -->
	<insert id="save" parameterType="${bean}">
		insert into ${table}(
		<trim prefix="" prefixOverrides=",">
		<#list columns?keys as key>
			<if test="${columns[key]}!=null">
			<#if !(key?is_first)>,</#if>${key}
			</if>
		</#list>
		</trim>
		)values(
		<trim prefix="" prefixOverrides=",">
		<#list columns?keys as key>
			<if test="${columns[key]}!=null">
			<#if !(key?is_first)>,</#if>${r'#'}{${columns[key]}}
			</if>
		</#list>
		</trim>
		)
	</insert>
	
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
		where id=${r'#'}{id}
	</update>
	
	<!-- 删除 -->
	<delete id="delete" parameterType="int">
		delete from ${table} where id=${r'#'}{id}
	</delete>
</mapper>