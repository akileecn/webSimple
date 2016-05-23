package cn.aki.entity;

import cn.aki.entity.base.ResumeSubEntity;
import cn.aki.entity.translate.TranslateTypeCode;

/**
 * 家庭关系
 * @author aki
 * 2016年4月21日 下午7:21:30
 */
public class ResumeFamily extends ResumeSubEntity{
	private static final long serialVersionUID = 3688500831911368466L;
	private String name;		//,name varchar(32) -- 名称
	@TranslateTypeCode
	private String relationship;//,relationship varchar(32) -- 关系
	private String workCompany;	//,work_company varchar(100) -- 工作单位
	private String workJob;		//,work_job varchar(32) -- 职位
	private String description;	//,description varchar(500) -- 说明
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	public String getWorkCompany() {
		return workCompany;
	}
	public void setWorkCompany(String workCompany) {
		this.workCompany = workCompany;
	}
	public String getWorkJob() {
		return workJob;
	}
	public void setWorkJob(String workJob) {
		this.workJob = workJob;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
