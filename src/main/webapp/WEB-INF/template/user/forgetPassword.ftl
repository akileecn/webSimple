<#include "user/common.ftl"/>
<@bootstrap.head>
<title>忘记密码</title>
<script>
	$(document).ready(function() {
		$('#forgetPasswordForm1').ajaxForm(function(text) {
			$('#forgetPasswordForm2').clearError();
			if(text.success){
				$("#forgetPasswordForm1").hide();
				$("#forgetPasswordForm2").autofill(text.data);
				$("#forgetPasswordForm2").show();
			}else{
				$('#forgetPasswordForm1').showError(text.error);
			}
		});
		$('#forgetPasswordForm2').ajaxForm({
			"beforeSubmit":function(datas){
				var password=$("#forgetPasswordForm2 input[name='password']").val();
				var password2=$("#forgetPasswordForm2 input[name='password2']").val();
				if(password!=password2){
					$('#forgetPasswordForm2').showError({"password":"密码不一致","password2":"密码不一致"});
					return false;
				}else{
					return true;
				}
			},"success":function(text) {
				if(text.success){
					$.alert("修改成功");
					$('#forgetPasswordForm2').clearError();
				}else{
					$('#forgetPasswordForm2').showError(text.error);
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
	<@c.right title="忘记密码">
	<form id="forgetPasswordForm1" action="<@spring.url "/user/forgetPassword/userInfo"/>" method="post" class="reg_con userForm">
        <ul>
        	<li>
                <label>用户名：</label>
                <input type="text" name="username" placeholder="请输入身份证号码/邮箱/手机号码">
                <div class="col_cv_alt" data-error="username"></div>
            </li>
            <div class="btn_m">
                <input type="submit" class="button btnbg1" value="下一步">
            </div>
        </ul>
    </form>
	<form id="forgetPasswordForm2" action="<@spring.url "/user/forgetPassword/byQuestion"/>" method="post" class="reg_con userForm" style="display:none;">
        <ul>
        	<li>
                <label>用户名：</label>
                <input type="text" name="username" placeholder="请输入身份证号码/邮箱/手机号码">
                <div class="col_cv_alt" data-error="username"></div>
            </li>
        	<@input label="问题" name="question"/>
        	<@input label="答案" name="answer"/>
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