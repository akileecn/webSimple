package cn.aki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.aki.form.ResumeForm;
import cn.aki.response.FormResponse;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.validation.Valid;

/**
 * 简历
 * @author aki
 * 2016年4月29日 上午9:48:40
 */
@Controller
@RequestMapping("/resume")
public class ResumeController extends BaseController{
	
	@RequestMapping(path="/detail",method=GET)
	public String toDetail(Integer id){
		return "resume/detail";
	}
	
	@ResponseBody
	@RequestMapping(path="/save/base",method=POST)
	public FormResponse saveBase(@Valid ResumeForm form,BindingResult result){
		FormResponse response=handleFormError(result);
		System.err.println(form);
		if(response.isSuccess()){
			//TODO
		}
		return response;
	}
}
