package cn.aki.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

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
import cn.aki.response.FormResponse;
import cn.aki.service.ResumeService;
import cn.aki.utils.Constants;

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
	@Autowired
	private ResumePracticeMapper practiceMapper;
	@Autowired
	private ResumeTrainMapper trainMapper;
	
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
		return resume;
	}

	public void update(Resume resume) {
		resume.setModifyTime(new Date());
		resumeMapper.update(resume);
	}

	public void updatePhoto(Resume resume) {
		resumeMapper.updatePhoto(resume);
	}

	public Resume getPhoto(Resume resume) {
		return resumeMapper.getPhoto(resume);
	}

	public void validate(Resume resume, FormResponse<?> response) {
		String recruitType=resume.getRecruitType();
		Map<String,Object> map=new HashMap<String, Object>();
		//社招必填
		if(Constants.RECRUIT_TYPE_SOCIETY.equals(recruitType)){
			map.put("beginWorkDate", resume.getBeginWorkDate());
			map.put("workYear", resume.getWorkYear());
			validateNotEmpty(map, response);
		//校招,实习必填
		}else{
			map.put("ceeProvince", resume.getCeeProvince());
			map.put("ceeScore", resume.getCeeScore());
			map.put("isFirstLine", resume.getIsFirstLine());
			map.put("artsOrScience", resume.getArtsOrScience());
			map.put("admissionOrder", resume.getAdmissionOrder());
			validateNotEmpty(map, response);
		}
		
	}
	
	/**
	 * 验证字段是否为空
	 * @param map
	 * @param response
	 */
	private void validateNotEmpty(Map<String,Object> map,FormResponse<?> response){
		final String errInfo="字段不能为空";
		Set<String> fields=map.keySet();
		for(String field:fields){
			if(StringUtils.isEmpty(map.get(field))){
				response.putError(field, errInfo);
			}
		}
	}

	@Transactional
	public String submit(Resume resume) {
		/*校验*/
		resume=resumeMapper.get(resume);
		if(resume==null){
			return "简历不存在";
		}
		if(resume.getModifyTime()==null){
			return "简历基本信息未保存";
		}
		String recruitType=resume.getRecruitType();
		if(recruitType==null){
			return "简历招聘类型未知";
		}else{
			Integer resumeId=resume.getId();
			Integer educationCount=educationMapper.getCount(resumeId);
			Integer workCount=workMapper.getCount(resumeId);
			List<ResumeFamily> familyList=familyMapper.getList(resumeId);
			if(familyList==null||familyList.size()==0){
				return "未填写家庭关系";
			}
			if(educationCount==0){
				return "未填写教育经历";
			}
			if(Constants.RECRUIT_TYPE_SOCIETY.equals(recruitType)){
				if(workCount==0){
					return "未填写工作经历";
				}
			}
		}
		resume.setIsSubmit(true);
		/*更新状态*/
		resumeMapper.updateStatus(resume);
		return null;
	}

	public List<Resume> getList(Resume resume) {
		return resumeMapper.getList(resume);
	}

}
