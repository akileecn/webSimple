package cn.aki.dao;

import cn.aki.entity.Application;

import java.util.List;

public interface ApplicationMapper{
	void save(Application application);
	void delete(Application application);
	void update(Application application);
	Application get(Application application);
	List<Application> getList(Application application);
}