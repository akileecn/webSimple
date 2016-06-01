<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html >
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
	<title>登录</title>
	<!-- Bootstrap -->
	<link href="<c:url value="/resources/bootstrap-3.3.6/css/bootstrap.min.css"/>" rel="stylesheet">
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
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
</head>
<body>
	<div class="container">
		<c:url var="loginUrl" value="/user/login" />
		<form:form method="post" action="${loginUrl}" modelAttribute="userLoginForm" class="form-signin">
			<h2>请登录</h2>
			<label for="username" class="sr-only">用户名:</label>
			<form:input path="username" placeholder="用户名" class="form-control" required="true" autofocus="true"/><form:errors path="username" />
			<label for="password" class="sr-only">密码:</label>
			<form:password path="password" placeholder="密码" class="form-control" required="true"/><form:errors path="password" />
			<div class="checkbox">
				<label><input type="checkbox" value="remember-me">
					记住我
				</label>
			</div>
			<button type="submit" class="btn btn-lg btn-primary btn-block">登录</button>
			<button type="button" class="btn btn-lg btn-primary btn-block" onclick="window.location.href='<c:url value="/user/register"/>';">注册</button>
		</form:form>
	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="<c:url value="/resources/jquery/jquery-1.12.3.js"/>"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="<c:url value="/resources/bootstrap-3.3.6/js/bootstrap.min.js"/>"></script>
</body>
</html>