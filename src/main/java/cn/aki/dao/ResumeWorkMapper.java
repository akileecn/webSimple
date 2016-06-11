package cn.aki.dao;

import cn.aki.entity.ResumeWork;

public interface ResumeWorkMapper extends BaseResumeSubMapper<ResumeWork>{
	Integer getCount(Integer resumeId);
}