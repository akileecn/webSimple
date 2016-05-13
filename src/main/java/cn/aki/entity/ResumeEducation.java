package cn.aki.entity;

import java.util.Date;

import cn.aki.entity.base.BaseEntity;
import cn.aki.entity.base.ResumeSub;

/**
 * 教育经历
 * @author aki
 * 2016年4月19日 上午10:40:23
 */
public class ResumeEducation extends BaseEntity implements ResumeSub{
	private static final long serialVersionUID = -3184168895563521363L;
	private Integer resumeId;		//,resume_id int not null
	private String schoolName;		//,school_name varchar(32)
	private String major;			//,major varchar(32)
	private String graduateType;	//,graduate_type varchar(32) -- 毕业方式
	private String degree;			//,degree varchar(32) -- 学位
	private String education;		//,education varchar(32) -- 学历
	private String learnType;		//,learn_type varchar(32) -- 学习形式
	private Date beginDate;			//,begin_date datetime -- 开始时间
	private Date endDate;			//,end_date datetime -- 结束时间
	private String schoolType;		//,school_type varchar(32) -- 学校类别
	private Boolean hasBeenCadre;	//,has_been_cadre tinyint -- 是否担任过学生干部
	private String gradeRank;		//,grade_rank varchar(32) -- 年级排名

	public Integer getResumeId() {
		return resumeId;
	}
	public void setResumeId(Integer resumeId) {
		this.resumeId = resumeId;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getGraduateType() {
		return graduateType;
	}
	public void setGraduateType(String graduateType) {
		this.graduateType = graduateType;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getLearnType() {
		return learnType;
	}
	public void setLearnType(String learnType) {
		this.learnType = learnType;
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
	public String getSchoolType() {
		return schoolType;
	}
	public void setSchoolType(String schoolType) {
		this.schoolType = schoolType;
	}
	public Boolean getHasBeenCadre() {
		return hasBeenCadre;
	}
	public void setHasBeenCadre(Boolean hasBeenCadre) {
		this.hasBeenCadre = hasBeenCadre;
	}
	public String getGradeRank() {
		return gradeRank;
	}
	public void setGradeRank(String gradeRank) {
		this.gradeRank = gradeRank;
	}
	
}
