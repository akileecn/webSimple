<#include "user/common.ftl"/>
<@bootstrap.head>
<title>注册</title>
<script>
	$(document).ready(function() {
		$('#registerForm').ajaxForm({
			"beforeSubmit":function(datas){
				if(!$("#registerForm input[name='isAgree']").is(":checked")){
					alert("阅读并接受《用户协议》之后才能注册");
					return false;
				}
				var password=$("#registerForm input[name='password']").val();
				var password2=$("#registerForm input[name='password2']").val();
				if(password!=password2){
					$('#registerForm').showError({"password":"新旧密码不一致","password2":"新旧密码不一致"})
					return false;
				}else{
					return true;
				}
			},"success":function(text) {
				if(text.success){
					art.dialog({
				        lock: true,
				        id: "abc",
				        content: '<@compress single_line=true>
							<div class="pop_job pop_w2">
						        <span class="close" onclick="art.dialog.list[\'abc\'].close();"></span>
						        <h2>提示</h2>
						        <div class="pop_job_col">
						            <div class="pop_job_p"><div class="pop_job_yix">
				                        <div class="cen">您的注册已经成功，接下来请[登录]完善你的简历信息，填写完简历之后才可以申请我行职位。</div>
				                        <div class="btn">
				                            <input type="submit" value="返回登录页" onclick="window.location.href=\'<@spring.url "/index"/>\';">
				                        </div>
									</div></div>
						        </div>
						    </div>
						</@compress>'
				    });
				}else{
					alert("表单信息有误");
					$('#registerForm').showError(text.error);
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
	<@c.right title="注册新用户">
	<form id="registerForm" action="<@spring.url "/user/register"/>" method="post" class="reg_con userForm">
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
                <input type="text" name="captcha" style="width:70px;"/>
            	<img id="captcha" src="<@spring.url "/user/captchaImage.png"/>" width="78px" height="34px" alt="" />
            	<a href="javascript:changeCaptcha();">换一张</a>
            	<div class="col_cv_alt" data-error="captcha"></div>
                <p class="tl"><input name="isAgree" type="checkbox" value=""/><a href="javascript:showUserAgreement();" style=" text-decoration:underline;">阅读并接受《用户协议》</a></p>
            </li>
            <div class="btn_m">
                <input type="button" class="button btnbg2" value="取消">
                <input type="submit" class="button btnbg1" value="提交">
            </div>
        </ul>
    </form>
	</@c.right>
</div>
<script>
	//显示用户协议
	function showUserAgreement(){
		$.get("<@spring.url "/staticPage/userAgreement"/>",function(text){
			art.dialog({
		        lock: true,
		        id: "abc",
		        content: text
		    });
		});
	}
</script>
</@bootstrap.body>