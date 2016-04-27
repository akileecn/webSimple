package cn.aki.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.aki.dao.JobMapper;
import cn.aki.entity.Job;
import cn.aki.service.JobService;

@Service("jobService")
public class JobServiceImpl extends BaseServiceImpl<Job> implements JobService{
	@Autowired
	private JobMapper jobMapper;
	
	@Override
	public List<Job> getList(Job condition) {
		return jobMapper.getList(condition);
	}

}
