package cn.aki.controller;

import cn.aki.entity.Notice;
import cn.aki.service.NoticeService;
import cn.aki.utils.Response;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 通知
 *
 * @author Aki
 * 2016年5月31日 上午12:59:31
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @GetMapping("/list")
    public Response<PageInfo<Notice>> handleList(Integer pageNum, Integer pageSize, Notice notice) {
        return Response.success(noticeService.getPage(pageNum, pageSize, notice));
    }

    @PostMapping("/delete")
    public Response delete(Notice notice) {
        noticeService.delete(notice);
        return Response.success();
    }
}
