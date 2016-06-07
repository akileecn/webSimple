package cn.aki.service;

import com.github.pagehelper.PageInfo;

import cn.aki.entity.Job;
import cn.aki.form.JobQueryForm;


public interface WechatJobService {

	
	/**
	 * 根据表单条件查询
	 * @param form
	 * @return
	 */
	PageInfo<Job> getPage(JobQueryForm form);
	
	
	/**
	 * 根据主键获得实体
	 * @param id
	 * @return
	 */
	Job get(Integer id);
	
}
