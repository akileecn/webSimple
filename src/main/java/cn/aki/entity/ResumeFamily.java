package cn.aki.entity;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

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
	@TranslateTypeCode("politicsStatus")
	private String description;	//,description varchar(500) -- 说明
	
	@Size(max=32)@NotBlank
	public String getName() {
		return name;
	}
	@Size(max=32)@NotBlank
	public String getRelationship() {
		return relationship;
	}
	@Size(max=32)
	public String getWorkCompany() {
		return workCompany;
	}
	@Size(max=100)
	public String getWorkJob() {
		return workJob;
	}
	@Size(max=500)
	public String getDescription() {
		return description;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	public void setWorkCompany(String workCompany) {
		this.workCompany = workCompany;
	}
	public void setWorkJob(String workJob) {
		this.workJob = workJob;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
