package cn.aki.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.aki.entity.Application;
import cn.aki.response.DataResponse;
import cn.aki.service.ApplicationService;
/**
 * 应聘
 * @author Aki
 * 2016年5月30日 下午11:30:03
 */
@Controller
@RequestMapping("/application")
public class ApplicationController {
	@Autowired
	private ApplicationService applicationService;
	
	/**
	 * 我的应聘页面
	 */
	@RequestMapping(path="/list",method=RequestMethod.GET)
	public String toApplicationList(Application application,Model model){
		List<Application> list=applicationService.getList(application);
		model.addAttribute("list", list);
		return "application/list";
	}
	
	/**
	 * 投递简历
	 * @param application
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(path="/apply",method=RequestMethod.POST)
	public DataResponse<Application> handleApply(Application application,Model model){
		DataResponse<Application> response=applicationService.apply(application);
		return response;
	}
	
}
