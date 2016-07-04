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
import cn.aki.dao.ResumePracticeMapper;
import cn.aki.dao.ResumeStudentCadreMapper;
import cn.aki.dao.ResumeTrainMapper;
import cn.aki.dao.ResumeWorkMapper;
import cn.aki.entity.Resume;
import cn.aki.entity.ResumeAward;
import cn.aki.entity.ResumeComputer;
import cn.aki.entity.ResumeEducation;
import cn.aki.entity.ResumeFamily;
import cn.aki.entity.ResumeForeignLanguage;
import cn.aki.entity.ResumePractice;
import cn.aki.entity.ResumeStudentCadre;
import cn.aki.entity.ResumeTrain;
import cn.aki.entity.ResumeWork;
import cn.aki.service.WechatResumeService;

@Service("wechatResumeService")
public class WechatResumeServiceImpl implements WechatResumeService {

	@Autowired
	ResumeMapper resumeMapper ;
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
	@Autowired
	private ResumePracticeMapper practiceMapper;
	@Autowired
	private ResumeTrainMapper trainMapper;
	
	public Resume getResume(Resume resume,boolean isAll) {
		
		resume = resumeMapper.get(resume);
		if(isAll && null!=resume){
			Integer resumeId=resume.getId();
			List<ResumeAward> awardList=awardMapper.getList(resumeId);
			List<ResumeEducation> educationList=educationMapper.getList(resumeId);
			List<ResumeFamily> familyList=familyMapper.getList(resumeId);
			List<ResumeStudentCadre> studentCadreList=studentCadreMapper.getList(resumeId);
			List<ResumeWork> workList=workMapper.getList(resumeId);
			List<ResumeComputer> computerList=computerMapper.getList(resumeId);
			List<ResumeForeignLanguage> foreignLanguageList=foreignLanguageMapper.getList(resumeId);
			List<ResumePractice> practiceList=practiceMapper.getList(resumeId);
			List<ResumeTrain> trainList=trainMapper.getList(resumeId);
			
			resume.setAwardList(awardList);
			resume.setEducationList(educationList);
			resume.setFamilyList(familyList);
			resume.setWorkList(workList);
			resume.setComputerList(computerList);
			resume.setStudentCadreList(studentCadreList);
			resume.setForeignLanguageList(foreignLanguageList);
			resume.setPracticeList(practiceList);
			resume.setTrainList(trainList);
		}
		return resume ; 
	}

	public void updateResume(Resume resume) {
		resumeMapper.update(resume);
	}

}
