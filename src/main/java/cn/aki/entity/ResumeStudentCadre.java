package cn.aki.entity;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import cn.aki.entity.base.ResumeSubEntity;
import cn.aki.entity.translate.TranslateTypeCode;
import cn.aki.form.validator.BeginAndEndDate;

/**
 * 学生干部经历
 * @author aki
 * 2016年4月21日 下午7:21:42
 */
public class ResumeStudentCadre extends ResumeSubEntity implements BeginAndEndDate{
	private static final long serialVersionUID = 875804192695265860L;
	private Date beginDate;			//,begin_date datetime -- 开始时间
	private Date endDate;			//,end_date datetime -- 结束时间
	private String name;			//,name varchar(32) -- 干部名称
	@TranslateTypeCode("cadreLevel")
	private String level;			//,level varchar(32) -- 级别
	private String description;//description nvarchar(500); -- 职责描述
	
	public Date getBeginDate() {
		return beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	@Size(max=32)@NotBlank
	public String getName() {
		return name;
	}
	@Size(max=32)
	public String getLevel() {
		return level;
	}
	@Size(max=500)
	public String getDescription() {
		return description;
	}
	
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
