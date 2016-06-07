package cn.aki.service;

import cn.aki.entity.Resume;

public interface WechatResumeService {

	
	Resume getResume(Resume resume,boolean isAll);
	
	void updateResume(Resume resume);
	
}
