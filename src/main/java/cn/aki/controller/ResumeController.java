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
import cn.aki.entity.base.ResumeSubEntity;
import cn.aki.form.ResumeAwardForm;
import cn.aki.form.ResumeForm;
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
	public FormResponse saveBase(@Valid ResumeForm form,BindingResult result){
		FormResponse response=handleFormError(result);
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
	
	@ResponseBody
	@RequestMapping(path="/save/award",method=POST)
	public FormResponse saveAward(ResumeAwardForm award,BindingResult result){
		return saveSub(award,result);
	}
	
	@ResponseBody
	@RequestMapping(path="/delete/award",method=POST)
	public SimpleResponse deleteAward(ResumeAward award,BindingResult result){
		return deleteSub(award);
	}
	
	/**
	 * 公共修改方法
	 * @param sub
	 * @param result
	 * @return
	 */
	private FormResponse saveSub(ResumeSubEntity sub,BindingResult result){
		FormResponse response=handleFormError(result);
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
}
