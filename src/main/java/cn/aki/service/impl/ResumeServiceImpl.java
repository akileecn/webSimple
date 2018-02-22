package cn.aki.service.impl;

import cn.aki.dao.*;
import cn.aki.entity.*;
import cn.aki.service.ResumeService;
import cn.aki.utils.Constants;
import cn.aki.utils.Response;
import cn.aki.vo.ResumeAllVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.*;

@Service("resumeService")
public class ResumeServiceImpl implements ResumeService {
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

    public Resume get(Resume resume) {
        return resumeMapper.get(resume);
    }

    @Override
    public ResumeAllVO getAll(Resume resume) {
        ResumeAllVO vo = new ResumeAllVO();
        resume = resumeMapper.get(resume);
        if (resume != null) {
            vo.setResume(resume);
            final int resumeId = resume.getId();
            vo.setAwardList(awardMapper.getList(resumeId));
            vo.setEducationList(educationMapper.getList(resumeId));
            vo.setFamilyList(familyMapper.getList(resumeId));
            vo.setWorkList(workMapper.getList(resumeId));
            vo.setComputerList(computerMapper.getList(resumeId));
            vo.setStudentCadreList(studentCadreMapper.getList(resumeId));
            vo.setForeignLanguageList(foreignLanguageMapper.getList(resumeId));
            vo.setPracticeList(practiceMapper.getList(resumeId));
            vo.setTrainList(trainMapper.getList(resumeId));
        }
        return vo;
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

    public void validate(Resume resume, Response<?> response) {
        String recruitType = resume.getRecruitType();
        Map<String, Object> map = new HashMap<String, Object>();
        Date beginSchooleDate = resume.getBeginSchoolDate();
        Date graduateDate = resume.getGraduateDate();
        if (beginSchooleDate != null && graduateDate != null && graduateDate.getTime() < beginSchooleDate.getTime()) {
            response.setSuccess(false);
            response.setMessage("毕业时间必须大于开始时间");
            return;
        }
        //社招必填
        if (Constants.RECRUIT_TYPE_SOCIETY.equals(recruitType)) {
            map.put("参加工作时间", resume.getBeginWorkDate());
            map.put("参加工作年限", resume.getWorkYear());
            validateNotEmpty(map, response);
            //校招,实习必填
        } else {
            map.put("高考省市", resume.getCeeProvince());
            map.put("高考年份", resume.getCeeYear());
            map.put("高考分数", resume.getCeeScore());
            map.put("是否一本分数线以上", resume.getIsFirstLine());
            map.put("文理科", resume.getArtsOrScience());
            map.put("录取批次", resume.getAdmissionOrder());
            validateNotEmpty(map, response);
        }

    }

    /**
     * 验证字段是否为空
     */
    private void validateNotEmpty(Map<String, Object> map, Response<?> response) {
        Set<String> fields = map.keySet();
        for (String field : fields) {
            if (StringUtils.isEmpty(map.get(field))) {
                response.setSuccess(false);
                response.setMessage(field + "不能为空");
                break;
            }
        }
    }

    @Transactional
    public String submit(Resume resume) {
        /*校验*/
        resume = resumeMapper.get(resume);
        if (resume == null) {
            return "简历不存在";
        }
        if (resume.getModifyTime() == null) {
            return "简历基本信息未保存";
        }
        String recruitType = resume.getRecruitType();
        if (recruitType == null) {
            return "简历招聘类型未知";
        } else {
            Integer resumeId = resume.getId();
            Integer educationCount = educationMapper.getCount(resumeId);
            Integer workCount = workMapper.getCount(resumeId);
            List<ResumeFamily> familyList = familyMapper.getList(resumeId);
            if (familyList == null || familyList.size() == 0) {
                return "未填写家庭关系";
            }
            if (educationCount == 0) {
                return "未填写教育经历";
            }
            if (Constants.RECRUIT_TYPE_SOCIETY.equals(recruitType)) {
                if (workCount == 0) {
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
