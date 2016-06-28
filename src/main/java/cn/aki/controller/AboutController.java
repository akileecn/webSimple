package cn.aki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.aki.utils.UserUtils;

@Controller
@RequestMapping("/about")
public class AboutController extends BaseController{
	@RequestMapping
	public String toMain(){
		//控制个人中心类型
		UserUtils.setUserCenterType("about");
		return "about/main";
	}
	
	@RequestMapping(path="/{index}",method=RequestMethod.GET)
	public String toPart(@PathVariable String index){
		return "about/part/"+index;
	}
}
