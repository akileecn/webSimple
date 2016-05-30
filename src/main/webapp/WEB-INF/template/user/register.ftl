<#include "user/common.ftl"/>
<@bootstrap.head>
<title>注册</title>
<script>
	$(document).ready(function() {
		$('#registerForm').ajaxForm(function(text) {
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
	<#include "user/left.ftl"/>
	<@c.right title="注册新用户">
	<form id="registerForm" action="<@spring.url "/user/register"/>" method="post" class="reg_con">
        <ul>
        	<@input type="password" label="密码" name="password">
                <p>6-16位，数字、字母或常用符号，至少包含2种组合</p>
			</@input>
			<@input type="password" label="重复密码" name="password2"/>
			<@input label="真实姓名" name="name"/>
			<@input label="身份证号码" name="idNumber"/>
			<@input label="邮箱" name="email"/>
			<@input label="手机号码" name="mobile"/>
			<@input label="找回密码问题" name="question"/>
			<@input label="答案" name="answer"/>
            <li>
                <label>验证码：</label>
                <input type="text" style="width:70px;">
                <img src="<@c.resource "images/image007.jpg"/>" width="auto" height="34px" alt="" /><a href="#">换一张</a>
                <p class="tl"><input name="" type="checkbox" value=""><a href="#" style=" text-decoration:underline;">阅读并接受《用户协议》</a></p>
            </li>
            <div class="btn_m">
                <input type="button" class="button btnbg2" value="取消">
                <input type="submit" class="button btnbg1" value="提交">
            </div>
        </ul>
    </form>
	</@c.right>
</div>
</@bootstrap.body>