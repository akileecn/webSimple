package cn.aki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import cn.aki.entity.Job;
import cn.aki.form.JobQueryForm;
import cn.aki.response.DataResponse;
import cn.aki.response.PageResponse;
import cn.aki.service.JobService;
import cn.aki.service.WechatJobService;

/*
 * 
 * 微信端岗位
 * 
 * */
@Controller
@RequestMapping("/wechatjob/")
public class WechatJobController {

	@Autowired
	WechatJobService wechatJobService ;
	
	
	/***
	 * 
	 * 获取岗位列表
	 * @param form
	 * @return
	 */
	@ResponseBody
	@RequestMapping(path="/list",method=RequestMethod.POST)
	public PageResponse<Job> getJobList(JobQueryForm form){
		System.out.println("++++++++++++++++++++++++"+form.getPageNum());
		System.out.println("++++++++++++++++++++++++"+form.getrecruitType());
		PageResponse<Job> response = new PageResponse<Job>();
		PageInfo<Job> joblist = wechatJobService.getPage(form);
		response.setData(joblist);
		System.out.println(response);
		System.out.println("========================");
		return response ;
	}
	
	
	/**
	 * 
	 * 获取岗位详细信息
	 * @param jobid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(path="/detail",method=RequestMethod.POST)
	public DataResponse<Job> getJobDetail(Integer id){
		System.out.println("==============="+id);   
		DataResponse<Job> response = new DataResponse<Job>();
		Job job= wechatJobService.get(id);
		response.setData(job);
		return response;
	}
	
}
