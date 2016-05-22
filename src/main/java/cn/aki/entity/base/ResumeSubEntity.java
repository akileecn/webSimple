package cn.aki.entity.base;

import cn.aki.entity.translate.Translatable;

/**
 * 简历所属标记
 * @author Aki
 * 2016年5月11日 上午12:21:05
 */
public abstract class ResumeSubEntity extends BaseEntity implements Translatable{
	private static final long serialVersionUID = 1983032552262203712L;
	private Integer resumeId;	//,resume_id int not null
	public Integer getResumeId() {
		return resumeId;
	}
	public void setResumeId(Integer resumeId) {
		this.resumeId = resumeId;
	}
}
