<#-- subpage1+subpage2于deprecated文件夹下的模版效果相同 -->
<#-- 教育经历 -->
<@subpage1 name="education" title="教育经历(从最高学历填至"+(recruitType=="society")?string("高中","小学")+")" required=true>
	<@span label="学校名称" name="schoolName"/>
	<@span label="所学专业" name="major"/>
	</tr><tr>
	<@span label="毕业方式" name="graduateType" translate=true/>
	<@span label="学位" name="degree" translate=true/>
	</tr><tr>
	<@span label="学历" name="education" translate=true/>
	<@span label="学习形式" name="learnType" translate=true/>
	</tr><tr>
	<@span label="开始时间" name="beginDate"/>
	<@span label="结束时间" name="endDate"/>
	</tr><tr>
	<@span label="学校类别" name="schoolType" translate=true/>
	<@span label="是否担任过学生干部" name="hasBeenCadre" translate=true attr="style=\"width:200px;\""/>
	</tr><tr>
	<@span label="年级排名" name="gradeRank" translate=true/>
	<@span label="学校位于" name="schoolLocation" translate=true/>
</@subpage1>
<@subpage2 name="education">
	<@input label="学校名称" name="schoolName" required=true/>
	<@input label="所学专业" name="major" required=true/>
	</tr><tr>
	<@select label="毕业方式" name="graduateType" required=true/>
	<@select label="学位" name="degree" required=true/>
	</tr><tr>
	<@select label="学历" name="education" required=true/>
	<@select label="学习形式" name="learnType" required=true/>
	</tr><tr>
	<@date label="开始时间" name="beginDate" required=true/>
	<@date label="结束时间" name="endDate" required=true/>
	</tr><tr>
	<@select label="学校类别" name="schoolType" required=true/>
	<@radio label="是否担任过学生干部" name="hasBeenCadre" required=true/>
	</tr><tr>
	<@select label="年级排名" name="gradeRank" required=true/>
	<@select label="学校位于" name="schoolLocation" required=true/>
</@subpage2>
<#if recruitType=="society">
	<#-- 工作经历 -->
	<@subpage1 name="work" title="工作经历(仅填写全职工作经历)" required=true>
		<@span label="单位名称" name="company"/>
		<@span label="年薪" name="annualSalary"/>
		</tr><tr>
		<@span label="部门名称" name="department"/>
		<@span label="职位" name="job"/>
		</tr><tr>	
		<@span label="证明人" name="certifier"/>
		<@span label="证明人电话" name="certifierMobile"/>
		</tr>
		<@span label="工作地点" name="workPlace"/>
		<@span label="职位类型" name="jobType" translate=true/>
		</tr><tr>
		<@span label="行业" name="industry"/>
		<@span label="开始时间" name="beginDate"/>
		</tr><tr>
		<@span label="结束时间" name="endDate"/>
		</tr><tr>
		<@span label="离职原因" name="dimissionReason" wide=true/>
		</tr><tr>
		<@span label="职责描述" name="duty" wide=true/>
		</tr><tr>
		<@span label="工作业绩" name="performance" wide=true/>
	</@subpage1>
	<@subpage2 name="work">
		<@input label="单位名称" name="company" required=true/>
		<@input label="年薪" name="annualSalary" required=true/>
		</tr><tr>
		<@input label="部门名称" name="department" required=true/>
		<@input label="职位" name="job" required=true/>
		</tr><tr>	
		<@input label="证明人" name="certifier" required=true/>
		<@input label="证明人电话" name="certifierMobile" required=true/>
		</tr><tr>
		<@input label="工作地点" name="workPlace" required=true/>
		<@select label="职位类型" name="jobType" required=true/>
		</tr><tr>
		<@input label="行业" name="industry" required=true/>
		<@date label="开始时间" name="beginDate" required=true/>
		</tr><tr>
		<@date label="结束时间" name="endDate" required=true/>
		</tr><tr>
		<@textarea label="离职原因" name="dimissionReason" required=true/>
		</tr><tr>
		<@textarea label="职责描述" name="duty" required=true/>
		</tr><tr>
		<@textarea label="工作业绩" name="performance" required=true/>
	</@subpage2>
</#if>
<#-- 外语水平 -->
<@subpage1 name="foreignLanguage" title="外语水平">
	<@span label="英语等级" name="level" translate=true/>
	<@span label="英语分数" name="score"/>
	</tr><tr>
	<@span label="英语口语" name="speaking" translate=true/>
	<@span label="熟练程度" name="proficiency" translate=true/>
	</tr><tr>
	<@span label="其他语言" name="others" translate=true/>
</@subpage1>
<@subpage2 name="foreignLanguage">
	<@select label="英语等级" name="level" dict="languageLevel" required=true/>
	<@input label="英语分数" name="score" required=true/>
	</tr><tr>
	<@select label="英语口语" name="speaking" dict="languageProficiency"/>
	<@select label="熟练程度" name="proficiency" dict="languageProficiency"/>
	</tr><tr>
	<@select label="其他语言" name="others" dict="language" other=true/>
