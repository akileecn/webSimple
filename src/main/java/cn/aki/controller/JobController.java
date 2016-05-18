package cn.aki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import cn.aki.entity.Job;
import cn.aki.form.JobQueryForm;
import cn.aki.response.DataResponse;
import cn.aki.response.PageResponse;
import cn.aki.service.JobService;
/**
 * 岗位
 * @author aki
 * 2016年4月29日 上午9:49:04
 */
@Controller
@RequestMapping("/job")
public class JobController {
	@Autowired
	private JobService jobService;
	
	@RequestMapping(path="/list",method=RequestMethod.GET)
	public String toList(JobQueryForm form,Model model){
		return "job/list";
	}
	
	@ResponseBody
	@RequestMapping(path="/list",method=RequestMethod.POST)
	public PageResponse<Job> handleList(JobQueryForm form){
		PageInfo<Job> page=jobService.getPage(form);
		PageResponse<Job> response=new PageResponse<Job>();
		response.setData(page);
		return response;
	}
	
	@RequestMapping(path="/detail",method=RequestMethod.GET)
	public String toDetail(Integer id,Model model){
		Job job=jobService.get(id);
		model.addAttribute("job", job);
		return "job/detail";
	}
	
	@ResponseBody
	@RequestMapping(path="/detail",method=RequestMethod.POST)
	public DataResponse<Job> handleDetail(Integer id){
		DataResponse<Job> response=new DataResponse<Job>();
		Job job=jobService.get(id);
		response.setData(job);
		return response;
	}
}
