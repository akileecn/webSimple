<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="cn.aki.dao.${type}Mapper">
	<cache/>
	<sql id="whereSql">
		where id=${r'#'}{id}
			and resume_id=${r'#'}{resumeId}
	</sql>
	
	<sql id="selectSql">
		select
		<#list columns?keys as key>
			<#if !(key?is_first)>,</#if>${key}<#if key!=columns[key]> as ${columns[key]}</#if>
		</#list>	
		from zp_${table}
	</sql>
	
	<!-- 获得 -->
	<select id="get" parameterType="${bean}" resultType="${bean}">
		<include refid="selectSql"/>
		<include refid="whereSql"/>
	</select>
	
	<!-- 查询 -->
	<#--
	<select id="getList" parameterType="${bean}" resultType="${bean}">
		<include refid="selectSql"/>
		<include refid="whereSql"/>
	</select>
	-->
	<select id="getList" parameterType="int" resultType="${bean}">
		<include refid="selectSql"/>
		where resume_id=${r'#'}{resumeId}
	</select>
	
	<!-- 保存 -->
	<insert id="save" parameterType="${bean}" useGeneratedKeys="true" keyProperty="id">
		insert into zp_${table}(
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
		update zp_${table}
		<set>
		<#list columns?keys as key>
			<#if key!="id"&&key!="create_time">
			${key}=${r'#'}{${columns[key]}},
			</#if>
		</#list>
		</set>
		<include refid="whereSql"/>
	</update>
	
	<!-- 删除 -->
	<delete id="delete" parameterType="${bean}">
		delete from zp_${table}
		<include refid="whereSql"/>
	</delete>
</mapper>