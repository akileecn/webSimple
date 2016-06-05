-- 简历主表
create table zp_resume(
	id int primary key identity(1,1)
	,user_id int not null -- 用户ID
	,name nvarchar(32)	
	,gender nvarchar(32)
	,birthday datetime
	,nation nvarchar(32) -- 民族
	,height int
	,weight int
	,id_type nvarchar(32) -- 证件类型
	,id_number nvarchar(32)
	,marriage nvarchar(32) -- 婚姻状况
	,politics_status nvarchar(32) -- 政治面貌
	,join_party_date datetime -- 入党时间
	,mobile nvarchar(32)
	,email nvarchar(50)
	,highest_education nvarchar(32) -- 最高学历
	,highest_degree nvarchar(32) -- 最高学位
	,graduate_date datetime -- 毕业时间
	,cee_province nvarchar(32) -- 高考省份
	,cee_score int -- 高考分数
	,is_first_line bit -- 是否一本分数线以上
	,arts_or_science nvarchar(32) -- 文理科
	,admission_order nvarchar(32) -- 录取批次
	,emergency_contact nvarchar(32) -- 紧急联系人
	,emergency_mobile nvarchar(32) -- 紧急联系人电话
	,children_count int -- 子女
	,is_relative_here bit -- 是否有亲友受雇与本公司
	,current_residence nvarchar(100) -- 现居住地址
	,family_residence nvarchar(100) -- 家庭住址
	,native_place nvarchar(100) -- 籍贯
	,student_origin nvarchar(100) -- 生源地
	,registered_residence nvarchar(100) -- 户口所在地
	,certificate nvarchar(500) -- 持证情况
	,hobby nvarchar(500) -- 爱好特长
	,personality nvarchar(500) -- 性格特点
	,create_time datetime -- 创建时间
	,modify_time datetime -- 修改时间
	,work_year nvarchar(32) -- 工作年前
	,work_city nvarchar(32) -- 期望工作城市
	,health nvarchar(32) -- 健康
);

-- 教育经历
create table zp_resume_education(
	id int primary key identity(1,1)
	,resume_id int not null
	,school_name nvarchar(32)
	,major nvarchar(32)
	,graduate_type nvarchar(32) -- 毕业方式
	,degree nvarchar(32) -- 学位
	,education nvarchar(32) -- 学历
	,learn_type nvarchar(32) -- 学习形式
	,begin_date datetime -- 开始时间
	,end_date datetime -- 结束时间
	,school_type nvarchar(32) -- 学校类别
	,has_been_cadre bit -- 是否担任过学生干部
	,grade_rank nvarchar(32) -- 年级排名
);

-- 外语信息
create table zp_resume_foreign_language(
	id int primary key identity(1,1)
	,resume_id int not null
	,level nvarchar(32)
	,score int
	,speaking nvarchar(32) -- 口语
	,others nvarchar(32) -- 其他语言
);

-- 计算机技能
create table zp_resume_computer(
	id int primary key identity(1,1)
	,resume_id int not null
	,certificate nvarchar(32)
	,obtain_date datetime
	,level nvarchar(32)
	,detail nvarchar(500)
);

-- 工作经历
create table zp_resume_work(
	id int primary key identity(1,1)
	,resume_id int not null
	,company nvarchar(100)
	,department nvarchar(32)
	,annual_salary nvarchar(32) -- 年薪
	,job nvarchar(32)
	,certifier nvarchar(32) -- 证明人
	,certifier_mobile nvarchar(32) -- 证明人电话
	,work_place nvarchar(100) -- 工作地点
	,job_type nvarchar(32) -- 职位类型
	-- ,industry nvarchar(32) -- 行业
	,begin_date datetime -- 开始时间
	,end_date datetime -- 结束时间
	,dimission_reason nvarchar(500) -- 辞职理由
	,duty nvarchar(500) -- 职责
	,performance nvarchar(500) -- 业绩
);

-- 学生干部
create table zp_resume_student_cadre(
	id int primary key identity(1,1)
	,resume_id int not null
	,begin_date datetime -- 开始时间
	,end_date datetime -- 结束时间
	,school nvarchar(32) -- 所在院校
	,name nvarchar(32) -- 干部名称
	,level nvarchar(32) -- 级别
	,certifier nvarchar(32) -- 证明人
	,certifier_mobile nvarchar(32) -- 证明人电话
);

-- 获奖经历
create table zp_resume_award(
	id int primary key identity(1,1)
	,resume_id int not null
	,name nvarchar(32) -- 奖励名称
	,time datetime -- 获得时间
	,level nvarchar(32) -- 级别
	,description nvarchar(500) -- 奖励描述
);

-- 家庭关系
create table zp_resume_family(
	id int primary key identity(1,1)
	,resume_id int not null
	,name nvarchar(32) -- 名称
	,relationship nvarchar(32) -- 关系
	,work_company nvarchar(100) -- 工作单位
	,work_job nvarchar(32) -- 职位
	,description nvarchar(500) -- 说明
);

/*简历增加头像*/
alter table zp_resume add photo nvarchar(100);