package cn.aki.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.aki.dao.DictDataMapper;
import cn.aki.dao.JobMapper;
import cn.aki.entity.DictData;
import cn.aki.entity.Job;
import cn.aki.service.JobService;

@Service("jobService")
public class JobServiceImpl implements JobService{
	@Autowired
	private JobMapper jobMapper;
	@Autowired
	private DictDataMapper dictDataMapper;
	
	public List<Job> getList() {
		List<DictData> list=dictDataMapper.getListByTypes(Arrays.asList(new String[]{"work_year"}));
		System.err.println(list.size());
		return jobMapper.getList();
	}

}
