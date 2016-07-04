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
import cn.aki.utils.UserUtils;

@Controller
@RequestMapping("/wechatApplication/")
public class WechatApplicationController {

	
	@Autowired
	WechatApplicationService wecharApplicationService ;
	
	@ResponseBody
	@RequestMapping(path="list",method=RequestMethod.POST)
	public DataResponse<List<Application>> getList(Application application){
		DataResponse<List<Application>> response = new DataResponse<List<Application>>();
		Integer userid = UserUtils.getUserId();
		if("".equals(userid) || userid == null ){
			response.setMessage("noLogin");
			return response ;
		}
		application.setUserId(userid);;

		List<Application> list = wecharApplicationService.getList(application);
		response.setData(list);
		return response ;
	}
	
	
}
