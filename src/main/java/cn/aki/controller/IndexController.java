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
@RequestMapping("/index")
public class IndexController extends BaseController{
	@Autowired
	private JobService jobService;
	
	@RequestMapping()
	public String toMain(Model model){
		//热招岗位
		List<Job> hotJoblist=jobService.getHotList();
		model.addAttribute("hotJoblist", hotJoblist);
		model.addAttribute("user",UserUtils.getUser());
		return "index/main";
	}
}
