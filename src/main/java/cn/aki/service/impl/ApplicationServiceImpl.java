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
import cn.aki.response.DataResponse;
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

	public DataResponse<Application> apply(Application application) {
		DataResponse<Application>  response=new DataResponse<Application>();
		Job job=jobMapper.get(application.getJobId());
		if(job==null){
			response.setMessage("岗位不存在");
			return response;
		}
		String recruitType=job.getRecruitType();
		if(recruitType==null){
			response.setMessage("岗位招聘类型未知");
			return response;
		}
		List<Application> oldList=applicationMapper.getList(application);
		if(oldList!=null&&oldList.size()>0){
			for(Application old:oldList){
				if(old.getJob()!=null&&recruitType.equals(old.getJob().getRecruitType())){
					response.setMessage("本季度您已申请过岗位，我们会尽快和您联系，请您耐心等待");
					return response;
				}
			}
		}
		Resume resume=new Resume();
		resume.setUserId(application.getUserId());
		resume.setRecruitType(recruitType);
		resume=resumeMapper.getStatus(resume);
		if(resume==null){
			response.setMessage("简历不存在");
			return response;
		}
		//保存简历ID
		application.setResumeId(resume.getId());
		//传前台页面
		response.setData(application);
		if(resume.getIsSubmit()==false){
			response.setCode(Constants.ErrorCode.NOT_SUBMIT);
			response.setMessage("简历未提交");
			return response;
		}
		application.setStatus("1");
		application.setCreateTime(new Date());
		applicationMapper.save(application);
		return response;
	}

}
