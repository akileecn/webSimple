//应用路径
var baseUrl="/web/" ;
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


/*   --------简历附属信息模板---------  */
var H = {};
//家庭信息表单
H.family = '<fieldset class="ui-controlgroup ui-controlgroup-vertical ui-corner-all" data-role="controlgroup" style="border:solid #ddd 3px;border-radius:10px;padding:10px 10px;"><div class="ui-controlgroup-controls ">'+
				'<form method="post">'+
				  '<div data-role="fieldcontain" class="ui-field-contain">'+
				  '<input type="hidden" name="resumeId">'+
				  '<input type="hidden" name="id">'+
				  '<label for="name">姓名：</label>'+
				  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="text" name="name" id="name"></div>'+
				  '<label for="relationship">关系：</label>'+
							'<div class="ui-select"><select name="relationship" id="relationship" data-native-menu="true" tabindex="-1"></select><div style="display: none;" id="relationship-listbox-placeholder"></div></div>'+
				  '<label for="workCompany">工作单位：</label>'+
				  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="text" name="workCompany" id="workCompany"></div>'+
				  '<label for="workJob">职位：</label>'+
				  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="text" name="workJob" id="workJob"></div>'+
				  '<label for="description">说明：</label>'+
				  		'<textarea name="description" id="description" placeholder="不超过300字" class="ui-input-text ui-shadow-inset ui-body-inherit ui-corner-all ui-textinput-autogrow"></textarea>'+
				'</div>'+
				'<div data-role="controlgroup" data-type="horizontal" align="center" class="ui-controlgroup ui-controlgroup-horizontal ui-corner-all"><div class="ui-controlgroup-controls ">'+
					'<a data-role="button" href="#" data-icon="check" style="margin-left:10px;" onclick="save($(this))" url="wechatResume/saveFamily" class="ui-link ui-btn ui-icon-check ui-btn-icon-left ui-shadow ui-corner-all ui-first-child" role="button">保存</a>'+
					'<a data-role="button" href="#" data-icon="minus" style="margin-left:10px;" onclick="dele($(this))" url="wechatResume/deleteFamily" class="ui-link ui-btn ui-icon-minus ui-btn-icon-left ui-shadow ui-corner-all ui-last-child" role="button">删除</a>'+
				'</div></div>'+
				'</form>'+
				'</div></fieldset>';


H.computer = '<fieldset class=" ui-controlgroup ui-controlgroup-vertical ui-corner-all" data-role="controlgroup" style="border:solid #ddd 3px;border-radius:10px;padding:10px 10px;"><div class="ui-controlgroup-controls ">'+
	                '<form method="post">'+
                        '<input type="hidden" name="resumeId">'+
	                    '<input type="hidden" name="id">'+
	                    '<div data-role="fieldcontain" class="ui-field-contain">'+
	                      '<label for="certificate">证书名称：</label>'+
	                      		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="text" name="certificate" id="certificate"></div>'+
	                      '<label for="obtainDate">取得时间：</label>'+
	                      		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="date" name="obtainDate" id="obtainDate"></div>'+
	                      '<label for="level">掌握程度：</label>'+
	                      		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="text" name="level" id="level"></div>'+
	                      '<label for="detail">详细说明：</label>'+
		                        '<textarea name="detail" id="detail" placeholder="不超过300字" class="ui-input-text ui-shadow-inset ui-body-inherit ui-corner-all ui-textinput-autogrow"></textarea>'+
	                    '</div>'+
	                    '<div data-role="controlgroup" data-type="horizontal" align="center" class="ui-controlgroup ui-controlgroup-horizontal ui-corner-all"><div class="ui-controlgroup-controls ">'+
	                    	'<a data-role="button" href="#" data-icon="check" style="margin-left:10px;" onclick="save($(this))" url="wechatResume/saveComputer" class="ui-link ui-btn ui-icon-check ui-btn-icon-left ui-shadow ui-corner-all ui-first-child" role="button">保存</a>'+
	                    	'<a data-role="button" href="#" data-icon="minus" style="margin-left:10px;" onclick="dele($(this))" url="wechatResume/deleteComputer" class="ui-link ui-btn ui-icon-minus ui-btn-icon-left ui-shadow ui-corner-all ui-last-child" role="button">删除</a>'+
	                	'</div></div>'+ 
	                '</form>'+
	            '</div></fieldset>';


