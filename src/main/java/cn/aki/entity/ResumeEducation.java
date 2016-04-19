package cn.aki.entity;
/**
 * 教育经历
 * @author aki
 * 2016年4月19日 上午10:40:23
 */
public class ResumeEducation extends BaseEntity{
	private static final long serialVersionUID = -3184168895563521363L;
	//id int primary key auto_increment
	private Integer remsumeId;//,remsume_id int not null
	private String schoolName;//,school_name varchar(32)
	private String major;//,major varchar(32)
	private String graduateType;//,graduate_type varchar(32) -- 毕业方式
	private String degree;//,degree varchar(32) -- 学位
	private String education;//,education varchar(32) -- 学历
	private String learnType;//,learn_type varchar(32) -- 学习形式
	private String beginEnd;//,begin_end varchar(32) -- 起止年月
	private String schoolType;//,school_type varchar(32) -- 学校类别
	private Boolean hasBeenCadre;//,has_been_cadre tinyint -- 是否担任过学生干部
	private String gradeRank;//,grade_rank varchar(32) -- 年级排名
	public Integer getRemsumeId() {
		return remsumeId;
	}
	public void setRemsumeId(Integer remsumeId) {
		this.remsumeId = remsumeId;
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
	public String getBeginEnd() {
		return beginEnd;
	}
	public void setBeginEnd(String beginEnd) {
		this.beginEnd = beginEnd;
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
