/**
 * 用户
 */
create table zp_user(
	id int primary key identity(1,1)
	,username nvarchar(32)
	,password nvarchar(32) not null
	,id_number nvarchar(32) -- 身份证号码
	,mobile nvarchar(32) -- 手机号码
	,email nvarchar(50) -- 邮箱
	,question nvarchar(100) -- 问题
	,answer nvarchar(100) -- 答案
	,create_time datetime -- 创建时间
	,modify_time datetime -- 修改时间
);
/**
 * 角色
 */
create table zp_role(
	id int primary key identity(1,1)
	,name nvarchar(32) not null unique
	,remark nvarchar(50)
);
/**
 * 用户角色关系
 */
create table zp_user_role(
	user_id int not null
	,role_id int not null
	,primary key(user_id,role_id)
);
/**
 * 权限
 */
create table zp_permission(
	id int primary key identity(1,1)
	,name nvarchar(32) not null unique
	,remark nvarchar(50)
);
/**
 * 角色权限关系
 */
create table zp_role_permission(
	role_id int not null
	,permission_id int not null
	,primary key(role_id,permission_id)
);
-- 字典定义表
create table zp_dict_type(
	id int primary key identity(1,1)
	,code nvarchar(32) not null
	,name nvarchar(32) not null
	,remark nvarchar(100)
);
-- 字典数据表
create table zp_dict_data(
	id int primary key identity(1,1)
	,type_code nvarchar(32) not null
	,code nvarchar(32) not null -- 代码
	,name nvarchar(100) not null -- 中文
	,remark nvarchar(100) -- 备注
	,disabled bit default 0 -- 是否失效
	,create_time datetime
	,modify_time datetime
);
-- 岗位
create table zp_job(
	id int primary key identity(1,1)
	,name nvarchar(32)
	,recruit_type nvarchar(32) -- 招聘类型
	,work_year nvarchar(32) -- 工作年限
	,work_city nvarchar(32) -- 工作城市
	,education nvarchar(32) -- 学历
	,publish_date datetime -- 发布时间
	,end_date datetime -- 截止时间
	,people_number int -- 人数
	,requirement nvarchar(500) -- 要求
	,description nvarchar(500) -- 描述
	,disabled bit default 0 -- 是否失效
	,create_time datetime
	,modify_time datetime
);

-- 志愿
create table zp_application(
	job_id int not null-- 岗位id
	,resume_id int not null -- 简历id
	,status nvarchar(32) -- 申请状态
	,create_time datetime -- 投递时间
	,modity_time datetime -- 修改时间
);
alter table zp_application add primary key(job_id,resume_id);

-- 通知
create table zp_notice(
	id int primary key identity(1,1)
	,user_id int not null -- 用户id
	,create_time datetime -- 创建时间
	,title nvarchar(100) -- 标题
	,content nvarchar(1000) -- 内容
);

/*用户增加姓名*/
alter table zp_user add name nvarchar(32);