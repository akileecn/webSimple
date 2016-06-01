<#include "user/common.ftl"/>
<@bootstrap.head>
<title>密码修改</title>
<script>
	$(document).ready(function() {
		$('#updatePasswordForm').ajaxForm(function(text) {
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
	<@c.right title="密码修改">
	<form id="updatePasswordForm" action="<@spring.url "/user/updatePassword"/>" method="post" class="reg_con">
        <ul>
        	<@input type="password" label="旧密码" name="oldPassword"/>
        	<@input type="password" label="新密码" name="password">
                <p>6-16位，数字、字母或常用符号，至少包含2种组合</p>
			</@input>
			<@input type="password" label="重复密码" name="password2"/>
            <li>
                <label>验证码：</label>
                <input type="text" style="width:70px;">
                <img src="<@c.resource "images/image007.jpg"/>" width="auto" height="34px" alt="" /><a href="#">换一张</a>
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