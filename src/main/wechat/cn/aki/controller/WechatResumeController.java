package cn.aki.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.aki.entity.Resume;
import cn.aki.entity.ResumeAward;
import cn.aki.entity.ResumeComputer;
import cn.aki.entity.ResumeEducation;
import cn.aki.entity.ResumeFamily;
import cn.aki.entity.ResumeForeignLanguage;
import cn.aki.entity.ResumePractice;
import cn.aki.entity.ResumeStudentCadre;
import cn.aki.entity.ResumeTrain;
import cn.aki.entity.ResumeWork;
import cn.aki.entity.base.ResumeSubEntity;
import cn.aki.response.DataResponse;
import cn.aki.response.FormResponse;
import cn.aki.response.SimpleResponse;
import cn.aki.service.ResumeService;
import cn.aki.service.ResumeSubService;
import cn.aki.service.TranslateService;
import cn.aki.service.WechatResumeService;
import cn.aki.service.WechatResumeSubService;
import cn.aki.utils.UserUtils;

@Controller
@RequestMapping("/wechatResume/")
public class WechatResumeController  extends BaseController{
	/*
	@Autowired
	WechatResumeService wechatResumeService ;
	@Autowired
	private WechatResumeSubService wechatResumeSubService;
	*/
	@Autowired
	private ResumeService resumeService;
	@Autowired
	private ResumeSubService resumeSubService;
	
	@Autowired
	TranslateService translateService ;
	
	String[] dictTypes = new String[]{"gender"
			,"nation"
			,"marriage"
			,"politicsStatus"
			,"workYear"
			,"workCity"
			,"health"
			,"graduateType"
			,"degree"
			,"education"
			,"learnType"
			,"schoolType"
			,"gradeRank"
			,"jobType"
			,"awardLevel"
			,"languageLevel"
			,"languageProficiency"
			,"language"
			,"relationship"
			,"artsOrScience"
			,"admissionOrder"
			,"recruitType"
			,"highestEducation"
};
	
	/**
	 * 
	 * 获取简历信息
	 * @param resume
	 * @return
	 */
	@ResponseBody
	@RequestMapping(path="getResume",method=RequestMethod.POST)
	public DataResponse<Map<String,Object>> getResume(Resume resume){
		DataResponse<Map<String,Object>> response = new DataResponse<Map<String,Object>>();
		Map<String,Object> map = new HashMap<String,Object>();
		
		Integer userid = UserUtils.getUserId();
		if("".equals(userid) || userid == null ){
			response.setMessage("noLogin");
			return response ;
		}
		resume.setUserId(userid);
		Resume data = resumeService.get(resume,true);
		map.put("resume", data);
		map.put("dicts",  translateService.findDicts(dictTypes));
		response.setData(map);
		return response ;
	}
	
	/**
	 * 
	 * 更新简历基本信息
	 * @param form
	 * @param result
	 * @return
	 */
	@ResponseBody
	@RequestMapping(path="updateResumeBase",method=RequestMethod.POST)
	public FormResponse<Void> saveResumeBase(@Valid Resume form,BindingResult result){
		FormResponse<Void> response=handleFormError(result);
		Integer userid = UserUtils.getUserId();
		if("".equals(userid) || userid == null ){
			response.setMessage("noLogin");
			return response;
		}
		
		if(response.isSuccess()){
			form.setUserId(userid);
			resumeService.update(form);
		}
		return response;
	}
	
	/******
	 * 
	 *   简历从属信息
	 * 
	 */
	
	/***
	 * 
	 * 教育经历
	 * @param form
	 * @param result
	 * @return
	 */
	
	
	@ResponseBody
	@RequestMapping(path="saveEducation",method=RequestMethod.POST)
	public FormResponse<Integer> saveEducation(@Valid ResumeEducation form,BindingResult result){
		return saveSub(form,result);
	}
	
	
	@ResponseBody
	@RequestMapping(path="deleteEducation",method=RequestMethod.POST)
	public SimpleResponse deleteEducation(ResumeEducation resumeeducation,BindingResult result){
		return deleteSub(resumeeducation) ;
	}	
	
	/***
	 * 
	 * 工作经历
	 * @param form
	 * @param result
	 * @return
	 */
	
	@ResponseBody
	@RequestMapping(path="saveWork",method=RequestMethod.POST)
	public FormResponse<Integer> saveWork(@Valid ResumeWork form,BindingResult result){
		return saveSub(form,result);
	}
	
	@ResponseBody
	@RequestMapping(path="deleteWork",method=RequestMethod.POST)
	public SimpleResponse deleteWork(ResumeWork resumeWork,BindingResult result){
		return deleteSub(resumeWork) ;
	}		
	
	/**
	 * 
	 * 学生干部信息
	 * @param form
	 * @param result
	 * @return
	 */
	
	@ResponseBody
	@RequestMapping(path="saveStudentCadre",method=RequestMethod.POST)
	public FormResponse<Integer> saveStudentCadre(@Valid ResumeStudentCadre form,BindingResult result){
		return saveSub(form,result);
	}
	
