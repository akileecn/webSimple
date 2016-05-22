package cn.aki.entity;

import java.util.Date;

import cn.aki.entity.base.BaseTimeEntity;
import cn.aki.entity.translate.Translatable;
import cn.aki.entity.translate.TranslateTypeCode;

/**
 * 岗位
 * @author aki
 * 2016年4月15日 下午5:08:05
 */
public class Job extends BaseTimeEntity implements Translatable{
	private static final long serialVersionUID = -448298364939140L;
	private String name;		//,name varchar(32)
	private String resumeType;	//,resume_type varchar(32) -- 招聘类型
	@TranslateTypeCode
	private String workYear;	//,work_year varchar(32) -- 工作年限
	@TranslateTypeCode
	private String workCity;	//,work_city varchar(32) -- 工作城市
	@TranslateTypeCode
	private String education;	//,education varchar(32) -- 学历
	private Date publishDate;	//,publish_date datetime -- 发布时间
	private Date endDate;		//,end_date datetime -- 截止时间
	private String peopleNumber;//,people_number int -- 人数
	private String requirement;	//,requirement varchar(500) -- 要求
	private String description;	//,description varchar(500) -- 描述
	private Boolean disabled;	//,disabled tinyint(1) default 0 -- 是否失效
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getResumeType() {
		return resumeType;
	}
	public void setResumeType(String resumeType) {
		this.resumeType = resumeType;
	}
	public String getWorkYear() {
		return workYear;
	}
	public void setWorkYear(String workYear) {
		this.workYear = workYear;
	}
	public String getWorkCity() {
		return workCity;
	}
	public void setWorkCity(String workCity) {
		this.workCity = workCity;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getPeopleNumber() {
		return peopleNumber;
	}
	public void setPeopleNumber(String peopleNumber) {
		this.peopleNumber = peopleNumber;
	}
	public String getRequirement() {
		return requirement;
	}
	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getDisabled() {
		return disabled;
	}
	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}
	
}
