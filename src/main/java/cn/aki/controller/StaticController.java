package cn.aki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 伪静态文件
 * @author aki
 * 2016年5月17日 下午5:50:18
 */
@Controller
@RequestMapping("/static")
public class StaticController {
	@RequestMapping(path="/{path}")
	public String handle(@PathVariable()String path){
		return "static/"+path;
	}
}