	@ResponseBody
	@RequestMapping(path="deleteStudentCadre",method=RequestMethod.POST)
	public SimpleResponse deleteStudentCadre(ResumeStudentCadre studentCadre,BindingResult result){
		return deleteSub(studentCadre) ;
	}	
	
	/**
	 * 
	 * 奖励信息
	 * @param form
	 * @param result
	 * @return
	 */
	@ResponseBody
	@RequestMapping(path="saveAward",method=RequestMethod.POST)	
	public FormResponse<Integer> saveAward(@Valid ResumeAward form,BindingResult result){
		return saveSub(form,result);
	}
	
	@ResponseBody
	@RequestMapping(path="deleteAward",method=RequestMethod.POST)
	public SimpleResponse deleteAward(ResumeAward studentAward,BindingResult result){
		return deleteSub(studentAward) ;
	}	
	
	
	
	/**
	 * 
	 * 外语情况
	 * @param form
	 * @param result
	 * @return
	 */
	
	@ResponseBody
	@RequestMapping(path="saveForeignLanguage",method=RequestMethod.POST)
	public FormResponse<Integer> saveForeignLanguage(@Valid ResumeForeignLanguage form,BindingResult result){
		return saveSub(form,result);
	}
	
	@ResponseBody
	@RequestMapping(path="deleteForeignLanguage",method=RequestMethod.POST)
	public SimpleResponse deleteForeignLanguage(ResumeForeignLanguage foreignLanguage,BindingResult result){
		return deleteSub(foreignLanguage) ;
	}		
	
	
	/***
	 * 
	 * 计算机
	 * @param form
	 * @param result
	 * @return
	 */
	
	@ResponseBody
	@RequestMapping(path="saveComputer",method=RequestMethod.POST)
	public FormResponse<Integer> saveComputer(@Valid ResumeComputer form,BindingResult result){
		return saveSub(form,result);
	}

	@ResponseBody
	@RequestMapping(path="deleteComputer",method=RequestMethod.POST)
	public SimpleResponse deleteComputer(ResumeComputer computer,BindingResult result){
		return deleteSub(computer) ;
	}	
	

	
	/****
	 * 
	 * 保存家庭信息
	 * @param form
	 * @param result
	 * @return
	 */
	
	@ResponseBody
	@RequestMapping(path="saveFamily",method=RequestMethod.POST)
	public FormResponse<Integer> saveFamily(@Valid ResumeFamily form,BindingResult result){
		return saveSub(form,result);
	}
	
	/***
	 * 
	 * 删除家庭信息
	 * @param resumefamily
	 * @param result
	 * @return
	 */
	@ResponseBody
	@RequestMapping(path="deleteFamily",method=RequestMethod.POST)
	public SimpleResponse deleteFamily(ResumeFamily resumefamily,BindingResult result){
		return deleteSub(resumefamily) ;
		
	}	
	
	
	
	/****
	 * 
	 * 保存实践活动信息
	 * @param form
	 * @param result
	 * @return
	 */
	
	@ResponseBody
	@RequestMapping(path="savePractice",method=RequestMethod.POST)
	public FormResponse<Integer> savePractice(@Valid ResumePractice form,BindingResult result){
		return saveSub(form,result);
	}
	
	/***
	 * 
	 * 删除实践活动信息
	 * @param resumefamily
	 * @param result
	 * @return
	 */
	@ResponseBody
	@RequestMapping(path="deletePractice",method=RequestMethod.POST)
	public SimpleResponse deletePractice(ResumePractice form,BindingResult result){
		return deleteSub(form) ;
		
	}	
		
	
	/****
	 * 
	 * 保存培训信息
	 * @param form
	 * @param result
	 * @return
	 */
	
	@ResponseBody
	@RequestMapping(path="saveTrain",method=RequestMethod.POST)
	public FormResponse<Integer> saveTrain(@Valid ResumeTrain form,BindingResult result){
		return saveSub(form,result);
	}
	
	/***
	 * 
	 * 删除培训信息
	 * @param resumefamily
	 * @param result
	 * @return Train
	 */
	@ResponseBody
	@RequestMapping(path="deleteTrain",method=RequestMethod.POST)
	public SimpleResponse deleteTrain(ResumeTrain resumefamily,BindingResult result){
		System.out.println("delete family.........."+resumefamily.getId());
		return deleteSub(resumefamily) ;
		
	}	
		
	
	
	/**
	 * 公共修改方法
	 * @param sub
	 * @param result
	 * @return
	 */
	private FormResponse<Integer> saveSub(ResumeSubEntity sub,BindingResult result){
		FormResponse<Integer> response=handleFormError(result);
		if(response.isSuccess()){
			resumeSubService.saveOrUpdate(sub);
			response.setData(sub.getId());
		}
		return response;
	}
	/**
	 * 公共删除方法
	 * @param sub
	 * @return
	 */
	private SimpleResponse deleteSub(ResumeSubEntity sub){
		SimpleResponse response=new SimpleResponse();
		resumeSubService.delete(sub);
		response.setSuccess(true);
		return response;
	}
	/* end从属信息 */
	
}
