<@bootstrap.head>
<title>用户列表页</title>
</@bootstrap.head>
<@bootstrap.body>
<div class="container">
	<table class="table">
		<tr><th>编号</th><th>姓名</th><th>密码</th></tr>
		<#list page as user>
		<tr><td>${user?index+1}</td><td>${user.username}</td><td>${user.password}</td></tr>
		</#list>
		<tr><td colspan="3">共${page?size}条</td></tr>
	</table>
</div>
</@bootstrap.body>