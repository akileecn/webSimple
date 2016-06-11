<#-- subpage1+subpage2于deprecated文件夹下的模版效果相同 -->
<#-- 教育经历 -->
<@subpage1 name="education" title="教育经历" required=true>
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
	<@input label="学校名称" name="schoolName" required=true/>
	<@input label="所学专业" name="major" required=true/>
	</tr><tr>
	<@select label="毕业方式" name="graduateType" required=true/>
	<@select label="所得学位" name="degree" required=true/>
	</tr><tr>
	<@select label="学历等级" name="education" required=true/>
	<@select label="学习形式" name="learnType" required=true/>
	</tr><tr>
	<@date label="开始时间" name="beginDate" required=true/>
	<@date label="结束时间" name="endDate" required=true/>
	</tr><tr>
	<@select label="学校类别" name="schoolType" required=true/>
	<@radio label="是否担任过学生干部" name="hasBeenCadre" required=true/>
	</tr><tr>
	<@select label="年级排名" name="gradeRank" required=true/>
</@subpage2>
<#-- 工作实习经历 -->
<@subpage1 name="work" title="工作实习经历" required=(recruitType=="society")>
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
	<@input label="单位名称" name="company" required=true/>
	<@input label="年薪" name="annualSalary"/>
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
	<@date label="开始时间" name="beginDate" required=true/>
	<@date label="结束时间" name="endDate" required=true/>
	</tr><tr>
	<@textarea label="离职原因" name="dimissionReason"/>
	</tr><tr>
	<@textarea label="职责描述" name="duty" required=true/>
	</tr><tr>
	<@textarea label="工作业绩" name="performance" required=true/>
</@subpage2>
<#-- 学生干部情况（从初中开始） -->
<#if recruitType=="campus">
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
		<@date label="开始时间" name="beginDate" required=true/>
		<@date label="结束时间" name="endDate" required=true/>
		</tr><tr>
		<@input label="所在院校" name="school" required=true/>
		<@input label="学生干部名称" name="name" required=true/>
		</tr><tr>
		<@select label="学生干部级别" name="level" dict="cadreLevel" required=true/>
		<@input label="证明人" name="certifier"/>
		</tr><tr>
		<@input label="证明人联系方式" name="certifierMobile"/>
	</@subpage2>
</#if>
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
	<@input label="奖励名称" name="name" required=true/>
	<@date label="获得时间" name="time" required=true/>
	</tr><tr>
	<@select label="级别" name="level" dict="awardLevel"/>
	</tr><tr>
	<@textarea label="奖励描述" name="description"/>
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
	<@select label="英语等级" name="level" dict="languageLevel" required=true/>
	<@input label="英语分数" name="score" required=true/>
	</tr><tr>
	<@select label="英语口语" name="speaking" dict="languageProficiency"/>
	<@select label="其他语言" name="others" dict="language"/>
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
	<@input label="证书名称" name="certificate" required=true/>
	<@date label="取得时间" name="obtainDate" required=true/>
	</tr><tr>
	<@select label="掌握程度" name="level"/>
	</tr><tr>
	<@textarea label="详细说明" name="detail"/>
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
	<@input label="姓名" name="name" required=true/>
	<@select label="关系" name="relationship" required=true/>
	</tr><tr>
	<@input label="工作单位" name="workCompany"/>
	<@input label="职位" name="workJob"/>
	</tr><tr>
	<@textarea label="说明" name="description"/>
</@subpage2>