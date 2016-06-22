alter table zp_resume_work add industry nvarchar(32);-- 行业
alter table zp_resume add begin_work_date datetime;-- 参加工作时间
alter table zp_resume add begin_school_date datetime;-- 开始时间
alter table zp_resume add school nvarchar(100);-- 毕业院校
alter table zp_resume add school_type nvarchar(32);-- 院校类别
alter table zp_resume add major nvarchar(32);-- 专业
-- 实践活动
create table zp_resume_practice(
	id int primary key identity(1,1)
	,resume_id int not null
	,name nvarchar(100) -- 活动、公司名称
	,job nvarchar(32) -- 职位
	,begin_date datetime -- 开始时间
	,end_date datetime -- 结束时间
	,duty nvarchar(500) -- 职责
);
-- 培训经历
create table zp_resume_train(
	id int primary key identity(1,1)
	,resume_id int not null
	,begin_date datetime -- 开始时间
	,end_date datetime -- 结束时间
	,company nvarchar(100) -- 培训机构
	,place nvarchar(100) -- 培训地点
	,course nvarchar(32) --  培训课程
	,description nvarchar(500) -- 详细描述
);
alter table zp_resume_foreign_language add proficiency nvarchar(32);-- 熟练程度
alter table zp_resume_student_cadre add description nvarchar(500); -- 职责描述
insert into zp_dict_type(code,name)values('computerCertificate',N'计算机证书名称');
insert into zp_dict_data(type_code,code,name)values('computerCertificate','1',N'全国计算机一级');
insert into zp_dict_data(type_code,code,name)values('computerCertificate','2',N'全国计算机二级');
insert into zp_dict_data(type_code,code,name)values('computerCertificate','3',N'全国计算机三级');
insert into zp_dict_data(type_code,code,name)values('computerCertificate','4',N'软件工程师');
insert into zp_dict_data(type_code,code,name)values('computerCertificate','5',N'其他');
insert into zp_dict_type(code,name)values('computerProficiency',N'计算机掌握程度');
insert into zp_dict_data(type_code,code,name)values('computerProficiency','1',N'开发程序');
insert into zp_dict_data(type_code,code,name)values('computerProficiency','2',N'开发应用');
insert into zp_dict_data(type_code,code,name)values('computerProficiency','3',N'OA办公');
insert into zp_dict_data(type_code,code,name)values('computerProficiency','4',N'基本操作');