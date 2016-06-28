package cn.aki.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.aki.entity.Job;
import cn.aki.service.JobService;
import cn.aki.utils.UserUtils;

/**
 * 首页
 * @author Aki
 * 2016年5月27日 下午11:26:06
 */
@Controller
@RequestMapping()
public class IndexController extends BaseController{
	@Autowired
	private JobService jobService;
	
	@RequestMapping("/index")
	public String toMain(Model model){
		//热招岗位
		List<Job> hotJoblist=jobService.getHotList();
		model.addAttribute("hotJoblist", hotJoblist);
		model.addAttribute("user",UserUtils.getUser());
		//清楚个人中心类型
		UserUtils.setUserCenterType(null);
		return "index/main";
	}
	
	@RequestMapping("/error")
	public String toError(){
		return "index/error";
	}
	
}
