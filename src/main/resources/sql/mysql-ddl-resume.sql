-- 简历主表
create table zp_resume(
	id int primary key AUTO_INCREMENT
	,user_id int not null -- 用户ID
	,name varchar(32)	
	,gender varchar(32)
	,birthday datetime
	,nation varchar(32) -- 民族
	,height int
	,weight int
	,id_type varchar(32) -- 证件类型
	,id_number varchar(32)
	,marriage varchar(32) -- 婚姻状况
	,politics_status varchar(32) -- 政治面貌
	,join_party_date datetime -- 入党时间
	,mobile varchar(32)
	,email varchar(50)
	,highest_education varchar(32) -- 最高学历
	,highest_degree varchar(32) -- 最高学位
	,graduate_date datetime -- 毕业时间
	,cee_province varchar(32) -- 高考省份
	,cee_score int -- 高考分数
	,is_first_line bit -- 是否一本分数线以上
	,arts_or_science varchar(32) -- 文理科
	,admission_order varchar(32) -- 录取批次
	,emergency_contact varchar(32) -- 紧急联系人
	,emergency_mobile varchar(32) -- 紧急联系人电话
	,children_count int -- 子女
	,is_relative_here bit -- 是否有亲友受雇与本公司
	,current_residence varchar(100) -- 现居住地址
	,family_residence varchar(100) -- 家庭住址
	,native_place varchar(100) -- 籍贯
	,student_origin varchar(100) -- 生源地
	,registered_residence varchar(100) -- 户口所在地
	,certificate varchar(500) -- 持证情况
	,hobby varchar(500) -- 爱好特长
	,personality varchar(500) -- 性格特点
	,create_time datetime -- 创建时间
	,modify_time datetime -- 修改时间
	,work_year varchar(32) -- 工作年前
	,work_city varchar(32) -- 期望工作城市
	,health varchar(32) -- 健康
	,photo BLOB -- 头像
	,recruit_type varchar(32) -- 招聘类型
	,begin_work_date datetime -- 参加工作时间
	,begin_school_date datetime -- 开始时间
	,school varchar(100) -- 毕业院校
	,school_type varchar(32) -- 院校类别
	,major varchar(32) -- 专业
	,is_submit bit not null default 0 -- 是否提交
	,is_lock bit not null default 0 -- 是否锁定
	,cee_year varchar(32) -- 高考年份
);

-- 教育经历
create table zp_resume_education(
	id int primary key AUTO_INCREMENT
	,resume_id int not null
	,school_name varchar(32)
	,major varchar(32)
	,graduate_type varchar(32) -- 毕业方式
	,degree varchar(32) -- 学位
	,education varchar(32) -- 学历
	,learn_type varchar(32) -- 学习形式
	,begin_date datetime -- 开始时间
	,end_date datetime -- 结束时间
	,school_type varchar(32) -- 学校类别
	,has_been_cadre bit -- 是否担任过学生干部
	,grade_rank varchar(32) -- 年级排名
	,school_location varchar(32) -- 学校位于城市或农村
);

-- 外语信息
create table zp_resume_foreign_language(
	id int primary key AUTO_INCREMENT
	,resume_id int not null
	,level varchar(32)
	,score int
	,speaking varchar(32) -- 口语
	,others varchar(32) -- 其他语言
	,proficiency varchar(32) -- 熟练程度
);

-- 计算机技能
create table zp_resume_computer(
	id int primary key AUTO_INCREMENT
	,resume_id int not null
	,certificate varchar(32)
	,obtain_date datetime
	,level varchar(32)
	,detail varchar(500)
);

-- 工作经历
create table zp_resume_work(
	id int primary key AUTO_INCREMENT
	,resume_id int not null
	,company varchar(100)
	,department varchar(32)
	,annual_salary varchar(32) -- 年薪
	,job varchar(32)
	,certifier varchar(32) -- 证明人
	,certifier_mobile varchar(32) -- 证明人电话
	,work_place varchar(100) -- 工作地点
	,job_type varchar(32) -- 职位类型
	-- ,industry varchar(32) -- 行业
	,begin_date datetime -- 开始时间
	,end_date datetime -- 结束时间
	,dimission_reason varchar(500) -- 辞职理由
	,duty varchar(500) -- 职责
	,performance varchar(500) -- 业绩
	,industry varchar(32) -- 行业
);

-- 学生干部
create table zp_resume_student_cadre(
	id int primary key AUTO_INCREMENT
	,resume_id int not null
	,begin_date datetime -- 开始时间
	,end_date datetime -- 结束时间
	,school varchar(32) -- 所在院校
	,name varchar(32) -- 干部名称
	,level varchar(32) -- 级别
	,certifier varchar(32) -- 证明人
	,certifier_mobile varchar(32) -- 证明人电话
	,description varchar(500) -- 职责描述
);

-- 获奖经历
create table zp_resume_award(
	id int primary key AUTO_INCREMENT
	,resume_id int not null
	,name varchar(32) -- 奖励名称
	,time datetime -- 获得时间
	,level varchar(32) -- 级别
	,description varchar(500) -- 奖励描述
);

-- 家庭关系
create table zp_resume_family(
	id int primary key AUTO_INCREMENT
	,resume_id int not null
	,name varchar(32) -- 名称
	,relationship varchar(32) -- 关系
	,work_company varchar(100) -- 工作单位
	,work_job varchar(32) -- 职位
	,description varchar(500) -- 说明
);

-- 实践活动
create table zp_resume_practice(
	 id int primary key AUTO_INCREMENT
	,resume_id int not null
	,name varchar(100) -- 活动、公司名称
	,job varchar(32) -- 职位
	,begin_date datetime -- 开始时间
	,end_date datetime -- 结束时间
	,duty varchar(500) -- 职责
);

-- 培训经历
create table zp_resume_train(
	 id int primary key AUTO_INCREMENT
	,resume_id int not null
	,begin_date datetime -- 开始时间
	,end_date datetime -- 结束时间
	,company varchar(100) -- 培训机构
	,place varchar(100) -- 培训地点
	,course varchar(32) --  培训课程
	,description varchar(500) -- 详细描述
);