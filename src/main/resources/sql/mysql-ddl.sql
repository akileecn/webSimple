/**
 * 用户
 */
create table zp_user(
	id int primary key AUTO_INCREMENT
	,username varchar(32)
	,password varchar(32) not null
	,id_number varchar(32) -- 身份证号码
	,mobile varchar(32) -- 手机号码
	,email varchar(50) -- 邮箱
	,question varchar(100) -- 问题
	,answer varchar(100) -- 答案
	,create_time datetime -- 创建时间
	,modify_time datetime -- 修改时间
	,name varchar(32) -- 姓名
);
/**
 * 角色
 */
create table zp_role(
	id int primary key AUTO_INCREMENT
	,name varchar(32) not null unique
	,remark varchar(50)
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
	id int primary key AUTO_INCREMENT
	,name varchar(32) not null unique
	,remark varchar(50)
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
	id int primary key AUTO_INCREMENT
	,code varchar(32) not null
	,name varchar(32) not null
	,remark varchar(100)
);
-- 字典数据表
create table zp_dict_data(
	id int primary key AUTO_INCREMENT
	,type_code varchar(32) not null
	,code varchar(32) not null -- 代码
	,name varchar(100) not null -- 中文
	,remark varchar(100) -- 备注
	,disabled bit default 0 -- 是否失效
	,create_time datetime
	,modify_time datetime
	,orderby int default 0 -- 排序
);
-- 岗位
create table zp_job(
	id int primary key AUTO_INCREMENT
	,name varchar(32)
	,recruit_type varchar(32) -- 招聘类型
	,work_year varchar(32) -- 工作年限
	,work_city varchar(32) -- 工作城市
	,education varchar(32) -- 学历
	,publish_date datetime -- 发布时间
	,end_date datetime -- 截止时间
	,requirement varchar(500) -- 要求
	,description varchar(500) -- 描述
	,disabled bit default 0 -- 是否失效
	,create_time datetime
	,modify_time datetime
	,department varchar(100) -- 部门
	,orderby int default 0 -- 排序 从大到小
	,people_number varchar(32) -- 招聘人数
);

-- 志愿
create table zp_application(
	job_id int not null-- 岗位id
	,resume_id int not null -- 简历id
	,status varchar(32) -- 申请状态
	,create_time datetime -- 投递时间
	,modity_time datetime -- 修改时间
	,user_id int -- 用户id
);
alter table zp_application add primary key(job_id,resume_id);

-- 通知
create table zp_notice(
	id int primary key AUTO_INCREMENT
	,user_id int not null -- 用户id
	,create_time datetime -- 创建时间
	,title varchar(100) -- 标题
	,content varchar(1000) -- 内容
	,is_new bit default 1 -- 是否为新通知
);

-- 静态页面
create table zp_static_page(
	 id int primary key AUTO_INCREMENT
	,code varchar(32) -- 代码
	,attr varchar(32) -- 其他属性
	,template varchar(100) -- 模版路径
	,title varchar(100) -- 标题
	,content text -- 内容
);