package cn.aki.dao;

import java.util.List;

import cn.aki.entity.Job;

public interface JobMapper {
	List<Job> getList(Job condition);
	Job get(Integer id);
	/**
	 * 获得惹着岗位
	 * @return
	 */
	List<Job> getHotList(int count);
}
