package cn.aki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.aki.entity.StaticPage;
import cn.aki.response.DataResponse;
import cn.aki.service.StaticPageService;

@Controller
@RequestMapping("/wechatStaticPage")
public class WechatStaticPageController {
	@Autowired
	private StaticPageService staticPageService;

	
	/**
	 * 跳转页面公共方法
	 */
	@ResponseBody
	@RequestMapping(path="getContent",method=RequestMethod.POST)
	private DataResponse<StaticPage> _toPage(StaticPage staticPage){
		DataResponse<StaticPage> response = new  DataResponse<StaticPage>();
		staticPage = staticPageService.get(staticPage);
		response.setData(staticPage);
		System.err.println("--------------------"+staticPage.getCode());
		return response;
	}
}
