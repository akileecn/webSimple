package cn.aki.controller;

import cn.aki.entity.Job;
import cn.aki.entity.StaticPage;
import cn.aki.form.JobQueryForm;
import cn.aki.response.DataResponse;
import cn.aki.response.PageResponse;
import cn.aki.service.JobService;
import cn.aki.service.StaticPageService;
import cn.aki.utils.Constants;
import cn.aki.utils.UserUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@RequestMapping(path = "/hotList", method = RequestMethod.POST)
	public PageResponse<Job> handleHotList(@ApiParam("页码") Integer pageNum) {
		PageResponse<Job> response = new PageResponse<Job>();
		response.setData(jobService.getHotList(pageNum));
		return response;
	}

	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public String toList(JobQueryForm form, Model model) {
		//默认跳转到校招
		if (StringUtils.isEmpty(form.getrecruitType())) {
			form.setrecruitType("campus");
		}
		model.addAttribute("job", form.createJob());
		//控制个人中心类型
		UserUtils.setUserCenterType(form.getrecruitType());
		return "job/list";
	}

	@ResponseBody
	@RequestMapping(path = "/list", method = RequestMethod.POST)
	public PageResponse<Job> handleList(JobQueryForm form) {
		PageInfo<Job> page = jobService.getPage(form);
		PageResponse<Job> response = new PageResponse<Job>();
		response.setData(page);
		return response;
	}

	@RequestMapping(path = "/detail", method = RequestMethod.GET)
	public String toDetail(Integer id, Model model) {
		Job job = jobService.get(id);
		model.addAttribute("job", job);
		return "job/detail";
	}

	@ResponseBody
	@RequestMapping(path = "/detail", method = RequestMethod.POST)
	public DataResponse<Job> handleDetail(Integer id) {
		DataResponse<Job> response = new DataResponse<Job>();
		Job job = jobService.get(id);
		response.setData(job);
		return response;
	}

	//公告
	@RequestMapping(path = "/notice", method = RequestMethod.GET)
	public String toNotice(Job job, Model model) {
		StaticPage staticPage = new StaticPage();
		staticPage.setCode(Constants.StaticPageCode.RECRUIT_NOTICE);
		staticPage = staticPageService.get(staticPage);
		model.addAttribute("staticPage", staticPage);
		return "job/notice";
	}

}
