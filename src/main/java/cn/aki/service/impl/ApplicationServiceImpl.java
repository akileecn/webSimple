package cn.aki.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.aki.dao.ApplicationMapper;
import cn.aki.entity.Application;
import cn.aki.service.ApplicationService;

@Service("applicationService")
public class ApplicationServiceImpl implements ApplicationService{
	@Autowired
	private ApplicationMapper applicationMapper;
	
	public List<Application> getList(Integer resumeId) {
		return applicationMapper.getList(resumeId);
	}

	public void delete(Application application) {
		applicationMapper.delete(application);
	}

}
