//应用路径
var baseUrl="/recruit/" ;
var recruitType = {"campus":"校招","society":"社招","trainee":"实习生"};
/**
获取链接中的参数
**/
function getUrlParam(url){
	var Request = {};
	if(url.indexOf("?")!=-1){
		var str = url.substr(1); //去掉?号
		var strs = str.split("&");
		for(var i=0;i<strs.length;i++)
		{
		  Request[strs[i ].split("=")[0]]=unescape(strs[ i].split("=")[1]);
		}
	}
	return Request ;
}


//清空验证提示信息
$.fn.clearError = function(error){
	$(this).find(".col_cv_alt").empty();
}

//显示验证提示信息

$.fn.showError = function(error){
	$(this).clearError();
	if(error){
		for(var key in error){
			$(this).find(".col_cv_alt[data-error='"+ key +"']").text(error[key]);			
		}
	}
}


function goHome($t){
	location.href="main.html";
}

/***************/
var Dialog = {} ;

/***
 * 
 * 
 * @param content={title:""
 *                 content:""
 *                 href:""
 *                 type:""   dialog/opens/
 *                }	
 *            
				showDialog({
					head:"提示",
					title:"阅读并接受《用户协议》之后才能注册",
					content:"",
					href:"",
					type:"back"
				});
 */
function showDialog(content){
	Dialog=content;
	$("body").append('<a id="alert-dialog" style="display:none" href="dialog.html" style="text-decoration:underline;margin-left:35px;"  data-inline="true" data-rel="dialog" data-transition="pop">提示</a>');
	$("#alert-dialog").trigger("click");
}



/*   --------简历附属信息模板---------  */
var H = {};
//家庭信息表单
H.family = '<fieldset class="ui-controlgroup ui-controlgroup-vertical ui-corner-all" data-role="controlgroup" style="border:solid #ddd 3px;border-radius:10px;padding: 0 15px 15px 15px;"><div class="ui-controlgroup-controls ">'+
				'<form method="post">'+
				  '<div data-role="fieldcontain" class="ui-field-contain">'+
					  '<input type="hidden" name="resumeId">'+
					  '<input type="hidden" name="recruitType">'+
					  '<input type="hidden" name="id">'+
					  '<label for="name"><font color="red">* </font>姓名:</label>'+
					  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="text" name="name" id="name"></div>'+
					  		'<div class="col_cv_alt" data-error="name"></div> '+
					  		'<div class="col_cv_alt" data-error="name"></div>'+
					  '<label for="relationship"><font color="red">* </font>关系:</label>'+
								'<div class="ui-select"><select name="relationship" id="relationship" data-native-menu="true" tabindex="-1"></select><div style="display: none;" id="relationship-listbox-placeholder"></div></div>'+
								'<div class="col_cv_alt" data-error="relationship"></div> '+
								'<div class="col_cv_alt" data-error="relationship"></div>'+
					  '<label for="workCompany">工作单位:</label>'+
					  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="text" name="workCompany" id="workCompany"></div>'+
					  		'<div class="col_cv_alt" data-error="workCompany"></div>'+
					  '<label for="workJob">职位:</label>'+
					  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="text" name="workJob" id="workJob"></div>'+
					  		'<div class="col_cv_alt" data-error="workJob"></div>'+
					  '<label for="description">政治面貌:</label>'+
					  		'<div class="ui-select"><select name="description" id="politicsStatus" data-native-menu="true" tabindex="-1">'+
							'</select><div style="display: none;" id="level-listbox-placeholder"></div></div>'+
							'<div class="col_cv_alt" data-error="description"></div>'+
				 '</div>'+
				'<div data-role="controlgroup" data-type="horizontal" align="center" class="ui-controlgroup ui-controlgroup-horizontal ui-corner-all"><div class="ui-controlgroup-controls ">'+
					'<a data-role="button" href="#" data-icon="check" style="margin-left:10px;" onclick="save($(this))" url="wechatResume/saveFamily" class="ui-link ui-btn ui-icon-check ui-btn-icon-left ui-shadow ui-corner-all ui-first-child" role="button">保存</a>'+
					'<a data-role="button" href="#" data-icon="minus" style="margin-left:10px;" onclick="dele($(this))" url="wechatResume/deleteFamily" class="ui-link ui-btn ui-icon-minus ui-btn-icon-left ui-shadow ui-corner-all ui-last-child" role="button">删除</a>'+
				'</div></div>'+
				'</form>'+
				'</div></fieldset>';


