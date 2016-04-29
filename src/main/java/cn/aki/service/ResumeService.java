package cn.aki.service;

import cn.aki.entity.Resume;

public interface ResumeService {
	/**
	 * 保存简历基本信息
	 * @param resume
	 */
	void save(Resume resume);
}
