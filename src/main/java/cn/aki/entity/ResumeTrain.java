package cn.aki.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import cn.aki.entity.base.ResumeSubEntity;
/**
 * 培训
 * @author Aki
 * 2016年6月15日 上午1:27:41
 */
public class ResumeTrain extends ResumeSubEntity{
	private static final long serialVersionUID = -6502839555761944495L;
	private Date beginDate;//,begin_date datetime -- 开始时间
	private Date endDate;//,end_date datetime -- 结束时间
	private String company;//,company nvarchar(100) -- 培训机构
	private String place;//,place nvarchar(100) -- 培训地点
	private String course;//,course nvarchar(32) --  培训课程
	private String description;//,description nvarchar(500) -- 详细描述
	
	@NotNull
	public Date getBeginDate() {
		return beginDate;
	}
	@NotNull
	public Date getEndDate() {
		return endDate;
	}
	@Size(max=100)@NotBlank
	public String getCompany() {
		return company;
	}
	@Size(max=100)@NotBlank
	public String getPlace() {
		return place;
	}
	@Size(max=32)@NotBlank
	public String getCourse() {
		return course;
	}
	@Size(max=500)@NotBlank
	public String getDescription() {
		return description;
	}
	
	
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