H.computer = '<fieldset class=" ui-controlgroup ui-controlgroup-vertical ui-corner-all" data-role="controlgroup" style="border:solid #ddd 3px;border-radius:10px;padding: 0 15px 15px 15px;"><div class="ui-controlgroup-controls ">'+
	                '<form method="post">'+
                        '<input type="hidden" name="resumeId">'+
  					    '<input type="hidden" name="recruitType">'+
	                    '<input type="hidden" name="id">'+
	                    '<div data-role="fieldcontain" class="ui-field-contain">'+
	                      '<label for="certificate"><font color="red">* </font>证书名称:</label>'+
						  		'<div class="ui-select"><select name="certificate" id="computerCertificate" data-native-menu="true" tabindex="-1">'+
								'</select><div style="display: none;" id="level-listbox-placeholder"></div></div>'+
								'<div class="col_cv_alt" data-error="certificate"></div>'+
	                      '<label for="obtainDate"><font color="red">* </font>取得时间:</label>'+
	                      		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="date" name="obtainDate" id="obtainDate"></div>'+
	                      		'<div class="col_cv_alt" data-error="obtainDate"></div>'+
	                      '<label for="level"><font color="red">* </font>掌握程度:</label>'+
		                        '<div class="ui-select"><select name="level" id="computerProficiency" data-native-menu="true" tabindex="-1">'+
								'</select><div style="display: none;" id="level-listbox-placeholder"></div></div>'+
								'<div class="col_cv_alt" data-error="level"></div>'+
	                      '<label for="detail">详细说明：</label>'+
		                        '<textarea name="detail" id="detail" placeholder="" class="ui-input-text ui-shadow-inset ui-body-inherit ui-corner-all ui-textinput-autogrow"></textarea>'+
		                        '<div class="col_cv_alt" data-error="detail"></div>'+
	                    '</div>'+
	                    '<div data-role="controlgroup" data-type="horizontal" align="center" class="ui-controlgroup ui-controlgroup-horizontal ui-corner-all"><div class="ui-controlgroup-controls ">'+
	                    	'<a data-role="button" href="#" data-icon="check" style="margin-left:10px;" onclick="save($(this))" url="wechatResume/saveComputer" class="ui-link ui-btn ui-icon-check ui-btn-icon-left ui-shadow ui-corner-all ui-first-child" role="button">保存</a>'+
	                    	'<a data-role="button" href="#" data-icon="minus" style="margin-left:10px;" onclick="dele($(this))" url="wechatResume/deleteComputer" class="ui-link ui-btn ui-icon-minus ui-btn-icon-left ui-shadow ui-corner-all ui-last-child" role="button">删除</a>'+
	                	'</div></div>'+ 
	                '</form>'+
	            '</div></fieldset>';


