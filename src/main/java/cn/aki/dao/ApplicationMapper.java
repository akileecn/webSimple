package cn.aki.dao;

import java.util.List;

import cn.aki.entity.Application;

public interface ApplicationMapper{
	void save(Application application);
	void delete(Application application);
	void update(Application application);
	Application get(Application application);
	List<Application> getList(Application application);
}