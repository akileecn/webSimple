package cn.aki.controller;

import cn.aki.entity.Job;
import cn.aki.entity.StaticPage;
import cn.aki.form.JobQueryForm;
import cn.aki.service.JobService;
import cn.aki.service.StaticPageService;
import cn.aki.utils.Constants;
import cn.aki.utils.Response;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 岗位
 *
 * @author aki
 * 2016年4月29日 上午9:49:04
 */
@RestController
@RequestMapping("/job")
public class JobController {
    @Autowired
    private JobService jobService;
    @Autowired
    private StaticPageService staticPageService;

    @ApiOperation("热招岗位")
    @GetMapping("/hotList")
    public Response<PageInfo<Job>> handleHotList(Integer pageNum) {
        return Response.success(jobService.getHotList(pageNum));
    }

    @PostMapping(path = "/list")
    public Response<PageInfo<Job>> handleList(JobQueryForm form) {
        return Response.success(jobService.getPage(form));
    }

    @GetMapping("/detail")
    public Response<Job> handleDetail(Integer id) {
        return Response.success(jobService.get(id));
    }

    @GetMapping("/notice")
    public Response<StaticPage> toNotice() {
        StaticPage staticPage = new StaticPage();
        staticPage.setCode(Constants.StaticPageCode.RECRUIT_NOTICE);
        return Response.success(staticPageService.get(staticPage));
    }

}