H.foreignLanguage = '<fieldset class=" ui-controlgroup ui-controlgroup-vertical ui-corner-all" data-role="controlgroup" style="border:solid #ddd 3px;border-radius:10px;padding: 0 15px 15px 15px;"><div class="ui-controlgroup-controls ">'+
					    '<form method="post">'+
					'<input type="hidden" name="resumeId">'+
					'<input type="hidden" name="recruitType">'+
					'<input type="hidden" name="id">'+
					'<div data-role="fieldcontain" class="ui-field-contain">'+
					  '<label for="level"><font color="red">* </font>英语等级:</label>'+
					  		'<div class="ui-select"><select name="level" id="languageLevel" data-native-menu="true" tabindex="-1">'+
							'</select><div style="display: none;" id="level-listbox-placeholder"></div></div>'+
							'<div class="col_cv_alt" data-error="level"></div>'+
					  '<label for="score"><font color="red">* </font>英语分数:</label>'+
					  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="text" name="score" id="score"></div>'+
					  		'<div class="col_cv_alt" data-error="score"></div>'+
					  '<label for="proficiency">熟练程度：</label>'+
						  	'<div class="ui-select"><select name="proficiency" id="languageProficiency" data-native-menu="true" tabindex="-1">'+
							'</select><div style="display: none;" id="level-listbox-placeholder"></div></div>'+
							'<div class="col_cv_alt" data-error="proficiency"></div>'+
					  '<label for="others">其他语言：</label>'+
					  		'<div class="ui-select"><select id="language" data-native-menu="true" tabindex="-1"></select>'+
							'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input id="language_others" type="text" name="others" style="display:none;"/></div><div style="display: none;" id="others-listbox-placeholder"></div></div>'+
							'<div class="col_cv_alt" data-error="others"></div>'+
					'</div>'+
					'<div data-role="controlgroup" data-type="horizontal" align="center" class="ui-controlgroup ui-controlgroup-horizontal ui-corner-all"><div class="ui-controlgroup-controls ">'+
						'<a data-role="button" href="#" data-icon="check" style="margin-left:10px;" onclick="save($(this))" url="wechatResume/saveForeignLanguage" class="ui-link ui-btn ui-icon-check ui-btn-icon-left ui-shadow ui-corner-all ui-first-child" role="button">保存</a>'+
						'<a data-role="button" href="#" data-icon="minus" style="margin-left:10px;" onclick="dele($(this))" url="wechatResume/deleteForeignLanguage" class="ui-link ui-btn ui-icon-minus ui-btn-icon-left ui-shadow ui-corner-all ui-last-child" role="button">删除</a>'+
					'</div></div>'+                     
					'</form>'+ 
					'</div></fieldset>';


H.award = '<fieldset class=" ui-controlgroup ui-controlgroup-vertical ui-corner-all" data-role="controlgroup" style="border:solid #ddd 3px;border-radius:10px;padding: 0 15px 15px 15px;"><div class="ui-controlgroup-controls ">'+ 
			    '<form method="post">'+ 
			'<input type="hidden" name="resumeId">'+
			'<input type="hidden" name="recruitType">'+ 
			'<input type="hidden" name="id">'+ 
			'<div data-role="fieldcontain" class="ui-field-contain">'+ 
			  '<label for="name"><font color="red">* </font>奖励名称:</label>'+ 
			  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="text" name="name" id="name"></div>'+
			  		'<div class="col_cv_alt" data-error="name"></div>'+
			  '<label for="time"><font color="red">* </font>获得时间:</label>'+ 
			  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="date" name="time" id="time"></div>'+
			  		'<div class="col_cv_alt" data-error="time"></div>'+
			  '<label for="level"><font color="red">* </font>级别:</label>'+ 
			  		'<div class="ui-select"><select name="level" id="awardLevel" data-native-menu="true" tabindex="-1">'+ 
					'</select><div style="display: none;" id="level-listbox-placeholder"></div></div>'+
					'<div class="col_cv_alt" data-error="level"></div>'+
			  '<label for="description"><font color="red">* </font>奖励描述:</label>'+ 
			      	'<textarea name="description" id="description" placeholder="" class="ui-input-text ui-shadow-inset ui-body-inherit ui-corner-all ui-textinput-autogrow"></textarea>'+
			      	'<div class="col_cv_alt" data-error="description"></div>'+
			'</div>'+ 
			'<div data-role="controlgroup" data-type="horizontal" align="center" class="ui-controlgroup ui-controlgroup-horizontal ui-corner-all"><div class="ui-controlgroup-controls ">'+ 
				'<a data-role="button" href="#" data-icon="check" style="margin-left:10px;" onclick="save($(this))" url="wechatResume/saveAward" class="ui-link ui-btn ui-icon-check ui-btn-icon-left ui-shadow ui-corner-all ui-first-child" role="button">保存</a>'+ 
				'<a data-role="button" href="#" data-icon="minus" style="margin-left:10px;" onclick="dele($(this))" url="wechatResume/deleteAward" class="ui-link ui-btn ui-icon-minus ui-btn-icon-left ui-shadow ui-corner-all ui-last-child" role="button">删除</a>'+ 
			'</div></div>'+ 
			'</form>'+ 
			'</div></fieldset>';

