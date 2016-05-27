package cn.aki.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;

import cn.aki.dao.JobMapper;
import cn.aki.entity.Job;
import cn.aki.form.JobQueryForm;
import cn.aki.service.JobService;

@Service("jobService")
public class JobServiceImpl extends BaseServiceImpl<Job> implements JobService{
	@Autowired
	private JobMapper jobMapper;
	
	public List<Job> getList(Job condition) {
		return jobMapper.getList(condition);
	}

	public PageInfo<Job> getPage(JobQueryForm form) {
		return getPage(form.getPageNum(), form.getPageSize(),form.createJob());
	}

	public Job get(Integer id) {
		return jobMapper.get(id);
	}

	public List<Job> getHotList() {
		final int dedaultCount=16;
		return jobMapper.getHotList(dedaultCount);
	}

}
