package cn.aki.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import cn.aki.entity.base.ResumeSubEntity;
import cn.aki.entity.translate.TranslateTypeCode;

/**
 * 教育经历
 * @author aki
 * 2016年4月19日 上午10:40:23
 */
public class ResumeEducation extends ResumeSubEntity{
	private static final long serialVersionUID = -3184168895563521363L;
	private String schoolName;		//,school_name varchar(32)
	private String major;			//,major varchar(32)
	@TranslateTypeCode
	private String graduateType;	//,graduate_type varchar(32) -- 毕业方式
	@TranslateTypeCode
	private String degree;			//,degree varchar(32) -- 学位
	@TranslateTypeCode
	private String education;		//,education varchar(32) -- 学历
	@TranslateTypeCode
	private String learnType;		//,learn_type varchar(32) -- 学习形式
	private Date beginDate;			//,begin_date datetime -- 开始时间
	private Date endDate;			//,end_date datetime -- 结束时间
	@TranslateTypeCode
	private String schoolType;		//,school_type varchar(32) -- 学校类别
	@TranslateTypeCode
	private Boolean hasBeenCadre;	//,has_been_cadre tinyint -- 是否担任过学生干部
	@TranslateTypeCode
	private String gradeRank;		//,grade_rank varchar(32) -- 年级排名
	@TranslateTypeCode
	private String schoolLocation;//school_location nvarchar(32); -- 学校位于城市或农村
	
	@Size(max=32)@NotBlank
	public String getSchoolName() {
		return schoolName;
	}
	@Size(max=32)@NotBlank
	public String getMajor() {
		return major;
	}
	@Size(max=32)@NotBlank
	public String getGraduateType() {
		return graduateType;
	}
	@Size(max=32)@NotBlank
	public String getDegree() {
		return degree;
	}
	@Size(max=32)@NotBlank
	public String getEducation() {
		return education;
	}
	@Size(max=32)@NotBlank
	public String getLearnType() {
		return learnType;
	}
	@NotNull
	public Date getBeginDate() {
		return beginDate;
	}
	@NotNull
	public Date getEndDate() {
		return endDate;
	}
	@Size(max=32)@NotBlank
	public String getSchoolType() {
		return schoolType;
	}
	public Boolean getHasBeenCadre() {
		return hasBeenCadre;
	}
	@Size(max=32)@NotBlank
	public String getGradeRank() {
		return gradeRank;
	}
	@Size(max=32)@NotBlank
	public String getSchoolLocation() {
		return schoolLocation;
	}
	
	
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public void setGraduateType(String graduateType) {
		this.graduateType = graduateType;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public void setLearnType(String learnType) {
		this.learnType = learnType;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public void setSchoolType(String schoolType) {
		this.schoolType = schoolType;
	}
	public void setHasBeenCadre(Boolean hasBeenCadre) {
		this.hasBeenCadre = hasBeenCadre;
	}
	public void setGradeRank(String gradeRank) {
		this.gradeRank = gradeRank;
	}
	public void setSchoolLocation(String schoolLocation) {
		this.schoolLocation = schoolLocation;
	}
	
}