H.studentCadre = '<fieldset class=" ui-controlgroup ui-controlgroup-vertical ui-corner-all" data-role="controlgroup" style="border:solid #ddd 3px;border-radius:10px;padding: 0 15px 15px 15px;"><div class="ui-controlgroup-controls ">'+                
					    '<form method="post">'+
					'<input type="hidden" name="resumeId">'+
					'<input type="hidden" name="recruitType">'+
					'<input type="hidden" name="id">'+
					'<div data-role="fieldcontain" class="ui-field-contain">'+
					  '<label for="name">职务：</label>'+
					  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="text" name="name" id="name"></div>'+
					  		'<div class="col_cv_alt" data-error="name"></div>'+
					  '<label for="level">级别：</label>'+
					  		'<div class="ui-select"><select name="level" id="cadreLevel" data-native-menu="true" tabindex="-1">'+
							'</select><div style="display: none;" id="level-listbox-placeholder"></div></div>'+
							'<div class="col_cv_alt" data-error="level"></div>'+
					  '<label for="beginDate">开始时间：</label>'+
					  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="date" name="beginDate" id="beginDate"></div>'+
					  		'<div class="col_cv_alt" data-error="beginDate"></div>'+
					  '<label for="endDate">结束时间：</label>'+
					  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="date" name="endDate" id="endDate"></div>'+
					  		'<div class="col_cv_alt" data-error="endDate"></div>'+
					  '<label for="description">职责描述：</label>'+
						  	'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="text" name="description" id="description"></div>'+
						  	'<div class="col_cv_alt" data-error="description"></div>'+
					'</div>'+
					'<div data-role="controlgroup" data-type="horizontal" align="center" class="ui-controlgroup ui-controlgroup-horizontal ui-corner-all"><div class="ui-controlgroup-controls ">'+
						'<a data-role="button" href="#" data-icon="check" style="margin-left:10px;" onclick="save($(this))" url="wechatResume/saveStudentCadre" class="ui-link ui-btn ui-icon-check ui-btn-icon-left ui-shadow ui-corner-all ui-first-child" role="button">保存</a>'+
						'<a data-role="button" href="#" data-icon="minus" style="margin-left:10px;" onclick="dele($(this))" url="wechatResume/deleteStudentCadre" class="ui-link ui-btn ui-icon-minus ui-btn-icon-left ui-shadow ui-corner-all ui-last-child" role="button">删除</a>'+
					'</div></div>'+
					'</form>'+  
					'</div></fieldset>';

