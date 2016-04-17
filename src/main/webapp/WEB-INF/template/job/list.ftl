<@bootstrap.head>
<title>用户列表页</title>
</@bootstrap.head>
<@bootstrap.body>
<div class="container">
	<table class="table">
		<tr>
			<th>岗位名称</th>
			<th>工作年限</th>
			<th>工作城市</th>
			<th>岗位要求</th>
			<th>创建时间</th>
		</tr>
		<#list list as job>
		<tr>
			<td>${job.name}</td>
			<td>${dictMap['work_year'][job.workYear]}(${job.workYear})</td>
			<td>${dictMap['work_city'][job.workCity]}(${job.workCity})</td>
			<td>${job.requirement}</td>
			<td>${job.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
		</tr>
		</#list>
	</table>
</div>
</@bootstrap.body>