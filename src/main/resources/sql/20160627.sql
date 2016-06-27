insert into zp_dict_type(code,name)values('recruitArea',N'招聘区域');
insert into zp_dict_data(type_code,code,name)values('recruitArea','1',N'全国');
insert into zp_dict_data(type_code,code,name)values('recruitArea','2',N'浙江');
insert into zp_dict_data(type_code,code,name)values('recruitArea','3',N'绍兴');
insert into zp_dict_data(type_code,code,name)values('recruitArea','4',N'义乌');

alter table zp_job alter column people_number nvarchar(32);