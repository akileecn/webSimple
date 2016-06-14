package cn.aki.service;

import cn.aki.entity.Resume;
import cn.aki.response.FormResponse;

public interface ResumeService {
	/**
	 * 获得简历
	 * @param resume
	 * @param isAll 是否包含从属信息
	 * @return
	 */
	Resume get(Resume resume,boolean isAll);
	void update(Resume resume);
	/**
	 * 更新照片
	 * @param resume
	 */
	void updatePhoto(Resume resume);
	/**
	 * 获得照片
	 */
	Resume getPhoto(Resume resume);
	/**
	 * 校验
	 * @param resume
	 * @param response
	 */
	void validate(Resume resume,FormResponse<?> response);
}
