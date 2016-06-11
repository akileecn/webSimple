package cn.aki.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import cn.aki.entity.base.ResumeSubEntity;
import cn.aki.entity.translate.TranslateTypeCode;

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
	@TranslateTypeCode("cadreLevel")
	private String level;			//,level varchar(32) -- 级别
	private String certifier;		//,certifier varchar(32) -- 证明人
	private String certifierMobile;	//,certifier_mobile varchar(32) -- 证明人电话
	
	@NotNull
	public Date getBeginDate() {
		return beginDate;
	}
	@NotNull
	public Date getEndDate() {
		return endDate;
	}
	@Size(max=32)@NotBlank()
	public String getSchool() {
		return school;
	}
	@Size(max=32)@NotBlank()
	public String getName() {
		return name;
	}
	@Size(max=32)@NotBlank()
	public String getLevel() {
		return level;
	}
	@Size(max=32)
	public String getCertifier() {
		return certifier;
	}
	@Size(max=32)
	public String getCertifierMobile() {
		return certifierMobile;
	}
	
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public void setCertifier(String certifier) {
		this.certifier = certifier;
	}
	public void setCertifierMobile(String certifierMobile) {
		this.certifierMobile = certifierMobile;
	}

}
