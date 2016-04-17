<@bootstrap.head>
<title>登录</title>
<style type="text/css">
	body {
		padding-top: 40px;
		padding-bottom: 40px;
		background-color: #eee;
	}
	.form-signin {
		max-width: 330px;
		padding: 15px;
		margin: 0 auto;
	}
	.form-signin .form-signin-heading, .form-signin .checkbox {
		margin-bottom: 10px;
	}
	.form-signin .checkbox {
		font-weight: normal;
	}
	.form-signin .form-control {
		position: relative;
		height: auto;
		-webkit-box-sizing: border-box;
		-moz-box-sizing: border-box;
		box-sizing: border-box;
		padding: 10px;
		font-size: 16px;
	}
	.form-signin .form-control:focus {
		z-index: 2;
	}
	.form-signin input[type="text"] {
		margin-bottom: -1px;
		border-bottom-right-radius: 0;
		border-bottom-left-radius: 0;
	}
	.form-signin input[type="password"] {
		margin-bottom: 10px;
		border-top-left-radius: 0;
		border-top-right-radius: 0;
	}
</style>
</@bootstrap.head>
<@bootstrap.body>
<div class="container">
	<form action="<@spring.url "/user/login"/>" method="post" class="form-signin">
		<h2>请登录</h2>
		<label for="username" class="sr-only">用户名:</label>
		<@spring.formInput path="userLoginForm.username" attributes='placeholder="用户名" class="form-control" required="true" autofocus="true"'/>
		<label for="password" class="sr-only">密码:</label>
		<@spring.formPasswordInput path="userLoginForm.password" attributes='placeholder="密码" class="form-control" required="true"'/>
		<div class="checkbox">
			<label><input type="checkbox" value="remember-me">
				记住我
			</label>
		</div>
		<button type="submit" class="btn btn-lg btn-primary btn-block">登录</button>
		<button type="button" class="btn btn-lg btn-primary btn-block" onclick="window.location.href='<@spring.url "/user/register"/>';">注册</button>
	</form>
</div>
</@bootstrap.body>