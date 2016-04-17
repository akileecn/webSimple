/*2016-03-31*/
insert into user(username,password)values('aki','123456');
insert into role(name)values('admin');
insert into role(name)values('r2');
insert into user_role(user_id,role_id)values(1,1);
insert into permission(name)values('p1');
insert into permission(name)values('p2');
insert into permission(name)values('p3');
insert into role_permission(role_id,permission_id)values(1,1);
insert into role_permission(role_id,permission_id)values(1,2);
/*2016-04-15*/
insert into dict_type(code,name,remark)
values('work_year','工作年限',null)
	,('work_city','工作城市',null);
insert into dict_data(type_code,code,name,create_time)
values('work_year','1','应届生',now()),('work_year','2','2-3年',now()),('work_year','3','3年以上',now())
	,('work_city','1','北京',now()),('work_city','2','上海',now()),('work_city','3','广州',now());
insert into job(name,work_year,work_city,requirement,description,create_time)
values('CEO','1','2','谁都行','老大',now())
	,('前台','3','1','妹子','接客',now());