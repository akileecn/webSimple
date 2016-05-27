package cn.aki.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
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
import cn.aki.form.ResumeAwardForm;
import cn.aki.form.ResumeComputerForm;
import cn.aki.form.ResumeEducationForm;
import cn.aki.form.ResumeFamilyForm;
import cn.aki.form.ResumeForeignLanguageForm;
import cn.aki.form.ResumeForm;
import cn.aki.form.ResumeStudentCadreForm;
import cn.aki.form.ResumeWorkForm;
import cn.aki.response.DataResponse;
import cn.aki.response.FormResponse;
import cn.aki.response.SimpleResponse;
import cn.aki.service.ResumeService;
import cn.aki.service.ResumeSubService;

/**
 * 简历
 * @author aki
 * 2016年4月29日 上午9:48:40
 */
@Controller
@RequestMapping("/resume")
public class ResumeController extends BaseController{
	@Autowired
	private ResumeService resumeService;
	@Autowired
	private ResumeSubService resumeSubService;
	
	@RequestMapping(path="/detail",method=GET)
	public String toDetail(Integer id,Model model){
		model.addAttribute("id", id);
		return "resume/detail";
	}
	
	@ResponseBody
	@RequestMapping(path="/save/base",method=POST)
	public FormResponse<Void> saveBase(@Valid ResumeForm form,BindingResult result){
		FormResponse<Void> response=handleFormError(result);
		if(response.isSuccess()){
			resumeService.update(form);
		}
		return response;
	}
	
	@ResponseBody
	@RequestMapping(path="/detail/all",method=POST)
	public DataResponse<Resume> handleDetail(Resume resume){
		DataResponse<Resume> response=new DataResponse<Resume>();
		resume=resumeService.get(resume,true);
		response.setData(resume);
		return response;
	}
	
	/* begin从属信息 */
	@ResponseBody
	@RequestMapping(path="/save/award",method=POST)
	public FormResponse<Integer> saveAward(ResumeAwardForm form,BindingResult result){
		return saveSub(form,result);
	}
	@ResponseBody
	@RequestMapping(path="/delete/award",method=POST)
	public SimpleResponse deleteAward(ResumeAward bean,BindingResult result){
		return deleteSub(bean);
	}
	@ResponseBody
	@RequestMapping(path="/save/computer",method=POST)
	public FormResponse<Integer> saveComputer(ResumeComputerForm form,BindingResult result){
		return saveSub(form,result);
	}
	@ResponseBody
	@RequestMapping(path="/delete/computer",method=POST)
	public SimpleResponse deleteComputer(ResumeComputer bean,BindingResult result){
		return deleteSub(bean);
	}
	@ResponseBody
	@RequestMapping(path="/save/education",method=POST)
	public FormResponse<Integer> saveEducation(ResumeEducationForm form,BindingResult result){
		return saveSub(form,result);
	}
	@ResponseBody
	@RequestMapping(path="/delete/education",method=POST)
	public SimpleResponse deleteEducation(ResumeEducation bean,BindingResult result){
		return deleteSub(bean);
	}
	@ResponseBody
	@RequestMapping(path="/save/family",method=POST)
	public FormResponse<Integer> saveFamily(ResumeFamilyForm form,BindingResult result){
		return saveSub(form,result);
	}
	@ResponseBody
	@RequestMapping(path="/delete/family",method=POST)
	public SimpleResponse deleteFamily(ResumeFamily bean,BindingResult result){
		return deleteSub(bean);
	}
	@ResponseBody
	@RequestMapping(path="/save/foreignLanguage",method=POST)
	public FormResponse<Integer> saveForeignLanguage(ResumeForeignLanguageForm form,BindingResult result){
		return saveSub(form,result);
	}
	@ResponseBody
	@RequestMapping(path="/delete/foreignLanguage",method=POST)
	public SimpleResponse deleteForeignLanguage(ResumeForeignLanguage bean,BindingResult result){
		return deleteSub(bean);
	}
	@ResponseBody
	@RequestMapping(path="/save/studentCadre",method=POST)
	public FormResponse<Integer> saveStudentCadre(ResumeStudentCadreForm form,BindingResult result){
		return saveSub(form,result);
	}
	@ResponseBody
	@RequestMapping(path="/delete/studentCadre",method=POST)
	public SimpleResponse deleteStudentCadre(ResumeStudentCadre bean,BindingResult result){
		return deleteSub(bean);
	}
	@ResponseBody
	@RequestMapping(path="/save/work",method=POST)
	public FormResponse<Integer> saveWork(ResumeWorkForm form,BindingResult result){
		return saveSub(form,result);
	}
	@ResponseBody
	@RequestMapping(path="/delete/work",method=POST)
	public SimpleResponse deleteWork(ResumeWork bean,BindingResult result){
		return deleteSub(bean);
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
