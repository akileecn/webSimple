package cn.aki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.aki.service.JobService;

@Controller
@RequestMapping("/job")
public class JobController {
	@Autowired
	private JobService jobService;
	
	@RequestMapping(path="/list",method=RequestMethod.GET)
	public String list(Model model){
		model.addAttribute("list", jobService.getList());
		return "job/list";
	}
}
