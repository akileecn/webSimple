<@bootstrap.head>
<title>岗位列表页</title>
</@bootstrap.head>
<@bootstrap.body>
<div class="container">
	<form action="<@spring.url "/job/list"/>" method="post">
		<label for="workCity">工作地点:</label>
		<@c.select name="workCity" value=form.workCity/>
		<label for="education">学历要求:</label>
		<@c.select name="education" value=form.education/>
		<label for="publishDateType">发布时间:</label>
		<@c.select name="publishDateType" value=form.publishDateType/>
		<label for="name">岗位名称:</label>
		<input type="text" name="name" value="${form.name}"/>
		<button type="submit" class="btn">搜索</button>
	</form>
	<table class="table">
		<tr>
			<th>招聘岗位</th>
			<th>工作地点</th>
			<th>截止时间</th>
			<th>招聘人数</th>
			<th></th>
		</tr>
		<#list page.list as job>
		<tr>
			<td>${job.name}</td>
			<td>${dictMap['workCity'][job.workCity]}(${job.workCity})</td>
			<td>${(job.endDime?string('yyyy-MM-dd'))!""}</td>
			<td>${job.peopleNumber}</td>
			<td></td>
		</tr>
		</#list>
		<tr><td>共${page.total}条</td></tr>
	</table>
</div>
</@bootstrap.body>