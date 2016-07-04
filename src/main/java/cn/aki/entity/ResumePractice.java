package cn.aki.entity;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import cn.aki.entity.base.ResumeSubEntity;
import cn.aki.form.validator.BeginAndEndDate;
/**
 * 实践活动
 * @author Aki
 * 2016年6月15日 上午12:42:47
 */
public class ResumePractice extends ResumeSubEntity implements BeginAndEndDate{
	private static final long serialVersionUID = 6963448672229867451L;
	private String name;//,name nvarchar(100) -- 活动、公司名称
	private String job;//,job nvarchar(32) -- 职位
	private Date beginDate;//,begin_date datetime -- 开始时间
	private Date endDate;//,end_date datetime -- 结束时间
	private String duty;//,duty nvarchar(500) -- 职责
	
	@Size(max=100)@NotBlank
	public String getName() {
		return name;
	}
	@Size(max=32)
	public String getJob() {
		return job;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	@Size(max=500)
	public String getDuty() {
		return duty;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	
}