H.foreignLanguage = '<fieldset class=" ui-controlgroup ui-controlgroup-vertical ui-corner-all" data-role="controlgroup" style="border:solid #ddd 3px;border-radius:10px;padding:10px 10px;"><div class="ui-controlgroup-controls ">'+
					    '<form method="post">'+
					'<input type="hidden" name="resumeId">'+
					'<input type="hidden" name="id">'+
					'<div data-role="fieldcontain" class="ui-field-contain">'+
					  '<label for="level">英语等级：</label>'+
					  		'<div class="ui-select"><select name="level" id="languageLevel" data-native-menu="true" tabindex="-1">'+
							'</select><div style="display: none;" id="level-listbox-placeholder"></div></div>'+
					  '<label for="score">英语分数：</label>'+
					  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="text" name="score" id="score"></div>'+
					  '<label for="speaking">英语口语：</label>'+
					  		'<div class="ui-select"><select name="speaking" id="languageProficiency" data-native-menu="true" tabindex="-1">'+
							'</select><div style="display: none;" id="speaking-listbox-placeholder"><!-- placeholder for speaking-listbox --></div></div>'+
					  '<label for="others">其他语言：</label>'+
					  		'<div class="ui-select"><select name="others" id="language" data-native-menu="true" tabindex="-1">'+
							'</select><div style="display: none;" id="others-listbox-placeholder"><!-- placeholder for others-listbox --></div></div>'+
					'</div>'+
					'<div data-role="controlgroup" data-type="horizontal" align="center" class="ui-controlgroup ui-controlgroup-horizontal ui-corner-all"><div class="ui-controlgroup-controls ">'+
						'<a data-role="button" href="#" data-icon="check" style="margin-left:10px;" onclick="save($(this))" url="wechatResume/saveForeignLanguage" class="ui-link ui-btn ui-icon-check ui-btn-icon-left ui-shadow ui-corner-all ui-first-child" role="button">保存</a>'+
						'<a data-role="button" href="#" data-icon="minus" style="margin-left:10px;" onclick="dele($(this))" url="wechatResume/deleteForeignLanguage" class="ui-link ui-btn ui-icon-minus ui-btn-icon-left ui-shadow ui-corner-all ui-last-child" role="button">删除</a>'+
					'</div></div>'+                     
					'</form>'+ 
					'</div></fieldset>';


H.award = '<fieldset class=" ui-controlgroup ui-controlgroup-vertical ui-corner-all" data-role="controlgroup" style="border:solid #ddd 3px;border-radius:10px;padding:10px 10px;"><div class="ui-controlgroup-controls ">'+ 
			    '<form method="post">'+ 
			'<input type="hidden" name="resumeId">'+ 
			'<input type="hidden" name="id">'+ 
			'<div data-role="fieldcontain" class="ui-field-contain">'+ 
			  '<label for="name">奖励名称：</label>'+ 
			  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="text" name="name" id="name"></div>'+ 
			  '<label for="time">获得时间：</label>'+ 
			  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="date" name="time" id="time"></div>'+ 
			  '<label for="level">级别：</label>'+ 
			  		'<div class="ui-select"><select name="level" id="awardLevel" data-native-menu="true" tabindex="-1">'+ 
					'</select><div style="display: none;" id="level-listbox-placeholder"><!-- placeholder for level-listbox --></div></div>'+ 
			  '<label for="description">奖励描述：</label>'+ 
			      	'<textarea name="description" id="description" placeholder="不超过300字" class="ui-input-text ui-shadow-inset ui-body-inherit ui-corner-all ui-textinput-autogrow"></textarea>'+ 
			'</div>'+ 
			'<div data-role="controlgroup" data-type="horizontal" align="center" class="ui-controlgroup ui-controlgroup-horizontal ui-corner-all"><div class="ui-controlgroup-controls ">'+ 
				'<a data-role="button" href="#" data-icon="check" style="margin-left:10px;" onclick="save($(this))" url="wechatResume/saveAward" class="ui-link ui-btn ui-icon-check ui-btn-icon-left ui-shadow ui-corner-all ui-first-child" role="button">保存</a>'+ 
				'<a data-role="button" href="#" data-icon="minus" style="margin-left:10px;" onclick="dele($(this))" url="wechatResume/deleteAward" class="ui-link ui-btn ui-icon-minus ui-btn-icon-left ui-shadow ui-corner-all ui-last-child" role="button">删除</a>'+ 
			'</div></div>'+ 
			'</form>'+ 
			'</div></fieldset>';

