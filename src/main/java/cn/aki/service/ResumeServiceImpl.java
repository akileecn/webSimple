package cn.aki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.aki.dao.ResumeMapper;
import cn.aki.entity.Resume;

@Service("resumeService")
public class ResumeServiceImpl implements ResumeService{
	@Autowired
	private ResumeMapper resumeMapper;
	
	public void save(Resume resume) {
		resumeMapper.save(resume);
	}

}
