/*2016-03-31*/
/**
 * 用户
 */
create table user(
	id int primary key auto_increment
	,username varchar(32) not null unique
	,password varchar(32) not null
);
/**
 * 角色
 */
create table role(
	id int primary key auto_increment
	,name varchar(32) not null unique
	,remark varchar(50)
);
/**
 * 用户角色关系
 */
create table user_role(
	user_id int not null
	,role_id int not null
	,primary key(user_id,role_id)
);
/**
 * 权限
 */
create table permission(
	id int primary key auto_increment
	,name varchar(32) not null unique
	,remark varchar(50)
);
/**
 * 角色权限关系
 */
create table role_permission(
	role_id int not null
	,permission_id int not null
	,primary key(role_id,permission_id)
);
-- 字典定义表
create table dict_type(
	id int primary key auto_increment
	,code varchar(32) not null
	,name varchar(32) not null
	,remark varchar(100)
);
-- 字典数据表
create table dict_data(
	id int primary key auto_increment
	,type_code varchar(32) not null
	,code varchar(32) not null -- 代码
	,name varchar(100) not null -- 中文
	,remark varchar(100) -- 备注
	,disabled tinyint(1) default 0 -- 是否失效
	,create_time timestamp
	,modify_time timestamp
);
-- 岗位
create table job(
	id int primary key auto_increment
	,name varchar(32)
	,resume_type varchar(32) -- 招聘类型
	,work_year varchar(32) -- 工作年限
	,work_city varchar(32) -- 工作城市
	,requirement varchar(500) -- 要求
	,description varchar(500) -- 描述
	,disabled tinyint(1) default 0 -- 是否失效
	,create_time timestamp
	,modify_time timestamp
);