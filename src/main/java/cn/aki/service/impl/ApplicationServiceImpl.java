package cn.aki.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.aki.dao.ApplicationMapper;
import cn.aki.dao.JobMapper;
import cn.aki.dao.ResumeMapper;
import cn.aki.entity.Application;
import cn.aki.entity.Job;
import cn.aki.entity.Resume;
import cn.aki.service.ApplicationService;

@Service("applicationService")
public class ApplicationServiceImpl implements ApplicationService{
	@Autowired
	private ApplicationMapper applicationMapper;
	@Autowired
	private JobMapper jobMapper;
	@Autowired
	private ResumeMapper resumeMapper;
	
	public void delete(Application application) {
		applicationMapper.delete(application);
	}

	public void save(Application application) {
		applicationMapper.save(application);
	}

	public void update(Application application) {
		applicationMapper.update(application);
	}

	public Application get(Application application) {
		return applicationMapper.get(application);
	}

	public List<Application> getList(Application application) {
		return applicationMapper.getList(application);
	}

	public String apply(Application application) {
		List<Application> oldList=applicationMapper.getList(application);
		if(oldList!=null&&oldList.size()>0){
			return "已申请岗位";
		}
		Job job=jobMapper.get(application.getJobId());
		if(job==null){
			return "岗位不存在";
		}
		String recruitType=job.getrecruitType();
		if(recruitType==null){
			return "岗位招聘类型未知";
		}
		Resume resume=new Resume();
		resume.setUserId(application.getUserId());
		resume.setRecruitType(recruitType);
		resume=resumeMapper.getStatus(resume);
		if(resume==null){
			return "简历不存在";
		}
		if(resume.getIsSubmit()==false){
			return "简历未提交";
		}
		application.setResumeId(resume.getId());
		application.setStatus("1");
		application.setCreateTime(new Date());
		applicationMapper.save(application);
		return null;
	}

}
