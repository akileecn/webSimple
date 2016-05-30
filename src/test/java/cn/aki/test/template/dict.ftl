<#assign data={
"gender":"男,女"
,"nation":"汉族,蒙古族,回族,藏族,维吾尔族,苗族,彝族,壮族,布依族,朝鲜族,满族,侗族,瑶族,白族,土家族,哈尼族,哈萨克族,傣族,黎族,傈傈族,佤族,畲族,高山族,拉祜族,水族,东乡族,纳西族,景颇族,柯尔克孜族,土族,达斡尔族,仫佬族,姜族,布朗族,撒拉族,毛难族,仡佬族,锡伯族,阿昌族,普米族,塔吉克族,怒族,乌孜别克族,俄罗斯族,鄂温克族,崩龙族,保安族,裕固族,京族,塔塔尔族,独龙族,鄂伦春族,赫哲族,门巴族,珞巴族,基诺族"
,"marriage":"未婚,已婚,离婚,丧偶,再婚"
,"politicsStatus":"中共党员,中共预备党员,共青团员,民革会员,民盟会员,民建会员,民进会员,农工党党员,致公党党员,九三学社社员,台盟盟员,无党派民主人士,群众,其他"
,"workYear":"应届生,一年以下,一年以上,两年以上,三年以上,四年以上,五年以上"
,"workCity":"兴市越城区,绍兴市柯桥区,义乌市,嵊州市,上海"
,"health":"健康,良好,一般,残疾"
,"graduateType":"毕业,结业,肄业"
,"degree":"学士,硕士,博士,博士后,无"
,"education":"博士后,博士研究生,全日制研究生,全日制本科,全日制大专,非全日制大专,非全日制本科,高中,职高,中专,补高,初中,非全日制研究生,初中以下"
,"learnType":"连续学习-全国统考高等院校,连续学习-全国统考军队院校,连续学习-全国统考党校,连续学习-教育部认证的境外院校,连续学习-干部专修科,后续学习-夜大学,后续学习-电视大学,后续学习-职工大学,后续学习-业余,后续学习-自学考试,后续学习-管理干部学院,后续学习-成人教育学院,后续学习-网络(远程)教育,后续学习-中外合作办学(含港澳台),后续学习-研究生课程进修班,后续学习-同等学力学习,后续学习-非全国统考党校(含函授),后续学习-非全国统考军队院校(有军籍学员),后续学习-非全国统考军队院校(无军籍学员),后续学习-军队院校函授(无军籍学员),后续学习-其他函授院校,后续学习-军队院校函授(有军籍学员),后续学习-全国统考高等院校,后续学习-脱产"
,"schoolType":"211,985,QS(1-50),QS(50-100),QS(100-200),普通,其他"
,"gradeRank":"前5%,前10%,前20%,前30%,其他"
,"jobType":"管理类,营销类,技术类,专业类,IT类,其他行业"
,"awardLevel":"国家级,省级,市级,区级,校级,院级,其他"
,"languageLevel":"CET3,CET4,CET5,CET6,TEM4,TEM6,TEM8,其他,无"
,"languageProficiency":"母语,流利,简单会话"
,"language":"韩语,日语,德语,法语,西班牙语,俄罗斯语,其他"
,"relationship":"父亲,母亲,丈夫,妻子,兄弟,姐妹,其他"
,"artsOrScience":"文科,理科"
,"admissionOrder":"第一批,第二批,第三批,其他"
,"cadreLevel":"校级,院级,班级"
,"recruitType":"campus:校园,society:社会,trainee:实习生"
}/>
<#list data?keys as key>
insert into zp_dict_type(code,name)values('${key}',N'${key}');
<#list data[key]?split(",") as item>
	<#if item?contains(":")>
	<#assign words=item?split(":")>
insert into zp_dict_data(type_code,code,name)values('${key}','${words[0]}',N'${words[1]}');	
	<#else>
insert into zp_dict_data(type_code,code,name)values('${key}','${item?index+1}',N'${item}');
	</#if>
</#list>
</#list>
