<#include "user/common.ftl"/>
<@bootstrap.head>
<title>忘记密码</title>
<script>
	$(document).ready(function() {
		$('#forgetPasswordForm').ajaxForm({
			"beforeSubmit":function(datas){
				var password=$("#forgetPasswordForm2 input[name='password']").val();
				var password2=$("#forgetPasswordForm2 input[name='password2']").val();
				if(password!=password2){
					$('#forgetPasswordForm').showError({"password":"密码不一致","password2":"密码不一致"});
					return false;
				}else{
					return true;
				}
			},"success":function(text) {
				if(text.success){
					$.alert("修改成功");
					$('#forgetPasswordForm').clearError();
				}else{
					$('#forgetPasswordForm').showError(text.error);
					changeCaptcha();
				}
			}
		});
	});
	
	//换验证码
	function changeCaptcha(id){
		$("#"+(id?id:"captcha")).attr("src","<@spring.url "/user/captchaImage.png"/>?r="+Math.random());
	}
	
	//显示发送短信界面
	function showSendMessage(){
		$("[data-error='mobile']").empty();
		var mobile=$("input[name='mobile']").val();
		if(!/^1\d{10}$/.test(mobile)){
			$("[data-error='mobile']").text("手机号码格式不正确");
			return;
		}
		art.dialog({
	        lock: true,
	        id: "abc",
	        content: $.template('<@compress single_line=true>
			<div class="pop_job">
			    <span class="close" onclick="art.dialog.list[\'abc\'].close();changeCaptcha();"></span>
			    <h2>获取短信验证码</h2>
			    <div class="pop_job_col" style="padding:10px;">
					<form id="sendMessageForm" action="<@spring.url "/user/sendMessage/updatePassword"/>" method="post" class="reg_con userForm">
						<ul style="padding:0;">
					        <li>
					        	<input type="hidden" name="mobile" value="%{mobile}"/>
				            	<label style="width:50px;">验证码：</label>
				                <input type="text" name="captcha" style="width:70px;"/>
				            	<img id="captcha4sendMessage" src="<@spring.url "/user/captchaImage.png"/>" width="78px" height="34px" alt="" />
				            	<a href="javascript:changeCaptcha(\'captcha4sendMessage\');">换一张</a>
				            	<div id="errorDiv" class="col_cv_alt" style="margin:0;"></div>
				            </li>
							<input type="button" class="button btnbg1" value="发送" style="margin: 0 auto;display: block;" onclick="submitSendMessageForm();"/>
				        </ul>
			    	</form>
			    </div>
			</div>
	        </@compress>',{"mobile":mobile})
	    });
	    changeCaptcha('captcha4sendMessage');
	}
	//提交发送短信表单
	function submitSendMessageForm(){
		$("#sendMessageForm").ajaxSubmit({
			"success":function(text){
				if(text.success){
					$("#errorDiv").text("短信发送成功");
				}else{
					changeCaptcha('captcha4sendMessage');
					$("#errorDiv").text(text.message);
				}	
			}
		});
	}
</script>
</@bootstrap.head>
<@bootstrap.body>
<div class="container">
	<#include "user/left.ftl"/>
	<@c.right title="忘记密码">
	<form id="forgetPasswordForm" action="<@spring.url "/user/forgetPassword/byMobile"/>" method="post" class="reg_con userForm">
        <ul>
        	<li>
			    <label>手机号码：</label>
			    <input type="text" name="mobile" placeholder="请输入手机号码"/>
			    <input type="button" value="获取短信验证码" style="width:90px;" onclick="showSendMessage();"/>
			    <span class="red">*</span>
			    <div class="col_cv_alt" data-error="mobile"></div>
			</li>
			<@input label="短信验证码" name="messageCaptcha"/>
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
            <div class="btn_m">
                <input type="button" class="button btnbg2" value="取消" onclick="window.history.back();">
                <input type="submit" class="button btnbg1" value="提交">
            </div>
        </ul>
    </form>
	</@c.right>
</div>
</@bootstrap.body>