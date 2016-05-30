package cn.aki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import cn.aki.entity.Notice;
import cn.aki.response.DataResponse;
import cn.aki.response.PageResponse;
import cn.aki.response.SimpleResponse;
import cn.aki.service.NoticeService;
/**
 * 通知
 * @author Aki
 * 2016年5月31日 上午12:59:31
 */
@Controller
@RequestMapping("/notice")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(path="/list",method=RequestMethod.GET)
	public String toList(Notice notice,Model model){
		model.addAttribute("notice", notice);
		return "notice/list";
	}

	@ResponseBody
	@RequestMapping(path="/list",method=RequestMethod.POST)
	public PageResponse<Notice> handleList(Integer pageNum,Integer pageSize,Notice notice){
		PageResponse<Notice> response=new PageResponse<Notice>();
		PageInfo<Notice> page=noticeService.getPage(pageNum, pageSize, notice);
		response.setData(page);
		return response;
	}
	
	@ResponseBody
	@RequestMapping(path="/detail",method=RequestMethod.POST)
	public DataResponse<Notice> detail(Notice notice){
		DataResponse<Notice> response=new DataResponse<Notice>();
		notice=noticeService.get(notice);
		response.setData(notice);
		return response;
	}
	
	@ResponseBody
	@RequestMapping(path="/delete",method=RequestMethod.POST)
	public SimpleResponse delete(Notice notice){
		SimpleResponse response=new SimpleResponse();
		noticeService.delete(notice);
		response.setSuccess(true);
		return response;
	}
}
