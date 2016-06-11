package cn.aki.service;

import java.util.List;

import cn.aki.entity.Application;

/**
 * 申请
 * @author Aki
 * 2016年5月30日 下午11:13:29
 */
public interface ApplicationService {
	void save(Application application);
	void delete(Application application);
	void update(Application application);
	Application get(Application application);
	List<Application> getList(Application application);
	/**
	 * 投递简历
	 * @param application
	 * @return
	 */
	String apply(Application application);
}
