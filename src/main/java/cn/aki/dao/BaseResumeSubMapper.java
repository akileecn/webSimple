package cn.aki.dao;

import java.util.List;

import cn.aki.entity.base.ResumeSub;

public interface BaseResumeSubMapper<T extends ResumeSub> {
	void save(T t);
	T get(T t);
	List<T> getList(T t);
	void update(T t);
	void delete(T t);
}
