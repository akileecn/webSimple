<@bootstrap.head>
<title>注册</title>
<script>
	$(document).ready(function() {
		$('#myForm').ajaxForm(function(text) {
			if(text.success){
			}else{
				$.alert(text.error);
			}
		});
	});
</script>
</@bootstrap.head>
<@bootstrap.body>
<div class="container">
	<form id="myForm" action="<@spring.url "/user/register"/>" method="post">
		<label for="email">邮箱:</label><input type="text" name="email"/><br/>
		<label for="idNumber">身份证号码:</label><input type="text" name="idNumber"/><br/>
		<label for="mobile">手机号码:</label><input type="text" name="mobile"/><br/>
		<label for="password">密码:</label><input type="password" name="password"/><br/>
		<label for="password2">重复密码:</label><input type="password" name="password2"/><br/>
		<label for="question">找回密码问题:</label><input type="text" name="question"/><br/>
		<label for="answer">答案:</label><input type="text" name="answer"/><br/>
		<button type="submit">注册</button>
	</form>
</div>
</@bootstrap.body>