H.work = '<fieldset class=" ui-controlgroup ui-controlgroup-vertical ui-corner-all" data-role="controlgroup" style="border:solid #ddd 3px;border-radius:10px;padding: 0 15px 15px 15px;"><div class="ui-controlgroup-controls ">'+                
			     '<form method="post">'+  
			'<div data-role="fieldcontain" class="ui-field-contain">'+  
			  '<input type="hidden" name="resumeId">'+
			  '<input type="hidden" name="recruitType">'+  
			  '<input type="hidden" name="id">'+  
			  '<label for="company"><font color="red">* </font>单位名称:</label>'+  
			  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="text" name="company" id="company"></div>'+
			  		'<div class="col_cv_alt" data-error="company"></div>'+
			  '<label for="annualSalary"><font color="red">* </font>年薪 :</label>'+  
			  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="text" name="annualSalary" id="annualSalary"></div>'+
			  		'<div class="col_cv_alt" data-error="annualSalary"></div>'+
			  '<label for="department"><font color="red">* </font>部门名称:</label>'+  
			  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="text" name="department" id="department"></div>'+
			  		'<div class="col_cv_alt" data-error="department"></div>'+
			  '<label for="job"><font color="red">* </font>职位:</label>'+  
			  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="text" name="job" id="job"></div>'+
			  		'<div class="col_cv_alt" data-error="job"></div>'+
			  '<label for="workPlace"><font color="red">* </font>工作地点:</label>'+  
			  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="text" name="workPlace" id="workPlace"></div>'+
			  		'<div class="col_cv_alt" data-error="workPlace"></div>'+
			  '<label for="jobType"><font color="red">* </font>职位类型:</label>'+  
			  		'<div class="ui-select"><select name="jobType" id="jobType" data-native-menu="true" tabindex="-1">'+  
					'</select><div style="display: none;" id="jobType-listbox-placeholder"></div></div>'+
					'<div class="col_cv_alt" data-error="jobType"></div>'+
			  '<label for="industry"><font color="red">* </font>行业:</label>'+  
				  	'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="text" name="industry" id="industry"></div>'+
				  	'<div class="col_cv_alt" data-error="industry"></div>'+
			  '<label for="beginDate"><font color="red">* </font>开始时间:</label>'+  
			  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="date" name="beginDate" id="beginDate"></div>'+
			  		'<div class="col_cv_alt" data-error="beginDate"></div>'+
			  '<label for="endDate">结束时间:</label>'+  
			  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="date" name="endDate" id="endDate"></div>'+
			  		'<div class="col_cv_alt" data-error="endDate"></div>'+
			  '<label for="dimissionReason"><font color="red">* </font>离职原因:</label>'+  
			      	'<textarea name="dimissionReason" id="dimissionReason" placeholder="" class="ui-input-text ui-shadow-inset ui-body-inherit ui-corner-all ui-textinput-autogrow"></textarea>'+
			      	'<div class="col_cv_alt" data-error="dimissionReason"></div>'+
			  '<label for="duty"><font color="red">* </font>职责描述:</label>'+  
			      	'<textarea name="duty" id="duty" placeholder="" class="ui-input-text ui-shadow-inset ui-body-inherit ui-corner-all ui-textinput-autogrow"></textarea>'+
			      	'<div class="col_cv_alt" data-error="duty"></div>'+
			  '<label for="performance"><font color="red">* </font>工作业绩:</label>'+  
			      	'<textarea name="performance" id="performance" placeholder="" class="ui-input-text ui-shadow-inset ui-body-inherit ui-corner-all ui-textinput-autogrow"></textarea>'+  
			      	'<div class="col_cv_alt" data-error="performance"></div>'+
			'</div>'+  
			'<div data-role="controlgroup" data-type="horizontal" align="center" class="ui-controlgroup ui-controlgroup-horizontal ui-corner-all"><div class="ui-controlgroup-controls ">'+  
			    '<a data-role="button" href="#" data-icon="check" style="margin-left:10px;" onclick="save($(this))" url="wechatResume/saveWork" class="ui-link ui-btn ui-icon-check ui-btn-icon-left ui-shadow ui-corner-all ui-first-child" role="button">保存</a>'+  
			    '<a data-role="button" href="#" data-icon="minus" style="margin-left:10px;" onclick="dele($(this))" url="wechatResume/deleteWork" class="ui-link ui-btn ui-icon-minus ui-btn-icon-left ui-shadow ui-corner-all ui-last-child" role="button">删除</a>'+  
			'</div></div>'+  
			'</form>'+  
			'</div></fieldset>';

