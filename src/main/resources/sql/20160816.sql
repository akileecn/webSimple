-- 增加短信模版
insert into zp_static_page(code,attr,content)values('messageTemplate','register',N'欢迎注册瑞丰银行招聘网账号，您的注册验证码为${code}，有效时间为3分钟，请妥善保管，过期需重新申请。');
insert into zp_static_page(code,attr,content)values('messageTemplate','updatePassword',N'欢迎登陆瑞丰银行招聘网站，您的验证码为${code}。');