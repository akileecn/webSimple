package cn.aki.entity;

import java.util.Date;

import cn.aki.entity.base.ResumeSubEntity;

/**
 * 工作经历
 * @author aki
 * 2016年4月19日 上午11:09:44
 */
public class ResumeWork extends ResumeSubEntity{
	private static final long serialVersionUID = -1752143847655142682L;
	private String company;			//,company varchar(100)
	private String department;		//,department varchar(32)
	private String annualSalary;	//,annual_salary varchar(32) -- 年薪
	private String job;				//,job varchar(32)
	private String certifier;		//,certifier varchar(32) -- 证明人
	private String certifierMobile;	//,certifier_mobile varchar(32) -- 证明人电话
	private String workPlace;		//,work_place varchar(100) -- 工作地点
	private String jobType;			//,job_type varchar(32) -- 职位类型
	private String industry;		//,industry varchar(32) -- 行业
	private Date beginDate;			//,begin_date datetime -- 开始时间
	private Date endDate;			//,end_date datetime -- 结束时间
	private String dimissionReason;	//,dimission_reason varchar(500) -- 辞职理由
	private String duty;			//,duty varchar(500) -- 职责
	private String performance;		//,performance varchar(500) -- 业绩

	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getAnnualSalary() {
		return annualSalary;
	}
	public void setAnnualSalary(String annualSalary) {
		this.annualSalary = annualSalary;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getCertifier() {
		return certifier;
	}
	public void setCertifier(String certifier) {
		this.certifier = certifier;
	}
	public String getCertifierMobile() {
		return certifierMobile;
	}
	public void setCertifierMobile(String certifierMobile) {
		this.certifierMobile = certifierMobile;
	}
	public String getWorkPlace() {
		return workPlace;
	}
	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getDimissionReason() {
		return dimissionReason;
	}
	public void setDimissionReason(String dimissionReason) {
		this.dimissionReason = dimissionReason;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public String getPerformance() {
		return performance;
	}
	public void setPerformance(String performance) {
		this.performance = performance;
	}
	
}
