package cn.aki.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import cn.aki.entity.base.ResumeSubEntity;
import cn.aki.entity.translate.TranslateTypeCode;
import cn.aki.form.validator.BeginAndEndDate;

/**
 * 工作经历
 * @author aki
 * 2016年4月19日 上午11:09:44
 */
public class ResumeWork extends ResumeSubEntity implements BeginAndEndDate{
	private static final long serialVersionUID = -1752143847655142682L;
	private String company;			//,company varchar(100)
	private String department;		//,department varchar(32)
	private String annualSalary;	//,annual_salary varchar(32) -- 年薪
	private String job;				//,job varchar(32)
	@Deprecated
	private String certifier;		//,certifier varchar(32) -- 证明人
	@Deprecated
	private String certifierMobile;	//,certifier_mobile varchar(32) -- 证明人电话
	private String workPlace;		//,work_place varchar(100) -- 工作地点
	@TranslateTypeCode
	private String jobType;			//,job_type varchar(32) -- 职位类型
	private String industry;		//,industry varchar(32) -- 行业
	private Date beginDate;			//,begin_date datetime -- 开始时间
	private Date endDate;			//,end_date datetime -- 结束时间
	private String dimissionReason;	//,dimission_reason varchar(500) -- 辞职理由
	private String duty;			//,duty varchar(500) -- 职责
	private String performance;		//,performance varchar(500) -- 业绩
	
	@Size(max=100)@NotBlank
	public String getCompany() {
		return company;
	}
	@Size(max=32)@NotBlank
	public String getDepartment() {
		return department;
	}
	@Size(max=32)@NotBlank
	public String getAnnualSalary() {
		return annualSalary;
	}
	@Size(max=32)@NotBlank
	public String getJob() {
		return job;
	}
	@Size(max=32)
	public String getCertifier() {
		return certifier;
	}
	@Size(max=32)
	public String getCertifierMobile() {
		return certifierMobile;
	}
	@Size(max=100)@NotBlank
	public String getWorkPlace() {
		return workPlace;
	}
	@Size(max=32)@NotBlank
	public String getJobType() {
		return jobType;
	}
	@Size(max=32)@NotBlank
	public String getIndustry() {
		return industry;
	}
	@NotNull
	public Date getBeginDate() {
		return beginDate;
	}
//	@NotNull
	public Date getEndDate() {
		return endDate;
	}
	@Size(max=500)@NotBlank
	public String getDimissionReason() {
		return dimissionReason;
	}
	@Size(max=500)@NotBlank
	public String getDuty() {
		return duty;
	}
	@Size(max=500)@NotBlank
	public String getPerformance() {
		return performance;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public void setAnnualSalary(String annualSalary) {
		this.annualSalary = annualSalary;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public void setCertifier(String certifier) {
		this.certifier = certifier;
	}
	public void setCertifierMobile(String certifierMobile) {
		this.certifierMobile = certifierMobile;
	}
	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public void setDimissionReason(String dimissionReason) {
		this.dimissionReason = dimissionReason;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public void setPerformance(String performance) {
		this.performance = performance;
	}

}
