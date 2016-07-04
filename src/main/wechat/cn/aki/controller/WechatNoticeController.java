package cn.aki.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import cn.aki.entity.Notice;
import cn.aki.response.DataResponse;
import cn.aki.response.PageResponse;
import cn.aki.service.WechatNoticeService;
import cn.aki.service.impl.WechatNoticeServiceImpl;
import cn.aki.utils.UserUtils;

/***
 * 
 * 微信端通知信
 * @author Administrator
 * 2016年5月31日 上午12:55:30
 */
@Controller
@RequestMapping("/wechatNotice/")
public class WechatNoticeController{

	@Autowired
	WechatNoticeService wechatNoticeService;
	
	/***
	 * 
	 * 获取微信通知信息
	 * @param notice
	 * @return
	 */
	@ResponseBody
	@RequestMapping(path="/list",method=RequestMethod.POST)
	public DataResponse<List<Notice>> getNotice(Notice notice){
		DataResponse<List<Notice>> response = new DataResponse<List<Notice>>();

		Integer userid = UserUtils.getUserId();
		if("".equals(userid) || userid == null ){
			response.setMessage("noLogin");
			return response ;
		}
		
		notice.setUserId(userid);
		List<Notice> notices = wechatNoticeService.getList(notice);
		System.out.println(notice.toString());
		response.setData(notices);
		return response ;
	}
	
	
}
