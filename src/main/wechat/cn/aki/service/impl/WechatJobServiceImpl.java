package cn.aki.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;

import cn.aki.dao.JobMapper;
import cn.aki.entity.Job;
import cn.aki.form.JobQueryForm;
import cn.aki.service.WechatJobService;

@Service("wechatJobService")
public class WechatJobServiceImpl extends BaseServiceImpl<Job> implements WechatJobService{

	@Autowired
	JobMapper jobMapper ;
	
	public PageInfo<Job> getPage(JobQueryForm form) {
		return getPage(form.getPageNum(), form.getPageSize(), form.createJob());
	}

	public Job get(Integer id) {
		return jobMapper.get(id);
	}

	public List<Job> getList(Job condition) {
		return jobMapper.getList(condition);
	}


}
