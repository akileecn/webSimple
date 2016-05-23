<#-- subpage1+subpage2于deprecated文件夹下的模版效果相同 -->
<#-- 奖励记录 -->
<@subpage1 name="award" title="奖励记录">
	<@span label="奖励名称" name="name"/>
	<@span label="获得时间" name="time"/>
	</tr><tr>
	<@span label="级别" name="level" translate=true wide=true/>
	</tr><tr>
	<@span label="奖励描述" name="description" wide=true/>
</@subpage1>
<@subpage2 name="award">
	<@input label="奖励名称" name="name"/>
	<@date label="获得时间" name="time"/>
	</tr><tr>
	<@select label="级别" name="level" dict="awardLevel"/>
	</tr><tr>
	<@textarea label="奖励描述" name="description"/>
</@subpage2>
<#-- 计算机情况 -->
<@subpage1 name="computer" title="计算机情况">
	<@span label="证书名称" name="certificate"/>
	<@span label="取得时间" name="obtainDate"/>
	</tr><tr>
	<@span label="掌握程度" name="level"/>
	</tr><tr>
	<@span label="详细说明" name="detail" wide=true/>
</@subpage1>
<@subpage2 name="computer">
	<@input label="证书名称" name="certificate"/>
	<@date label="取得时间" name="obtainDate"/>
	</tr><tr>
	<@select label="掌握程度" name="level"/>
	</tr><tr>
	<@textarea label="详细说明" name="detail"/>
</@subpage2>
<#-- 教育经历 -->
<@subpage1 name="education" title="教育经历">
	<@span label="学校名称" name="schoolName"/>
	<@span label="所学专业" name="major"/>
	</tr><tr>
	<@span label="毕业方式" name="graduateType" translate=true/>
	<@span label="所得学位" name="degree" translate=true/>
	</tr><tr>
	<@span label="学历等级" name="education" translate=true/>
	<@span label="学习形式" name="learnType" translate=true/>
	</tr><tr>
	<@span label="开始时间" name="beginDate"/>
	<@span label="结束时间" name="endDate"/>
	</tr><tr>
	<@span label="学校类别" name="schoolType" translate=true/>
	<@span label="是否担任过学生干部" name="hasBeenCadre" translate=true attr="style=\"width:200px;\""/>
	</tr><tr>
	<@span label="年级排名" name="gradeRank" translate=true/>
</@subpage1>
<@subpage2 name="education">
	<@input label="学校名称" name="schoolName"/>
	<@input label="所学专业" name="major"/>
	</tr><tr>
	<@select label="毕业方式" name="graduateType"/>
	<@select label="所得学位" name="degree"/>
	/tr><tr>
	<@select label="学历等级" name="education"/>
	<@select label="学习形式" name="learnType"/>
	</tr><tr>
	<@date label="开始时间" name="beginDate"/>
	<@date label="结束时间" name="endDate"/>
	</tr><tr>
	<@select label="学校类别" name="schoolType"/>
	<@radio label="是否担任过学生干部" name="hasBeenCadre"/>
	</tr><tr>
	<@select label="年级排名" name="gradeRank"/>
</@subpage2>
<#-- 家庭成员 -->
<@subpage1 name="family" title="家庭成员">
	<@span label="姓名" name="name"/>
	<@span label="关系" name="relationship" translate=true/>
	</tr><tr>
	<@span label="工作单位" name="workCompany"/>
	<@span label="职位" name="workJob"/>
	</tr><tr>
	<@span label="说明" name="description" wide=true/>
</@subpage1>
<@subpage2 name="family">
	<@input label="姓名" name="name"/>
	<@select label="关系" name="relationship"/>
	</tr><tr>
	<@input label="工作单位" name="workCompany"/>
	<@input label="职位" name="workJob"/>
	</tr><tr>
	<@textarea label="说明" name="description"/>
</@subpage2>
<#-- 外语情况 -->
<@subpage1 name="foreignLanguage" title="外语情况">
	<@span label="英语等级" name="level" translate=true/>
	<@span label="英语分数" name="score"/>
	</tr><tr>
	<@span label="英语口语" name="speaking" translate=true/>
	<@span label="其他语言" name="others" translate=true/>
</@subpage1>
<@subpage2 name="foreignLanguage">
	<@select label="英语等级" name="level" dict="languageLevel"/>
	<@input label="英语分数" name="score"/>
	</tr><tr>
	<@select label="英语口语" name="speaking" dict="languageProficiency"/>
	<@select label="其他语言" name="others" dict="language"/>
</@subpage2>
<#-- 学生干部情况（从初中开始） -->
<@subpage1 name="studentCadre" title="学生干部情况（从初中开始）">
	<@span label="开始时间" name="beginDate"/>
	<@span label="结束时间" name="endDate"/>
	</tr><tr>
	<@span label="所在院校" name="school"/>
	<@span label="学生干部名称" name="name"/>
	</tr><tr>
	<@span label="学生干部级别" name="level" translate=true/>
	<@span label="证明人" name="certifier"/>
	</tr><tr>
	<@span label="证明人联系方式" name="certifierMobile"/>
</@subpage1>
<@subpage2 name="studentCadre">
	<@date label="开始时间" name="beginDate"/>
	<@date label="结束时间" name="endDate"/>
	</tr><tr>
	<@input label="所在院校" name="school"/>
	<@input label="学生干部名称" name="name"/>
	</tr><tr>
	<@select label="学生干部级别" name="level" dict="cadreLevel"/>
	<@input label="证明人" name="certifier"/>
	</tr><tr>
	<@input label="证明人联系方式" name="certifierMobile"/>
</@subpage2>
<#-- 工作实习经历 -->
<@subpage1 name="work" title="工作实习经历">
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
	<@span label="开始时间" name="beginDate"/>
	<@span label="结束时间" name="endDate"/>
	</tr><tr>
	<@span label="离职原因" name="dimissionReason" wide=true/>
	</tr><tr>
	<@span label="职责描述" name="duty" wide=true/>
	</tr><tr>
	<@span label="工作业绩" name="performance" wide=true/>
</@subpage1>
<@subpage2 name="work">
	<@input label="单位名称" name="company"/>
	<@input label="年薪" name="annualSalary"/>
	</tr><tr>
	<@input label="部门名称" name="department"/>
	<@input label="职位" name="job"/>
	</tr><tr>	
	<@input label="证明人" name="certifier"/>
	<@input label="证明人电话" name="certifierMobile"/>
	</tr><tr>
	<@input label="工作地点" name="workPlace"/>
	<@select label="职位类型" name="jobType"/>
	</tr><tr>
	<@date label="开始时间" name="beginDate"/>
	<@date label="结束时间" name="endDate"/>
	</tr><tr>
	<@textarea label="离职原因" name="dimissionReason"/>
	</tr><tr>
	<@textarea label="职责描述" name="duty"/>
	</tr><tr>
	<@textarea label="工作业绩" name="performance"/>
</@subpage2>