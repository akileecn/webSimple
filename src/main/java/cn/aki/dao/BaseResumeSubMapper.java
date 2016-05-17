package cn.aki.dao;

import java.util.List;

import cn.aki.entity.base.ResumeSubEntity;

public interface BaseResumeSubMapper<T extends ResumeSubEntity> {
	void save(T t);
	T get(T t);
	List<T> getList(Integer resumeId);
	void update(T t);
	void delete(T t);
}
