package cn.aki.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.aki.entity.StaticPage;
import cn.aki.service.StaticPageService;

@Controller
@RequestMapping("/staticPage")
public class StaticPageController {
	@Autowired
	private StaticPageService staticPageService;
	/**模版文件夹*/
	private static final String TEMPLATE_DIR="staticPage/";
	
	@RequestMapping(path="/{code}/{attr}",method=RequestMethod.GET)
	public String toPage(@PathVariable String code,@PathVariable String attr,Model model,HttpServletResponse response){
		return _toPage(code, attr, model, response);
	}
	
	@RequestMapping(path="/{code}",method=RequestMethod.GET)
	public String toPage(@PathVariable String code,Model model,HttpServletResponse response){
		return _toPage(code, null, model, response);
	}
	
	/**
	 * 跳转页面公共方法
	 */
	private String _toPage(String code,String attr,Model model,HttpServletResponse response){
		StaticPage staticPage=new StaticPage();
		staticPage.setCode(code);
		staticPage.setAttr(attr);
		staticPage=staticPageService.get(staticPage);
		if(staticPage!=null&&staticPage.getContent()!=null){
			String template=staticPage.getTemplate();
			if(StringUtils.isEmpty(template)){
				try {
					PrintWriter out = response.getWriter();
					out.println(staticPage.getContent());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else{
				model.addAttribute("staticPage", staticPage);
				return TEMPLATE_DIR+template;
			}
		}
		return null;
	}
}
