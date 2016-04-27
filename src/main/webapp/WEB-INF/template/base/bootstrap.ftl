<#-- html头 -->
<#macro head>
<!DOCTYPE html >
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
	<!-- Bootstrap -->
	<link href="<@spring.url "/resources/bootstrap-3.3.6/css/bootstrap.min.css"/>" rel="stylesheet">
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="<@spring.url "/resources/jquery/jquery-1.12.3.js"/>"></script>
	<#-- 异步提交表单 -->
	<script src="<@spring.url "/resources/jquery/jquery.form.js"/>"></script>
	<#-- 公共方法 -->
	<script src="<@spring.url "/resources/js/common.js"/>"></script>
	<#nested>
</head>
</#macro>

<#-- html体 -->
<#macro body>
<body>
	<#nested>
	
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="<@spring.url "/resources/bootstrap-3.3.6/js/bootstrap.min.js"/>"></script>
</body>
</html>
</#macro>