package cn.aki.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import cn.aki.entity.Application;
import cn.aki.response.DataResponse;
import cn.aki.service.WechatApplicationService;

@Controller
@RequestMapping("/wechatApplication/")
public class WecharApplicationController {

	
	@Autowired
	WechatApplicationService wecharApplicationService ;
	
	@ResponseBody
	@RequestMapping(path="list",method=RequestMethod.POST)
	public DataResponse<List<Application>> getList(Application application){
		//application.setJobId(1);
		application.setUserId(0);;
		DataResponse<List<Application>> response = new DataResponse<List<Application>>();
		List<Application> list = wecharApplicationService.getList(application);
		//System.out.println(list.toString());
		response.setData(list);
		return response ;
	}
	
	
}
