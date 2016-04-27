package cn.aki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.pagehelper.PageInfo;

import cn.aki.entity.Job;
import cn.aki.form.JobQueryForm;
import cn.aki.service.JobService;

@Controller
@RequestMapping("/job")
public class JobController {
	@Autowired
	private JobService jobService;
	
	@RequestMapping(path="/list",method={RequestMethod.GET,RequestMethod.POST})
	public String list(JobQueryForm form,Integer pageNum,Integer pageSize,Model model){
		PageInfo<Job> page=jobService.getPage(pageNum, pageSize,form);
		model.addAttribute("page", page);
		model.addAttribute("form", form);
		return "job/list";
	}
}
