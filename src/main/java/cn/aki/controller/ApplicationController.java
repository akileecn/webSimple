package cn.aki.controller;

import cn.aki.entity.Application;
import cn.aki.service.ApplicationService;
import cn.aki.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 应聘
 *
 * @author Aki
 * 2016年5月30日 下午11:30:03
 */
@RestController
@RequestMapping("/application")
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;

    /**
     * 我的应聘页面
     */
    @GetMapping("/list")
    public Response<List<Application>> toApplicationList(Application application) {
        List<Application> list = applicationService.getList(application);
        return Response.success(list);
    }

    /**
     * 投递简历
     */
    @PostMapping("/apply")
    public Response<Application> handleApply(Application application) {
        return applicationService.apply(application);
    }

}
