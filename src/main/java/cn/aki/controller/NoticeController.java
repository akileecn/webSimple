package cn.aki.controller;

import cn.aki.entity.Notice;
import cn.aki.service.NoticeService;
import cn.aki.utils.Response;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 通知
 *
 * @author Aki
 * 2016年5月31日 上午12:59:31
 */
@Controller
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public String toList(Notice notice, Model model) {
        model.addAttribute("notice", notice);
        return "notice/list";
    }

    @ResponseBody
    @RequestMapping(path = "/list", method = RequestMethod.POST)
    public Response<PageInfo<Notice>> handleList(Integer pageNum, Integer pageSize, Notice notice) {
        return Response.success(noticeService.getPage(pageNum, pageSize, notice));
    }

    @ResponseBody
    @RequestMapping(path = "/detail", method = RequestMethod.POST)
    public Response<Notice> detail(Notice notice) {
        return Response.success(noticeService.get(notice));
    }

    @ResponseBody
    @RequestMapping(path = "/delete", method = RequestMethod.POST)
    public Response delete(Notice notice) {
        noticeService.delete(notice);
        return Response.success();
    }
}
