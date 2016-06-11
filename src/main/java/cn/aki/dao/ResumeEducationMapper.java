package cn.aki.dao;

import cn.aki.entity.ResumeEducation;

public interface ResumeEducationMapper extends BaseResumeSubMapper<ResumeEducation>{
	Integer getCount(Integer resumeId);
}