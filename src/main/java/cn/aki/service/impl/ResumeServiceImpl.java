package cn.aki.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.aki.dao.ResumeMapper;
import cn.aki.entity.Resume;
import cn.aki.service.ResumeService;

@Service("resumeService")
public class ResumeServiceImpl implements ResumeService{
	@Autowired
	private ResumeMapper resumeMapper;
	
	public Resume get(Integer id) {
		return resumeMapper.get(id);
	}

	public void update(Resume resume) {
		resumeMapper.update(resume);
	}

}
