package cn.aki.service;

import com.github.pagehelper.PageInfo;

import cn.aki.entity.Job;
import cn.aki.form.JobQueryForm;

public interface JobService extends BaseService<Job>{
	/**
	 * 根据表单查询
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
	/**
	 * 获得惹着岗位
	 * @return
	 */
	PageInfo<Job> getHotList(Integer pageNum);
}