H.studentCadre = '<fieldset class=" ui-controlgroup ui-controlgroup-vertical ui-corner-all" data-role="controlgroup" style="border:solid #ddd 3px;border-radius:10px;padding:10px 10px;"><div class="ui-controlgroup-controls ">'+                
					    '<form method="post">'+
					'<input type="hidden" name="resumeId">'+
					'<input type="hidden" name="id">'+
					'<div data-role="fieldcontain" class="ui-field-contain">'+
					  '<label for="beginDate">开始时间：</label>'+
					  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="date" name="beginDate" id="beginDate"></div>'+
					  '<label for="endDate">结束时间：</label>'+
					  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="date" name="endDate" id="endDate"></div>'+
					  '<label for="lname">所在院校：</label>'+
					  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="text" name="school" id="school"></div>'+
					  '<label for="name">学生干部名称：</label>'+
					  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="text" name="name" id="name"></div>'+
					  '<label for="level">学生干部级别：</label>'+
					  		'<div class="ui-select"><select name="level" id="level" data-native-menu="true" tabindex="-1">'+
							'</select><div style="display: none;" id="level-listbox-placeholder"></div></div>'+
					  '<label for="certifier">证明人：</label>'+
					  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="text" name="certifier" id="certifier"></div>'+
					  '<label for="certifierMobile">证明人联系方式：</label>'+
					  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="text" name="certifierMobile" id="certifierMobile"></div>'+
					'</div>'+
					'<div data-role="controlgroup" data-type="horizontal" align="center" class="ui-controlgroup ui-controlgroup-horizontal ui-corner-all"><div class="ui-controlgroup-controls ">'+
						'<a data-role="button" href="#" data-icon="check" style="margin-left:10px;" onclick="save($(this))" url="wechatResume/saveStudentCadre" class="ui-link ui-btn ui-icon-check ui-btn-icon-left ui-shadow ui-corner-all ui-first-child" role="button">保存</a>'+
						'<a data-role="button" href="#" data-icon="minus" style="margin-left:10px;" onclick="dele($(this))" url="wechatResume/deleteStudentCadre" class="ui-link ui-btn ui-icon-minus ui-btn-icon-left ui-shadow ui-corner-all ui-last-child" role="button">删除</a>'+
					'</div></div>'+
					'</form>'+  
					'</div></fieldset>';

H.work = '<fieldset class=" ui-controlgroup ui-controlgroup-vertical ui-corner-all" data-role="controlgroup" style="border:solid #ddd 3px;border-radius:10px;padding:10px 10px;"><div class="ui-controlgroup-controls ">'+                
			     '<form method="post">'+  
			'<div data-role="fieldcontain" class="ui-field-contain">'+  
			  '<input type="hidden" name="resumeId">'+  
			  '<input type="hidden" name="id">'+  
			  '<label for="company">单位名称<font color="red">*</font>:</label>'+  
			  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="text" name="company" id="company"></div>'+  
			  '<label for="annualSalary">年薪 ：</label>'+  
			  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="text" name="annualSalary" id="annualSalary"></div>'+  
			  '<label for="department">部门名称<font color="red">*</font>:</label>'+  
			  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="text" name="department" id="department"></div>'+  
			  '<label for="job">职位<font color="red">*</font>:</label>'+  
			  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="text" name="job" id="job"></div>'+  
			  '<label for="certifier">证明人<font color="red">*</font>:</label>'+  
			  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="text" name="certifier" id="certifier"></div>'+  
			  '<label for="certifierMobile">证明人电话<font color="red">*</font>:</label>'+  
			  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="text" name="certifierMobile" id="certifierMobile"></div>'+  
			  '<label for="workPlace">工作地点<font color="red">*</font>:</label>'+  
			  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="text" name="workPlace" id="workPlace"></div>'+  
			  '<label for="jobType">职位类型<font color="red">*</font>:</label>'+  
			  		'<div class="ui-select"><select name="jobType" id="jobType" data-native-menu="true" tabindex="-1">'+  
					'</select><div style="display: none;" id="jobType-listbox-placeholder"><!-- placeholder for jobType-listbox --></div></div>'+  
			  '<label for="beginDate">开始时间<font color="red">*</font>:</label>'+  
			  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="date" name="beginDate" id="beginDate"></div>'+  
			  '<label for="endDate">结束时间<font color="red">*</font>:</label>'+  
			  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="date" name="endDate" id="endDate"></div>'+  
			  '<label for="dimissionReason">离职原因：</label>'+  
			      	'<textarea name="dimissionReason" id="dimissionReason" placeholder="不超过300字" class="ui-input-text ui-shadow-inset ui-body-inherit ui-corner-all ui-textinput-autogrow"></textarea>'+  
			  '<label for="duty">职责描述<font color="red">*</font>:</label>'+  
			      	'<textarea name="duty" id="duty" placeholder="不超过300字" class="ui-input-text ui-shadow-inset ui-body-inherit ui-corner-all ui-textinput-autogrow"></textarea>'+  
			  '<label for="performance">工作业绩<font color="red">*</font>:</label>'+  
			      	'<textarea name="performance" id="performance" placeholder="不超过300字" class="ui-input-text ui-shadow-inset ui-body-inherit ui-corner-all ui-textinput-autogrow"></textarea>'+  
			'</div>'+  
			'<div data-role="controlgroup" data-type="horizontal" align="center" class="ui-controlgroup ui-controlgroup-horizontal ui-corner-all"><div class="ui-controlgroup-controls ">'+  
			    '<a data-role="button" href="#" data-icon="check" style="margin-left:10px;" onclick="save($(this))" url="wechatResume/saveWork" class="ui-link ui-btn ui-icon-check ui-btn-icon-left ui-shadow ui-corner-all ui-first-child" role="button">保存</a>'+  
			    '<a data-role="button" href="#" data-icon="minus" style="margin-left:10px;" onclick="dele($(this))" url="wechatResume/deleteWork" class="ui-link ui-btn ui-icon-minus ui-btn-icon-left ui-shadow ui-corner-all ui-last-child" role="button">删除</a>'+  
			'</div></div>'+  
			'</form>'+  
			'</div></fieldset>';

