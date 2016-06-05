package cn.aki.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.aki.dao.ResumeAwardMapper;
import cn.aki.dao.ResumeComputerMapper;
import cn.aki.dao.ResumeEducationMapper;
import cn.aki.dao.ResumeFamilyMapper;
import cn.aki.dao.ResumeForeignLanguageMapper;
import cn.aki.dao.ResumeMapper;
import cn.aki.dao.ResumeStudentCadreMapper;
import cn.aki.dao.ResumeWorkMapper;
import cn.aki.entity.Resume;
import cn.aki.entity.ResumeAward;
import cn.aki.entity.ResumeComputer;
import cn.aki.entity.ResumeEducation;
import cn.aki.entity.ResumeFamily;
import cn.aki.entity.ResumeForeignLanguage;
import cn.aki.entity.ResumeStudentCadre;
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
	@Autowired
	private ResumeComputerMapper computerMapper;
	@Autowired
	private ResumeForeignLanguageMapper foreignLanguageMapper;
	@Autowired
	private ResumeStudentCadreMapper studentCadreMapper;
	
	public Resume get(Resume resume,boolean isAll) {
		resume=resumeMapper.get(resume);
		if(isAll&&resume!=null){
			Integer resumeId=resume.getId();
			List<ResumeAward> awardList=awardMapper.getList(resumeId);
			List<ResumeEducation> educationList=educationMapper.getList(resumeId);
			List<ResumeFamily> familyList=familyMapper.getList(resumeId);
			List<ResumeStudentCadre> studentCadreList=studentCadreMapper.getList(resumeId);
			List<ResumeWork> workList=workMapper.getList(resumeId);
			List<ResumeComputer> computerList=computerMapper.getList(resumeId);
			List<ResumeForeignLanguage> foreignLanguageList=foreignLanguageMapper.getList(resumeId);
			resume.setAwardList(awardList);
			resume.setEducationList(educationList);
			resume.setFamilyList(familyList);
			resume.setWorkList(workList);
			resume.setComputerList(computerList);
			resume.setStudentCadreList(studentCadreList);
			resume.setForeignLanguageList(foreignLanguageList);
		}
		return resume;
	}

	public void update(Resume resume) {
		resumeMapper.update(resume);
	}

	public void updatePhoto(Resume resume) {
		resumeMapper.updatePhoto(resume);
	}

	public Resume getPhoto(Resume resume) {
		return resumeMapper.getPhoto(resume);
	}

}
