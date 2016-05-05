package cn.aki.dao;

import cn.aki.entity.Resume;

public interface ResumeMapper {
	void save(Resume resume);
	Resume get(Integer id);
	void update(Resume resume);
	/**
	 * 获得用户的简历ID,判断简历操作权限用
	 * @param userId
	 * @return
	 */
	Integer getIdByUserId(Integer userId);
}
