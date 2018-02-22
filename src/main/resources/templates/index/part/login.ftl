<style>
	.userForm .col_cv_alt {
    	margin: 0 0 0 60px;
    }
</style>

<div class='col-xs-4 padding-l'>
    <div class="box_3">
        <div class="box_4" style="height:375px;">
            <div id="loginDiv">
	        	<#if user??>
                <h3>欢迎回来！</h3>
                <form class="login in">
                    <ul>
                        <li>您好！<b>${user.name}</b><a href="<@spring.url "/notice/list"/>" class="fr">您有<b class="red">${noticeCount}</b>个新通知</a></li>
                        <li style="margin-bottom:0;">
                            <input type="button" class="button btnbg3" value="我的简历" onclick="window.location.href='<@spring.url "/resume/list"/>';"/>
                            <input type="button" class="button btnbg4" value="我的通知" onclick="window.location.href='<@spring.url "/notice/list"/>';"/>
                            <input type="button" class="button btnbg5" value="退出登陆" onclick="logout();">
                        </li>
                        <#--
                        <li class="last">上次登录时间：2016.05.13 10:59:54</li>
                        -->
                    </ul>
                </form>
                <#else>
                <h3>请登录</h3>
                <form id="loginForm" action="<@spring.url "/user/login"/>" method="post" class="login userForm">
                    <ul>
                        <li>
                            <label>用户名：</label>
                            <input type="text" name="username" placeholder="请输入身份证号码/邮箱/手机号码">
                            <div class="col_cv_alt" data-error="username"></div>
                        </li>
                        <li>
                            <label>密码：</label>
                            <input type="password" name="password">
                            <div class="col_cv_alt" data-error="password"></div>
                        </li>
                        <li>
                            <label>验证码：</label>
                            <input type="text" name="captcha" style="width:70px;"/>
                        	<img id="captcha" src="<@spring.url "/user/captchaImage.png"/>" width="78px" height="34px" alt="" />
                        	<a href="javascript:changeCaptcha();">换一张</a>
                        	<div class="col_cv_alt" data-error="captcha"></div>
                        </li>
                        <p> <a href="<@spring.url "/user/forgetPassword"/>">忘记密码?</a></p>
                        <li style="margin-left: 5px;">
                            <input type="button" onclick="window.location.href='<@spring.url "/user/register"/>';" class="button btnbg1" value="注册">
                            <input type="submit" class="button btnbg2" value="登陆">
                        </li>
                    </ul>
                </form>
	            </#if>
            </div>
        </div>
    </div>
</div>
<div class="clearfix"> </div>
<script>
	$(document).ready(function() {
		$("#loginForm").ajaxForm({
			beforeSerialize: function($form, options){
				// var $password=$form.find("input[name='password']");
				// var b = new Base64();
				// $password.val(b.encode($password.val()));
			},"success":function(text) {
				$("#loginForm").find(".col_cv_alt").empty();
				$("#loginForm").find("input[name='password']").val("");
				if(text.success){
					$.alert("欢迎您访问瑞丰银行网站招聘栏目，请注意，招聘用户专门为投简历所使用，与我行其他用户没有关联。",function(){
						window.location.reload();
					});
				}else{
					if(text.error){
						changeCaptcha();
						for(var key in text.error){
							$("#loginForm").find(".col_cv_alt[data-error='"+key+"']").text(text.error[key]);
						}
					}
				}
			}
		});
	});
	
	//换验证码
	function changeCaptcha(){
		$("#captcha").attr("src","<@spring.url "/user/captchaImage.png"/>?r="+Math.random());
	}
	
	//注销
	function logout(){
		$.ajax({
			url:"<@spring.url "/user/logout"/>"
			,success:function(){
				$.alert("退出登陆，感谢您关注瑞丰银行人才招聘！",function(){
					window.location.reload();
				});
			}
		});
	}
</script>