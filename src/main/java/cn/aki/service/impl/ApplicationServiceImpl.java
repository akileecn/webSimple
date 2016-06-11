package cn.aki.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.aki.dao.ApplicationMapper;
import cn.aki.dao.JobMapper;
import cn.aki.dao.ResumeEducationMapper;
import cn.aki.dao.ResumeMapper;
import cn.aki.dao.ResumeWorkMapper;
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
	@Autowired
	private ResumeWorkMapper resumeWorkMapper;
	@Autowired
	private ResumeEducationMapper resumeEducationMapper;
	
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
		resume.setId(application.getResumeId());
		resume=resumeMapper.get(resume);
		if(resume==null){
			return "简历不存在";
		}
		if(!recruitType.equals(resume.getRecruitType())){
			return "简历未提交";
		}
		if(resume.getPhoto()==null){
			return "请上传照片";
		}
		Integer educationCount=resumeEducationMapper.getCount(application.getResumeId());
		if(educationCount==0){
			return "教育经历未提交";
		}
		if("society".equals(recruitType)){
			Integer workCount=resumeWorkMapper.getCount(application.getResumeId());
			if(workCount==0){
				return "工作经历未提交";
			}
		}
		application.setStatus("1");
		application.setCreateTime(new Date());
		applicationMapper.save(application);
		return null;
	}

}
