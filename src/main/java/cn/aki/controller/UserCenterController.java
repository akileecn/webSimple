package cn.aki.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import cn.aki.entity.Application;
import cn.aki.entity.Notice;
import cn.aki.response.DataResponse;
import cn.aki.response.PageResponse;
import cn.aki.service.ApplicationService;
import cn.aki.service.NoticeService;
/**
 * 个人中心
 * @author Aki
 * 2016年5月30日 下午11:30:03
 */
@Controller
@RequestMapping("/userCenter")
public class UserCenterController {
	@Autowired
	private ApplicationService applicationService;
	@Autowired
	private NoticeService noticeService;
	
	/**
	 * 我的应聘页面
	 */
	@RequestMapping(path="/application/list",method=RequestMethod.GET)
	public String toApplicationList(Application application,Model model){
		model.addAttribute("application", application);
		return "userCenter/application/list";
	}
	/**
	 * 我的应聘数据
	 */
	@ResponseBody
	@RequestMapping(path="/application/list",method=RequestMethod.POST)
	public DataResponse<List<Application>> handleApplicationList(Application application){
		DataResponse<List<Application>> response=new DataResponse<List<Application>>();
		List<Application> list=applicationService.getList(application.getResumeId());
		response.setData(list);
		return response;
	}
	/**
	 * 我的通知页面
	 */
	@RequestMapping(path="/notice/list",method=RequestMethod.GET)
	public String toNoticeList(Notice notice,Model model){
		model.addAttribute("notice", notice);
		return "userCenter/notice/list";
	}
	/**
	 * 我的通知数据
	 */
	@ResponseBody
	@RequestMapping(path="/notice/list",method=RequestMethod.POST)
	public PageResponse<Notice> handleNoticeList(Integer pageNum,Integer pageSize,Notice notice){
		PageResponse<Notice> response=new PageResponse<Notice>();
		PageInfo<Notice> page=noticeService.getPage(pageNum, pageSize, notice);
		response.setData(page);
		return response;
	}
}
