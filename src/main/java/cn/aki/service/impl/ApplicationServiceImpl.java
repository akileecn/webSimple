package cn.aki.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.aki.dao.ApplicationMapper;
import cn.aki.dao.JobMapper;
import cn.aki.dao.ResumeEducationMapper;
import cn.aki.dao.ResumeFamilyMapper;
import cn.aki.dao.ResumeMapper;
import cn.aki.dao.ResumeWorkMapper;
import cn.aki.entity.Application;
import cn.aki.entity.Job;
import cn.aki.entity.Resume;
import cn.aki.entity.ResumeFamily;
import cn.aki.service.ApplicationService;
import cn.aki.utils.Constants;

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
	@Autowired
	private ResumeFamilyMapper resumeFamilyMapper;
	
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
		Integer resumeId=application.getResumeId();
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
		resume.setId(resumeId);
		resume=resumeMapper.get(resume);
		if(resume==null){
			return "简历不存在";
		}
		if(!recruitType.equals(resume.getRecruitType())){
			return "简历未提交";
		}
		Integer educationCount=resumeEducationMapper.getCount(resumeId);
		if(educationCount==0){
			return "未填写教育经历";
		}
		List<ResumeFamily> familyList=resumeFamilyMapper.getList(resumeId);
		if(familyList==null||familyList.size()==0){
			return "未填写家庭关系";
		}
		if(Constants.RECRUIT_TYPE_SOCIETY.equals(recruitType)){
			Integer workCount=resumeWorkMapper.getCount(application.getResumeId());
			if(workCount==0){
				return "未填写工作经历";
			}
		}
		application.setStatus("1");
		application.setCreateTime(new Date());
		applicationMapper.save(application);
		return null;
	}

}
