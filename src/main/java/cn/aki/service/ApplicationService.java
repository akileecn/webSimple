package cn.aki.service;

import java.util.List;

import cn.aki.entity.Application;

/**
 * 申请
 * @author Aki
 * 2016年5月30日 下午11:13:29
 */
public interface ApplicationService {
	List<Application> getList(Integer resumeId);
	void delete(Application application);
}