H.education = '<fieldset class=" ui-controlgroup ui-controlgroup-vertical ui-corner-all" data-role="controlgroup" style="border:solid #ddd 3px;border-radius:10px;padding: 0 15px 15px 15px;"><div class="ui-controlgroup-controls ">'+                
				       '<form method="post">'+
				'<div data-role="fieldcontain" class="ui-field-contain">'+
				  '<input type="hidden" name="resumeId">'+
				  '<input type="hidden" name="recruitType">'+
				  '<input type="hidden" name="id">'+
				  '<label for="schoolName"><font color="red">* </font>学校名称:</label>'+
				  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="text" name="schoolName" id="schoolName"></div>'+
				  		'<div class="col_cv_alt" data-error="schoolName"></div>'+
				  '<label for="major"><font color="red">* </font>所学专业 :</label>'+
				  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="text" name="major" id="major"></div>'+
				  		'<div class="col_cv_alt" data-error="major"></div>'+
				  '<label for="graduateType"><font color="red">* </font>毕业方式:</label>'+
				  		'<div class="ui-select"><select name="graduateType" id="graduateType" data-native-menu="true">'+
						'</select></div>'+
						'<div class="col_cv_alt" data-error="graduateType"></div>'+
				  '<label for="degree"><font color="red">* </font>学位:</label>'+
				  		'<div class="ui-select"><select name="degree" id="degree" data-native-menu="true" tabindex="-1">'+
						'</select><div style="display: none;" id="degree-listbox-placeholder"></div></div>'+
						'<div class="col_cv_alt" data-error="degree"></div>'+
				  '<label for="education"><font color="red">* </font>学历:</label>'+
				  		'<div class="ui-select"><select name="education" id="education" data-native-menu="true" tabindex="-1">'+
						'</select><div style="display: none;" id="education-listbox-placeholder"></div></div>'+
						'<div class="col_cv_alt" data-error="education"></div>'+
				  '<label for="learnType"><font color="red">* </font>学习形式:</label>'+
				  		'<div class="ui-select"><select name="learnType" id="learnType" data-native-menu="true" tabindex="-1">'+
						'</select><div style="display: none;" id="learnType-listbox-placeholder"></div></div>'+
						'<div class="col_cv_alt" data-error="learnType"></div>'+ 
				  '<label for="beginDate"><font color="red">* </font>开始时间:</label>'+
				  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="date" name="beginDate" id="beginDate"></div>'+
				  		'<div class="col_cv_alt" data-error="beginDate"></div>'+ 
				  '<label for="endDate"><font color="red">* </font>结束时间:</label>'+
				  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="date" name="endDate" id="endDate"></div>'+
				  		'<div class="col_cv_alt" data-error="endDate"></div>'+ 
				  '<label for="schoolType"><font color="red">* </font>学校类别:</label>'+
				  		'<div class="ui-select"><select name="schoolType" id="schoolType" data-native-menu="true" tabindex="-1">'+
						'</select><div style="display: none;" id="schoolType-listbox-placeholder"></div></div>'+
						'<div class="col_cv_alt" data-error="schoolType"></div>'+ 
				'<div class="CampusAndTrainee">'+
				  '<label for="hasBeenCadre"><font color="red">* </font>是否担任过学生干部:</label>'+
				  		//'<div class="ui-select"><select name="hasBeenCadre" id="YesOrNo" data-native-menu="true" tabindex="-1">'+
						//'</select><div style="display: none;" id="hasBeenCadre-listbox-placeholder"></div></div>'+
				    	'<input type="radio" data-role="none" name="hasBeenCadre" id="t" value="true">'+
				          '是     '+
				        '<input type="radio" data-role="none" name="hasBeenCadre" id="f" value="false">'+
				          '否'+	
				        '<div class="col_cv_alt" data-error="hasBeenCadre"></div>'+ 
				  '<label for="gradeRank"><font color="red">* </font>年级排名:</label>'+
				  		'<div class="ui-select"><select name="gradeRank" id="gradeRank" data-native-menu="true" tabindex="-1">'+
						'</select><div style="display: none;" id="gradeRank-listbox-placeholder"></div></div>'+
						'<div class="col_cv_alt" data-error="gradeRank"></div>'+ 
				'</div>'+
				'</div>'+
				'<div data-role="controlgroup" data-type="horizontal" align="center" class="ui-controlgroup ui-controlgroup-horizontal ui-corner-all"><div class="ui-controlgroup-controls ">'+
				    '<a data-role="button" href="#" data-icon="check" style="margin-left:10px;" onclick="save($(this))" url="wechatResume/saveEducation" class="ui-link ui-btn ui-icon-check ui-btn-icon-left ui-shadow ui-corner-all ui-first-child" role="button">保存</a>'+
				    '<a data-role="button" href="#" data-icon="minus" style="margin-left:10px;" onclick="dele($(this))" url="wechatResume/deleteEducation" class="ui-link ui-btn ui-icon-minus ui-btn-icon-left ui-shadow ui-corner-all ui-last-child" role="button">删除</a>'+
				'</div></div>'+
				'</form>'+  
				'</div></fieldset>' ;

