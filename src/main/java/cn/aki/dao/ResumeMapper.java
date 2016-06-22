package cn.aki.dao;

import java.util.List;

import cn.aki.entity.Resume;

public interface ResumeMapper {
	void save(Resume resume);
	Resume get(Resume resume);
	void update(Resume resume);
	/**
	 * 更新照片
	 */
	void updatePhoto(Resume resume);
	/**
	 * 获得照片
	 */
	Resume getPhoto(Resume resume);
	/**
	 * 更新状态
	 * @param resume
	 */
	void updateStatus(Resume resume);
	/**
	 * 获得状态
	 * @param resume
	 * @return
	 */
	Resume getStatus(Resume resume);
	/**
	 * 获得轻量级的简历集合
	 * @param resume
	 * @return
	 */
	List<Resume> getList(Resume resume);
	
}
