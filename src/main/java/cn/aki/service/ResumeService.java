package cn.aki.service;

import cn.aki.entity.Resume;

public interface ResumeService {
	Resume get(Integer id);
	void update(Resume resume);
}
