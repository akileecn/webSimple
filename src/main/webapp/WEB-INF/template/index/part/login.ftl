<style>
	.col_cv_alt{
		margin:0 0 0 60px;
		text-align:left;
		font-size:0.85em;
		color:#F00;	
	}
</style>
<div class='col-xs-4 padding-l'>
    <div class="box_3">
        <div class="box_4">
            <div>
                <h3>请登录</h3>
                <form id="loginForm" action="<@spring.url "/user/login"/>" method="post" class="login">
                    <ul>
                        <li>
                            <label>用户名：</label>
                            <input type="text" name="username" placeholder="请输入身份证号码/邮箱/手机号码">
                            <div class="col_cv_alt" data-error="username"></div>
                        </li>
                        <li>
                            <label>密码：</label>
                            <input type="password" name="password" placeholder="请输入密码">
                            <div class="col_cv_alt" data-error="password"></div>
                        </li>
                        <li>
                            <label>验证码：</label>
                            <input type="text" name="" style="width:70px;"><img src="<@c.resource "images/image007.jpg"/>" width="auto" height="34px" alt="" /><a href="#">换一张</a>
                        </li>
                        <p> <a href="#">忘记密码?</a></p>
                        <li style="margin-left: 5px;">
                            <input type="button" onclick="window.location.href='<@spring.url "/user/register"/>';" class="button btnbg1" value="注册">
                            <input type="submit" class="button btnbg2" value="登陆">
                        </li>
                    </ul>
                </form>
            </div>
            <div style="display: none;">
                <h3>欢迎回来！</h3>
                <form class="login in">
                    <ul>
                        <li>上午好！<b>张三</b><a href="#" class="fr">您有<b class="red">xxxx</b>个通知</a></li>
                        <li style="margin-bottom:0;">
                            <input type="button" class="button btnbg3" value="我的简历">
                            <input type="button" class="button btnbg4" value="我的通知">
                            <input type="button" class="button btnbg5" value="退出登陆">
                        </li>
                        <li class="last">上次登录时间：2016.05.13 10:59:54</li>
                    </ul>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="clearfix"> </div>
<script>
	$(document).ready(function() {
		$("#loginForm").ajaxForm(function(text) {
			$("#loginForm").find(".col_cv_alt").empty();
			if(text.success){
			}else{
				if(text.error){
					for(var key in text.error){
						$("#loginForm").find(".col_cv_alt[data-error='"+key+"']").text(text.error[key]);
					}
				}
			}
		});
	});
</script>