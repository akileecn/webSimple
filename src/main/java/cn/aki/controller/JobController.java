package cn.aki.controller;

import cn.aki.entity.Job;
import cn.aki.entity.StaticPage;
import cn.aki.form.JobQueryForm;
import cn.aki.service.JobService;
import cn.aki.service.StaticPageService;
import cn.aki.utils.Constants;
import cn.aki.utils.Response;
import cn.aki.utils.UserUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * 岗位
 *
 * @author aki
 * 2016年4月29日 上午9:49:04
 */
@Controller
@RequestMapping("/job")
public class JobController {
    @Autowired
    private JobService jobService;
    @Autowired
    private StaticPageService staticPageService;

    @ApiOperation("热招岗位")
    @ResponseBody
    @GetMapping("/hotList")
    public Response<PageInfo<Job>> handleHotList(Integer pageNum) {
        return Response.success(jobService.getHotList(pageNum));
    }

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public String toList(JobQueryForm form, Model model) {
        //默认跳转到校招
        if (StringUtils.isEmpty(form.getRecruitType())) {
            form.setRecruitType("campus");
        }
        model.addAttribute("job", form.createJob());
        //控制个人中心类型
        UserUtils.setUserCenterType(form.getRecruitType());
        return "job/list";
    }

    @ResponseBody
    @PostMapping(path = "/list")
    public Response<PageInfo<Job>> handleList(JobQueryForm form) {
        return Response.success(jobService.getPage(form));
    }

//    @RequestMapping(path = "/detail", method = RequestMethod.GET)
//    public String toDetail(Integer id, Model model) {
//        Job job = jobService.get(id);
//        model.addAttribute("job", job);
//        return "job/detail";
//    }

    @ResponseBody
    @GetMapping("/detail")
    public Response<Job> handleDetail(Integer id) {
        return Response.success(jobService.get(id));
    }

    //公告
    @ResponseBody
    @GetMapping("/notice")
    public Response<StaticPage> toNotice() {
        StaticPage staticPage = new StaticPage();
        staticPage.setCode(Constants.StaticPageCode.RECRUIT_NOTICE);
        return Response.success(staticPageService.get(staticPage));
    }

}
