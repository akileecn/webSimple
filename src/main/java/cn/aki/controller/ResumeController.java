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
import cn.aki.form.ResumeForm;
import cn.aki.response.FormResponse;
import cn.aki.response.Response;
import cn.aki.service.ResumeService;

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
	@RequestMapping(path="/detail/base",method=POST)
	public Response<Resume, Void> handleDetail(Integer id){
		Response<Resume, Void> response=new Response<Resume, Void>();
		Resume condition=new Resume();
		condition.setId(id);
		Resume resume=resumeService.get(condition);
		response.setData(resume);
		return response;
	}
	
}
