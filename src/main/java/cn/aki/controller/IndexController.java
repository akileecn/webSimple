package cn.aki.controller;

import cn.aki.entity.User;
import cn.aki.service.NoticeService;
import cn.aki.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页
 * @author Aki
 * 2016年5月27日 下午11:26:06
 */
@Controller
@RequestMapping("/")
public class IndexController extends BaseController{
	@Autowired
	private NoticeService noticeService;

	@RequestMapping("/index")
	public String toMain(Model model){
		User user=UserUtils.getUser();
		model.addAttribute("user",user);
		// 统计新通知总数
		if(user!=null){
			Integer noticeCount=noticeService.countNewByUserId(user.getId());
			model.addAttribute("noticeCount",noticeCount);
		}
		// 清除个人中心类型
		UserUtils.setUserCenterType(null);
		return "index/main";
	}

//	@RequestMapping("/error") // 与spring boot端口冲突
//	public String toError(){
//		return "index/error";
//	}

}
