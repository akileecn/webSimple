package cn.aki.entity;

import java.util.Date;

import cn.aki.entity.base.ResumeSubEntity;

/**
 * 学生干部经历
 * @author aki
 * 2016年4月21日 下午7:21:42
 */
public class ResumeStudentCadre extends ResumeSubEntity{
	private static final long serialVersionUID = 875804192695265860L;
	private Date beginDate;			//,begin_date datetime -- 开始时间
	private Date endDate;			//,end_date datetime -- 结束时间
	private String school;			//,school varchar(32) -- 所在院校
	private String name;			//,name varchar(32) -- 干部名称
	private String level;			//,level varchar(32) -- 级别
	private String certifier;		//,certifier varchar(32) -- 证明人
	private String certifierMobile;	//,certifier_mobile varchar(32) -- 证明人电话

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
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
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
	
}
