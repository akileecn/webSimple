package cn.aki.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.aki.dao.ResumeAwardMapper;
import cn.aki.dao.ResumeEducationMapper;
import cn.aki.dao.ResumeFamilyMapper;
import cn.aki.dao.ResumeMapper;
import cn.aki.dao.ResumeWorkMapper;
import cn.aki.entity.Resume;
import cn.aki.entity.ResumeAward;
import cn.aki.entity.ResumeEducation;
import cn.aki.entity.ResumeFamily;
import cn.aki.entity.ResumeWork;
import cn.aki.service.ResumeService;

@Service("resumeService")
public class ResumeServiceImpl implements ResumeService{
	@Autowired
	private ResumeMapper resumeMapper;
	@Autowired
	private ResumeAwardMapper awardMapper;
	@Autowired
	private ResumeEducationMapper educationMapper;
	@Autowired
	private ResumeFamilyMapper familyMapper;
	@Autowired
	private ResumeWorkMapper workMapper;
	
	public Resume get(Resume resume,boolean isAll) {
		resume=resumeMapper.get(resume);
		if(isAll&&resume!=null){
			Integer resumeId=resume.getId();
			List<ResumeAward> awardList=awardMapper.getList(resumeId);
			List<ResumeEducation> educationList=educationMapper.getList(resumeId);
			List<ResumeFamily> familyList=familyMapper.getList(resumeId);
			List<ResumeWork> workList=workMapper.getList(resumeId);
			resume.setAwardList(awardList);
			resume.setEducationList(educationList);
			resume.setFamilyList(familyList);
			resume.setWorkList(workList);
		}
		return resume;
	}

	public void update(Resume resume) {
		resumeMapper.update(resume);
	}

}
