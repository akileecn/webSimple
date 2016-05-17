package cn.aki.service;

import java.util.List;

import cn.aki.entity.base.ResumeSubEntity;
/**
 * 简历从属实体service
 * @author Aki
 * 2016年5月11日 上午12:19:03
 */
public interface ResumeSubService {
	<T extends ResumeSubEntity> void saveOrUpdate(T t);
	<T extends ResumeSubEntity> T get(T t);
	<T extends ResumeSubEntity> List<T> getList(T t);
	<T extends ResumeSubEntity> void delete(T t);
}