</@subpage2>
<#-- 计算机技能 -->
<@subpage1 name="computer" title="计算机技能">
	<@span label="证书名称" name="certificate" translate=true/>
	<@span label="取得时间" name="obtainDate"/>
	</tr><tr>
	<@span label="掌握程度" name="level" translate=true/>
	</tr><tr>
	<@span label="详细说明" name="detail" wide=true/>
</@subpage1>
<@subpage2 name="computer">
	<@select label="证书名称" name="certificate" dict="computerCertificate" required=true/>
	<@date label="取得时间" name="obtainDate" required=true/>
	</tr><tr>
	<@select label="掌握程度" name="level" dict="computerProficiency" required=true/>
	</tr><tr>
	<@textarea label="详细说明" name="detail"/>
</@subpage2>
<#if recruitType!="society">
	<#-- 实践活动 -->
	<@subpage1 name="practice" title="实践活动(填写实习、社会实践及项目经历)">
		<@span label="活动/公司名称" name="name"/>
		<@span label="职位" name="job"/>
		</tr><tr>
		<@span label="开始时间" name="beginDate"/>
		<@span label="结束时间" name="endDate"/>
		</tr><tr>
		<@span label="职责描述" name="duty"/>
	</@subpage1>
	<@subpage2 name="practice">
		<@input label="活动/公司名称" name="name" required=true/>
		<@input label="职位" name="job"/>
		</tr><tr>
		<@date label="开始时间" name="beginDate"/>
		<@date label="结束时间" name="endDate"/>
		</tr><tr>
		<@textarea label="职责描述" name="duty"/>
	</@subpage2>
	<#-- 学生干部 -->
	<@subpage1 name="studentCadre" title="学生干部(填写学生干部经历)">
		<@span label="职务" name="name"/>
		<@span label="级别" name="level" translate=true/>
		</tr><tr>
		<@span label="开始时间" name="beginDate"/>
		<@span label="结束时间" name="endDate"/>
		</tr><tr>
		<@span label="职责描述" name="description"/>
	</@subpage1>
	<@subpage2 name="studentCadre">
		<@input label="职务" name="name" required=true/>
		<@select label="级别" name="level" dict="cadreLevel"/>
		</tr><tr>
		<@date label="开始时间" name="beginDate"/>
		<@date label="结束时间" name="endDate"/>
		</tr><tr>
		<@textarea label="职责描述" name="description"/>
	</@subpage2>
</#if>
<#-- 奖励记录 -->
<@subpage1 name="award" title="奖励记录(请填写在校期间获奖情况)">
	<@span label="奖励名称" name="name"/>
	<@span label="获得时间" name="time"/>
	</tr><tr>
	<@span label="级别" name="level" translate=true wide=true/>
	</tr><tr>
	<@span label="奖励描述" name="description" wide=true/>
</@subpage1>
<@subpage2 name="award">
	<@input label="奖励名称" name="name" required=true/>
	<@date label="获得时间" name="time" required=true/>
	</tr><tr>
	<@select label="级别" name="level" dict="awardLevel" required=true/>
	</tr><tr>
	<@textarea label="奖励描述" name="description" required=true/>
</@subpage2>
<#-- 培训经历 -->
<@subpage1 name="train" title="培训经历(请填写正规培训机构培训信息)">
	<@span label="开始时间" name="beginDate"/>
	<@span label="结束时间" name="endDate"/>
	</tr><tr>
	<@span label="培训机构" name="company"/>
	<@span label="培训地点" name="place"/>
	</tr><tr>
	<@span label="培训课程" name="course" wide=true/>
	</tr><tr>
	<@span label="详细描述" name="description" wide=true/>
</@subpage1>
<@subpage2 name="train">
	<@date label="开始时间" name="beginDate"/>
	<@date label="结束时间" name="endDate"/>
	</tr><tr>
	<@input label="培训机构" name="company"/>
	<@input label="培训地点" name="place"/>
	</tr><tr>
	<@input label="培训课程" name="course" wide=true/>
	</tr><tr>
	<@textarea label="详细描述" name="description"/>
</@subpage2>
<#-- 家庭成员 -->
<@subpage1 name="family" title="家庭关系(请填写家庭和社会主要成员，父母必须填写)" required=true>
	<@span label="姓名" name="name"/>
	<@span label="关系" name="relationship" translate=true/>
	</tr><tr>
	<@span label="工作单位" name="workCompany"/>
	<@span label="职位" name="workJob"/>
	</tr><tr>
	<@span label="政治面貌" name="description" wide=true/>
</@subpage1>
<@subpage2 name="family">
	<@input label="姓名" name="name" required=true/>
	<@select label="关系" name="relationship" required=true/>
	</tr><tr>
	<@input label="工作单位" name="workCompany" required=true/>
	<@input label="职位" name="workJob" required=true/>
	</tr><tr>
	<@input label="政治面貌" name="description" required=true/>
</@subpage2>