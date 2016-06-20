<#include "user/common.ftl"/>
<@bootstrap.head>
<title>密码修改</title>
<script>
	$(document).ready(function() {
		$('#updatePasswordForm').ajaxForm({
			"beforeSubmit":function(datas){
				var password=$("#updatePasswordForm input[name='password']").val();
				var password2=$("#updatePasswordForm input[name='password2']").val();
				if(password!=password2){
					$('#updatePasswordForm').showError({"password":"密码不一致","password2":"密码不一致"});
					return false;
				}else{
					return true;
				}
			},"success":function(text) {
				if(text.success){
					alert("修改成功");
					$(".col_cv_alt").empty();
				}else{
					$('#updatePasswordForm').showError(text.error);
					changeCaptcha();
				}
			}
		});
	});
	
	//换验证码
	function changeCaptcha(){
		$("#captcha").attr("src","<@spring.url "/user/captchaImage.png"/>?r="+Math.random());
	}
</script>
</@bootstrap.head>
<@bootstrap.body>
<div class="container">
	<#include "user/left.ftl"/>
	<@c.right title="密码修改">
	<form id="updatePasswordForm" action="<@spring.url "/user/updatePassword"/>" method="post" class="reg_con userForm">
        <ul>
        	<@input type="password" label="旧密码" name="oldPassword"/>
        	<@input type="password" label="新密码" name="password">
                <p>6-16位，数字、字母或常用符号，至少包含2种组合</p>
			</@input>
			<@input type="password" label="重复密码" name="password2"/>
            <li>
                <label>验证码：</label>
                <input type="text" name="captcha" style="width:70px;"/>
            	<img id="captcha" src="<@spring.url "/user/captchaImage.png"/>" width="78px" height="34px" alt="" />
            	<a href="javascript:changeCaptcha();">换一张</a>
            	<div class="col_cv_alt" data-error="captcha"></div>
            </li>
            </li>
            <div class="btn_m">
                <input type="button" class="button btnbg2" value="取消" onclick="window.history.back();">
                <input type="submit" class="button btnbg1" value="提交">
            </div>
        </ul>
    </form>
	</@c.right>
</div>
</@bootstrap.body>