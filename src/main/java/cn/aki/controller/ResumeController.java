package cn.aki.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.aki.entity.Resume;
import cn.aki.entity.ResumeAward;
import cn.aki.form.ResumeForm;
import cn.aki.response.DataResponse;
import cn.aki.response.FormResponse;
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
	@RequestMapping(path="/detail/base")
	public DataResponse<Resume> handleDetail(Resume resume){
		DataResponse<Resume> response=new DataResponse<Resume>();
		resume=resumeService.get(resume);
		response.setData(resume);
		return response;
	}
	
	@ResponseBody
	@RequestMapping(path="/detail/award")
	public DataResponse<List<ResumeAward>> handleDetailAward(ResumeAward award){
		DataResponse<List<ResumeAward>> response=new DataResponse<List<ResumeAward>>();
		List<ResumeAward> list=resumeSubService.getList(award);
		response.setData(list);
		return response;
	}
}
