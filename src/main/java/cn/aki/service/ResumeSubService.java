package cn.aki.service;

import java.util.List;

import cn.aki.entity.base.ResumeSub;
/**
 * 简历从属实体service
 * @author Aki
 * 2016年5月11日 上午12:19:03
 */
public interface ResumeSubService {
	<T extends ResumeSub> void save(T t);
	<T extends ResumeSub> T get(T t);
	<T extends ResumeSub> List<T> getList(T t);
	<T extends ResumeSub> void update(T t);
	<T extends ResumeSub> void delete(T t);
}