H.education = '<fieldset class=" ui-controlgroup ui-controlgroup-vertical ui-corner-all" data-role="controlgroup" style="border:solid #ddd 3px;border-radius:10px;padding:10px 10px;"><div class="ui-controlgroup-controls ">'+                
				       '<form method="post">'+
				'<div data-role="fieldcontain" class="ui-field-contain">'+
				  '<input type="hidden" name="resumeId">'+
				  '<input type="hidden" name="id">'+
				  '<label for="schoolName">学校名称：</label>'+
				  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="text" name="schoolName" id="schoolName"></div>'+
				  '<label for="major">所学专业 ：</label>'+
				  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="text" name="major" id="major"></div>'+
				  '<label for="graduateType">毕业方式：</label>'+
				  		'<div class="ui-select"><select name="graduateType" id="graduateType" data-native-menu="true">'+
						'</select></div></div>'+
				  '<label for="degree">所得学位：</label>'+
				  		'<div class="ui-select"><select name="degree" id="degree" data-native-menu="true" tabindex="-1">'+
						'</select><div style="display: none;" id="degree-listbox-placeholder"><!-- placeholder for degree-listbox --></div></div>'+
				  '<label for="education">学历等级：</label>'+
				  		'<div class="ui-select"><select name="education" id="education" data-native-menu="true" tabindex="-1">'+
						'</select><div style="display: none;" id="education-listbox-placeholder"><!-- placeholder for education-listbox --></div></div>'+
				  '<label for="learnType">学习形式：</label>'+
				  		'<div class="ui-select"><select name="learnType" id="learnType" data-native-menu="true" tabindex="-1">'+
						'</select><div style="display: none;" id="learnType-listbox-placeholder"><!-- placeholder for learnType-listbox --></div></div>'+
				  '<label for="beginDate">开始时间：</label>'+
				  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="date" name="beginDate" id="beginDate"></div>'+
				  '<label for="endDate">结束时间：</label>'+
				  		'<div class="ui-input-text ui-body-inherit ui-corner-all ui-shadow-inset"><input type="date" name="endDate" id="endDate"></div>'+
				  '<label for="schoolType">学校类别：</label>'+
				  		'<div class="ui-select"><select name="schoolType" id="schoolType" data-native-menu="true" tabindex="-1">'+
						'</select><div style="display: none;" id="schoolType-listbox-placeholder"><!-- placeholder for schoolType-listbox --></div></div>'+
				  '<label for="hasBeenCadre">是否担任过学生干部：</label>'+
				  		'<div class="ui-select"><select name="hasBeenCadre" id="hasBeenCadre" data-native-menu="true" tabindex="-1">'+
						          '<option value="" data-placeholder="true">请选择</option>'+
						          '<option value="1">是</option>'+
						          '<option value="0">否</option>'+
						'</select><div style="display: none;" id="hasBeenCadre-listbox-placeholder"><!-- placeholder for hasBeenCadre-listbox --></div></div>'+
				  '<label for="gradeRank">年级排名：</label>'+
				  		'<div class="ui-select"><select name="gradeRank" id="gradeRank" data-native-menu="true" tabindex="-1">'+
						'</select><div style="display: none;" id="gradeRank-listbox-placeholder"><!-- placeholder for gradeRank-listbox --></div></div>'+
				'</div>'+
				'<div data-role="controlgroup" data-type="horizontal" align="center" class="ui-controlgroup ui-controlgroup-horizontal ui-corner-all"><div class="ui-controlgroup-controls ">'+
				    '<a data-role="button" href="#" data-icon="check" style="margin-left:10px;" onclick="save($(this))" url="wechatResume/saveEducation" class="ui-link ui-btn ui-icon-check ui-btn-icon-left ui-shadow ui-corner-all ui-first-child" role="button">保存</a>'+
				    '<a data-role="button" href="#" data-icon="minus" style="margin-left:10px;" onclick="dele($(this))" url="wechatResume/deleteEducation" class="ui-link ui-btn ui-icon-minus ui-btn-icon-left ui-shadow ui-corner-all ui-last-child" role="button">删除</a>'+
				'</div></div>'+
				'</form>'+  
				'</div></fieldset>' ;

