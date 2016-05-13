package cn.aki.dao;

import java.util.List;

import cn.aki.entity.Resume;

public interface ResumeMapper {
	void save(Resume resume);
	Resume get(Resume resume);
	void update(Resume resume);
	/**
	 * 获得用户的简历ID,判断简历操作权限用
	 * @param userId
	 * @return
	 * 
	 */
	List<Integer> getIdByUserId(Integer userId);
}