H.practice= '<fieldset class="ui-controlgroup ui-controlgroup-vertical ui-corner-all" data-role="controlgroup" style="border:solid #ddd 3px;border-radius:10px;padding: 0 15px 15px 15px;"><div class="ui-controlgroup-controls ">'+ 
				    '<form method="post">'+
				'<div data-role="fieldcontain" class="ui-field-contain">'+
				    '<input type="hidden" name="resumeId">'+
					'<input type="hidden" name="recruitType">'+
				    '<input type="hidden" name="id">'+ 
					'<label for="name"><font color="red">* </font>活动/公司名称:</label>'+ 
							'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="text" name="name" id="name"></div>'+ 
							'<div class="col_cv_alt" data-error="name"></div>'+ 
					'<label for="job"><font color="red">* </font>职位:</label>'+ 
							'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="text" name="job" id="job"></div>'+ 
							'<div class="col_cv_alt" data-error="job"></div>'+ 
					'<label for="beginDate"><font color="red">* </font>开始时间:</label>'+ 
							'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="date" name="beginDate" id="beginDate"></div>'+ 
							'<div class="col_cv_alt" data-error="beginDate"></div> '+ 
					'<label for="endDate"><font color="red">* </font>结束时间:</label>'+ 
							'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="date" name="endDate" id="endDate"></div>'+ 
							'<div class="col_cv_alt" data-error="endDate"></div> '+ 
					'<label for="duty"><font color="red">* </font>职责描述:</label>'+ 
							'<textarea name="duty" id="duty" class="ui-input-text ui-shadow-inset ui-body-inherit ui-corner-all ui-textinput-autogrow" style="height: 52px;"></textarea>'+ 
							'<div class="col_cv_alt" data-error="duty"></div>'+ 
				'</div>'+
				'<div data-role="controlgroup" data-type="horizontal" align="center" class="ui-controlgroup ui-controlgroup-horizontal ui-corner-all"><div class="ui-controlgroup-controls ">'+ 
					 	'<a data-role="button" href="#" data-icon="check" style="margin-left:10px;" onclick="save($(this))" url="wechatResume/savePractice" class="ui-link ui-btn ui-icon-check ui-btn-icon-left ui-shadow ui-corner-all ui-first-child" role="button">保存</a>'+ 
					 	'<a data-role="button" href="#" data-icon="minus" style="margin-left:10px;" onclick="dele($(this))" url="wechatResume/deletePractice" class="ui-link ui-btn ui-icon-minus ui-btn-icon-left ui-shadow ui-corner-all ui-last-child" role="button">删除</a>'+ 
				'</div></div>'+ 		  
				'</form>'+   		
				'</div></fieldset>';


H.train='<fieldset class="ui-controlgroup ui-controlgroup-vertical ui-corner-all" data-role="controlgroup" style="border:solid #ddd 3px;border-radius:10px;padding: 0 15px 15px 15px;"><div class="ui-controlgroup-controls ">'+
    		'<form method="post">'+
			'<div data-role="fieldcontain" class="ui-field-contain">'+
			    '<input type="hidden" name="resumeId">'+
				'<input type="hidden" name="recruitType">'+
			    '<input type="hidden" name="id">'+                 
				'<label for="beginDate">开始时间:</label>'+
						'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="date" name="beginDate" id="beginDate"></div>'+
						'<div class="col_cv_alt" data-error="beginDate"></div>'+
				'<label for="endDate">结束时间:</label>'+
						'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="date" name="endDate" id="endDate"></div>'+
						'<div class="col_cv_alt" data-error="endDate"></div>'+
				'<label for="company">培训机构:</label>'+
						'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="text" name="company" id="company"></div>'+
						'<div class="col_cv_alt" data-error="company"></div>'+ 
				'<label for="place">培训地点:</label>'+
						'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="text" name="place" id="place"></div>'+
						'<div class="col_cv_alt" data-error="place"></div>'+ 
				'<label for="course">培训课程:</label>'+
						'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="text" name="course" id="course"></div>'+
						'<div class="col_cv_alt" data-error="course"></div>'+ 
				'<label for="description">详细描述:</label>'+
						'<textarea name="description" id="description" class="ui-input-text ui-shadow-inset ui-body-inherit ui-corner-all ui-textinput-autogrow" style="height: 52px;"></textarea>'+
						'<div class="col_cv_alt" data-error="description"></div>'+  
			'</div>'+
			    '<div data-role="controlgroup" data-type="horizontal" align="center" class="ui-controlgroup ui-controlgroup-horizontal ui-corner-all"><div class="ui-controlgroup-controls ">'+
					'<a data-role="button" href="#" data-icon="check" style="margin-left:10px;" onclick="save($(this))" url="wechatResume/saveTrain" class="ui-link ui-btn ui-icon-check ui-btn-icon-left ui-shadow ui-corner-all ui-first-child" role="button">保存</a>'+
					'<a data-role="button" href="#" data-icon="minus" style="margin-left:10px;" onclick="dele($(this))" url="wechatResume/deleteTrain" class="ui-link ui-btn ui-icon-minus ui-btn-icon-left ui-shadow ui-corner-all ui-last-child" role="button">删除</a>'+
				'</div></div>'+	                      		                     		
			'</form>'+   		
		'</div></fieldset>';


