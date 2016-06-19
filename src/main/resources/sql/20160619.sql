-- 静态页面
create table zp_static_page(
	id int primary key identity(1,1)
	,code nvarchar(32) -- 代码
	,attr nvarchar(32) -- 其他属性
	,title nvarchar(100) -- 标题
	,content ntext -- 内容
);
-- code,attr,template请勿修改
insert into zp_static_page(code,attr,template,title,content)values('about','1','about',N'企业发展',N'企业发展内容示例');
insert into zp_static_page(code,attr,template,title,content)values('about','2','about',N'企业文化',N'企业文化内容示例');
insert into zp_static_page(code,attr,template,title,content)values('about','3','about',N'薪酬福利',N'薪酬福利内容示例');
insert into zp_static_page(code,attr,template,title,content)values('about','4','about',N'培训发展',N'培训发展内容示例');
insert into zp_static_page(code,attr,template,title,content)values('userAgreement',null,'userAgreement',N'用户协议',N'用户协议内容示例');
insert into zp_static_page(code,attr,template,title,content)values('recruitNotice',null,null,N'招聘公告示例',N'招聘公告内容示例');
-- 字典排序
alter table zp_dict_data add orderby int default 0;
update zp_dict_data set orderby=0;
insert into zp_dict_data(type_code,code,name)values('cadreLevel','4',N'其他');
alter table zp_resume_education add school_location nvarchar(32); -- 学校位于城市或农村
insert into zp_dict_data(type_code,code,name)values('schoolLocation','1',N'城市');
insert into zp_dict_data(type_code,code,name)values('schoolLocation','2',N'农村');
-- 简历状态
alter table zp_resume add is_submit bit not null default 0; -- 是否提交
alter table zp_resume add is_lock bit not null default 0; -- 是否锁定