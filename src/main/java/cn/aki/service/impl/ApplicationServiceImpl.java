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

}
