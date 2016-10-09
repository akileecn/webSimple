<#include "user/common.ftl"/>
<@bootstrap.head>
<title>注册</title>
<script>
	$(document).ready(function() {
		$('#registerForm').ajaxForm({
			"beforeSubmit":function(datas){
				if(!$("#registerForm input[name='isAgree']").is(":checked")){
					$.alert("阅读并接受《用户协议》之后才能注册");
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
					$.alert("表单信息有误");
					$('#registerForm').showError(text.error);
					changeCaptcha();
				}
			}
		});
	});
	
	//换验证码
	function changeCaptcha(id){
		$("#"+(id?id:"captcha")).attr("src","<@spring.url "/user/captchaImage.png"/>?r="+Math.random());
	}
	
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
	//计时
	var INTERVAL=60;
	var _time=INTERVAL;
	function timer(){
		if(_time>0){
			$("#sendButton").val(_time+"秒后重新获取");
			_time--;
			setTimeout(timer,1000);
		}else{
			$("#sendButton").val("获取短信验证码");
			_time=INTERVAL;
		}
	}
	//直接发送短信
	function showSendMessage(){
		if(_time!=INTERVAL){
			return;
		}
		//验证
		$("[data-error='mobile']").empty();
		var mobile=$("input[name='mobile']").val();
		if(!/^1\d{10}$/.test(mobile)){
			$("[data-error='mobile']").text("手机号码格式不正确");
			return;
		}
		//倒计时
		timer();
		//发送
		$.ajax({
			url:"<@spring.url "/user/sendMessage/register"/>"
			,data:{"mobile":mobile}
			,type:"post"
			,success:function(text){
				if(text.success){
					$("[data-error='mobile']").text("短信发送成功");
				}else{
					$("[data-error='mobile']").text(text.message);
				}	
			}
		});
		<#-- 短信发送不需要验证码
		art.dialog({
	        lock: true,
	        id: "abc",
	        content: $.template('<@compress single_line=true>
			<div class="pop_job">
			    <span class="close" onclick="art.dialog.list[\'abc\'].close();changeCaptcha();"></span>
			    <h2>获取短信验证码</h2>
			    <div class="pop_job_col" style="padding:10px;">
					<form id="sendMessageForm" action="<@spring.url "/user/sendMessage/register"/>" method="post" class="reg_con userForm">
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
	    -->
	}
	<#--
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
	-->
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
			<#--
			<li>
			    <label>手机号码：</label>
			    <input type="text" name="mobile" placeholder="请输入手机号码"/>
			    <input type="button" id="sendButton" value="获取短信验证码" style="width:90px;" onclick="showSendMessage();"/>
			    <span class="red">*</span>
			    <div class="col_cv_alt" data-error="mobile"></div>
			</li>
			<@input label="短信验证码" name="messageCaptcha"/>
			-->
			<@input label="找回密码问题" name="question"/>
			<@input label="答案" name="answer"/>
            <li>
            	<label>验证码：</label>
                <input type="text" name="captcha" style="width:70px;"/>
            	<img id="captcha" src="<@spring.url "/user/captchaImage.png"/>" width="78px" height="34px" alt="" />
            	<a href="javascript:changeCaptcha();">换一张</a>
            	<div class="col_cv_alt" data-error="captcha"></div>
                <p class="tl"><input name="isAgree" type="checkbox" value="" style="width:35px;"/><a href="javascript:showUserAgreement();" style=" text-decoration:underline;">阅读并接受《用户协议》</a></p>
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