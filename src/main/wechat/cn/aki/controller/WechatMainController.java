package cn.aki.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.aki.entity.Resume;
import cn.aki.response.DataResponse;
import cn.aki.service.ResumeService;
import cn.aki.utils.UserUtils;

@Controller
@RequestMapping("/main/")
public class WechatMainController  extends BaseController{
	
	@Autowired
	ResumeService resumeService ;
	
	/***
	 * 
	 * 获取岗位列表
	 * @param form
	 * @return
	 */
	@ResponseBody
	@RequestMapping(path="/list",method=RequestMethod.POST)
	public DataResponse<List<Resume>> getJobList(Resume resume){
		DataResponse<List<Resume>> response = new DataResponse<List<Resume>>();
		
		Integer userid = UserUtils.getUserId();
		System.out.println("========================"+userid);
		if("".equals(userid) || userid == null ){
			response.setMessage("noLogin");
			return response ;
		}
		resume.setUserId(userid);
		List<Resume> list=resumeService.getList(resume);
		response.setData(list);
		System.out.println("========================");
		return response ;
	}
	
}
