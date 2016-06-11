package cn.aki.controller;

import java.util.HashMap;
import java.util.Map;

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
import cn.aki.entity.ResumeStudentCadre;
import cn.aki.entity.ResumeWork;
import cn.aki.entity.base.ResumeSubEntity;
import cn.aki.response.DataResponse;
import cn.aki.response.FormResponse;
import cn.aki.response.SimpleResponse;
import cn.aki.service.TranslateService;
import cn.aki.service.WechatResumeService;
import cn.aki.service.WechatResumeSubService;

@Controller
@RequestMapping("/wechatResume/")
public class WechatResumeController  extends BaseController{
	
	@Autowired
	WechatResumeService wechatResumeService ;
	@Autowired
	private WechatResumeSubService wechatResumeSubService;
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
		Resume data = wechatResumeService.getResume(resume,true);
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
	public FormResponse<Void> saveResumeBase(Resume form,BindingResult result){
		System.out.println("++++++++++++++++=================");
		FormResponse<Void> response=handleFormError(result);
		form.setUserId(0);
		if(response.isSuccess()){
			wechatResumeService.updateResume(form);
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
	public FormResponse<Integer> saveEducation(ResumeEducation form,BindingResult result){
		System.out.println("++++++++++++++++=================");
		form.setResumeId(1);
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
	public FormResponse<Integer> saveWork(ResumeWork form,BindingResult result){
		System.out.println("++++++++++++++++=================");
		form.setResumeId(1);
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
	public FormResponse<Integer> saveStudentCadre(ResumeStudentCadre form,BindingResult result){
		System.out.println("++++++++++++++++=================");
		form.setResumeId(1);
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
	public FormResponse<Integer> saveAward(ResumeAward form,BindingResult result){
		System.out.println("++++++++++++++++=================");
		form.setResumeId(1);
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
	public FormResponse<Integer> saveForeignLanguage(ResumeForeignLanguage form,BindingResult result){
		System.out.println("++++++++++++++++=================");
		form.setResumeId(1);
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
	public FormResponse<Integer> saveComputer(ResumeComputer form,BindingResult result){
		System.out.println("++++++++++++++++=================");
		form.setResumeId(1);
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
	public FormResponse<Integer> saveFamily(ResumeFamily form,BindingResult result){
		System.out.println("++++++++++++++++=================");
		form.setResumeId(1);
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
		System.out.println("delete family.........."+resumefamily.getId());
		resumefamily.setResumeId(1);
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
			wechatResumeSubService.saveOrUpdate(sub);
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
		wechatResumeSubService.delete(sub);
		response.setSuccess(true);
		return response;
	}
	/* end从属信息 */
	
}
