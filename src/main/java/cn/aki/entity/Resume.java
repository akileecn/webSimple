package cn.aki.entity;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import cn.aki.entity.base.BaseTimeEntity;
import cn.aki.entity.base.UserSub;
import cn.aki.entity.translate.Translatable;
import cn.aki.entity.translate.TranslateTypeCode;
import cn.aki.form.validator.IdNumber;

/**
 * 简历主表
 * @author aki
 * 2016年4月19日 上午10:28:56
 */
public class Resume extends BaseTimeEntity implements UserSub,Translatable{
	private static final long serialVersionUID = -1238330598304598884L;
	private Integer userId;				//,user_id int not null -- 用户ID
	private String name;				//,name varchar(32)	
	@TranslateTypeCode
	private String gender;				//,gender varchar(32)
	private Date birthday;				//,birthday timestamp
	@TranslateTypeCode
	private String nation;				//,nation varchar(32) -- 民族
	private Integer height;				//,height int
	private Integer weight;				//,weight int
	private String idType;				//,id_type varchar(32) -- 证件类型
	private String idNumber;			//,id_number varchar(32)
	@TranslateTypeCode
	private String marriage;			//,marriage varchar(32) -- 婚姻状况
	@TranslateTypeCode
	private String politicsStatus;		//,politics_status varchar(32) -- 政治面貌
	private Date joinPartyDate;			//,join_party_date timestamp -- 入党时间
	private String mobile;				//,mobile varchar(11)
	private String email;				//,email varchar(50)
	@TranslateTypeCode
	private String highestEducation;	//,highest_education varchar(32) -- 最高学历
	@TranslateTypeCode("degree")
	private String highestDegree;		//,highest_degree varchar(32) -- 最高学位
	private Date graduateDate;			//,graduate_date timestamp -- 毕业时间
	private String ceeProvince;			//,cee_province varchar(32) -- 高考省份
	private Integer ceeScore;			//,cee_score int -- 高考分数
	@TranslateTypeCode
	private Boolean isFirstLine;		//,is_first_line tinyint -- 是否一本分数线以上
	@TranslateTypeCode
	private String artsOrScience;		//,arts_or_science varchar(32) -- 文理科
	@TranslateTypeCode
	private String admissionOrder;		//,admission_order varchar(32) -- 录取批次
	private String emergencyContact;	//,emergency_contact varchar(32) -- 紧急联系人
	private String emergencyMobile;		//,emergency_mobile varchar(32) -- 紧急联系人电话
	@Deprecated
	private Integer childrenCount;		//,children_count int -- 子女
	@TranslateTypeCode
	private Boolean isRelativeHere;		//,is_relative_here tinyint -- 是否有亲友受雇与本公司
	private String currentResidence;	//,current_residence varchar(100) -- 现居住地址
	private String familyResidence;		//,family_residence varchar(100) -- 家庭住址
	private String nativePlace;			//,native_place varchar(100) -- 籍贯
	@Deprecated
	private String studentOrigin;		//,student_origin varchar(100) -- 生源地
	private String registeredResidence;	//,registered_residence varchar(100) -- 户口所在地
	private String certificate;			//,certificate varchar(500) -- 持证情况
	private String hobby;				//,hobby varchar(500) -- 爱好特长
	private String personality;			//,personality varchar(500) -- 性格特点
	@TranslateTypeCode
	private String workYear;//,work_year varchar(32) -- 工作年前
	@TranslateTypeCode
	@Deprecated
	private String workCity;//,work_city varchar(32) -- 期望工作城市
	@TranslateTypeCode
	@Deprecated
	private String health;//,health varchar(32) -- 健康
//	private String photo;	//头像
	private byte[] photo;
	
	@TranslateTypeCode
	private String recruitType;	//招聘类型
	/*20160614*/
	private Date beginWorkDate;//begin_work_date datetime;-- 参加工作时间
	private Date beginSchoolDate;//begin_school_date datetime;-- 开始时间
	private String school;//school nvarchar(100);-- 毕业院校
	@TranslateTypeCode
	private String schoolType;//school_type nvarchar(32);-- 院校类别
	private String major;//nvarchar(32);-- 专业
	/*20160619*/
	private Boolean isSubmit;//is_submit bit not null default 0; -- 是否提交
	private Boolean isLocked;//is_lock bit not null default 0; -- 是否锁定
	
	/*关联*/
	@TranslateTypeCode
	private List<ResumeAward> awardList;
	@TranslateTypeCode
	private List<ResumeEducation> educationList;
	@TranslateTypeCode
	private List<ResumeFamily> familyList;
	@TranslateTypeCode
	private List<ResumeStudentCadre> studentCadreList;
	@TranslateTypeCode
	private List<ResumeWork> workList;
	@TranslateTypeCode
	private List<ResumeComputer> computerList;
	@TranslateTypeCode
	private List<ResumeForeignLanguage> foreignLanguageList;
	private List<ResumePractice> practiceList;
	private List<ResumeTrain> trainList;
	
	public Integer getUserId() {
		return userId;
	}
	@NotBlank@Size(max=32)
	public String getName() {
		return name;
	}
	@NotBlank@Size(max=32)
	public String getGender() {
		return gender;
	}
	@NotNull
	public Date getBirthday() {
		return birthday;
	}
	@NotBlank@Size(max=32)
	public String getNation() {
		return nation;
	}
	@NotNull
	public Integer getHeight() {
		return height;
	}
	@NotNull
	public Integer getWeight() {
		return weight;
	}
	@Size(max=32)
	public String getIdType() {
		return idType;
	}
	@NotBlank@Size(max=32)@IdNumber()
	public String getIdNumber() {
		return idNumber;
	}
	@NotBlank@Size(max=32)
	public String getMarriage() {
		return marriage;
	}
	@NotBlank@Size(max=32)
	public String getPoliticsStatus() {
		return politicsStatus;
	}
	public Date getJoinPartyDate() {
		return joinPartyDate;
	}
	@NotBlank@Size(max=32)@Pattern(regexp="^1\\d{10}$",message="{v.mobile}")
	public String getMobile() {
		return mobile;
	}
	@NotBlank@Size(max=50)
	public String getEmail() {
		return email;
	}
	@NotBlank@Size(max=32)
	public String getHighestEducation() {
		return highestEducation;
	}
	@NotBlank@Size(max=32)
	public String getHighestDegree() {
		return highestDegree;
	}
	@NotNull
	public Date getGraduateDate() {
		return graduateDate;
	}
	@Size(max=32)
	public String getCeeProvince() {
		return ceeProvince;
	}
	public Integer getCeeScore() {
		return ceeScore;
	}
	public Boolean getIsFirstLine() {
		return isFirstLine;
	}
	@Size(max=32)
	public String getArtsOrScience() {
		return artsOrScience;
	}
	@Size(max=32)
	public String getAdmissionOrder() {
		return admissionOrder;
	}
	@NotBlank@Size(max=32)
	public String getEmergencyContact() {
		return emergencyContact;
	}
	@NotBlank@Size(max=32)@Pattern(regexp="^1\\d{10}$",message="{v.mobile}")
	public String getEmergencyMobile() {
		return emergencyMobile;
	}
	public Integer getChildrenCount() {
		return childrenCount;
	}
	@NotNull
	public Boolean getIsRelativeHere() {
		return isRelativeHere;
	}
	@NotBlank@Size(max=100)
	public String getCurrentResidence() {
		return currentResidence;
	}
	@NotBlank@Size(max=100)
	public String getFamilyResidence() {
		return familyResidence;
	}
	@NotBlank@Size(max=100)
	public String getNativePlace() {
		return nativePlace;
	}
	@Size(max=100)
	public String getStudentOrigin() {
		return studentOrigin;
	}
	@NotBlank@Size(max=100)
	public String getRegisteredResidence() {
		return registeredResidence;
	}
	@Size(max=500)
	public String getCertificate() {
		return certificate;
	}
	@Size(max=500)
	public String getHobby() {
		return hobby;
	}
	@Size(max=500)
	public String getPersonality() {
		return personality;
	}
	@Size(max=32)
	public String getWorkYear() {
		return workYear;
	}
	@Size(max=32)
	public String getWorkCity() {
		return workCity;
	}
	@Size(max=32)
	public String getHealth() {
		return health;
	}
	public String getRecruitType() {
		return recruitType;
	}
	public Date getBeginWorkDate() {
		return beginWorkDate;
	}
	@NotNull
	public Date getBeginSchoolDate() {
		return beginSchoolDate;
	}
	@Size(max=100)@NotBlank
	public String getSchool() {
		return school;
	}
	@Size(max=32)@NotBlank
	public String getSchoolType() {
		return schoolType;
	}
	@Size(max=32)@NotBlank
	public String getMajor() {
		return major;
	}
	
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}
	public void setPoliticsStatus(String politicsStatus) {
		this.politicsStatus = politicsStatus;
	}
	public void setJoinPartyDate(Date joinPartyDate) {
		this.joinPartyDate = joinPartyDate;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setHighestEducation(String highestEducation) {
		this.highestEducation = highestEducation;
	}
	public void setHighestDegree(String highestDegree) {
		this.highestDegree = highestDegree;
	}
	public void setGraduateDate(Date graduateDate) {
		this.graduateDate = graduateDate;
	}
	public void setCeeProvince(String ceeProvince) {
		this.ceeProvince = ceeProvince;
	}
	public void setCeeScore(Integer ceeScore) {
		this.ceeScore = ceeScore;
	}
	public void setIsFirstLine(Boolean isFirstLine) {
		this.isFirstLine = isFirstLine;
	}
	public void setArtsOrScience(String artsOrScience) {
		this.artsOrScience = artsOrScience;
	}
	public void setAdmissionOrder(String admissionOrder) {
		this.admissionOrder = admissionOrder;
	}
	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}
	public void setEmergencyMobile(String emergencyMobile) {
		this.emergencyMobile = emergencyMobile;
	}
	public void setChildrenCount(Integer childrenCount) {
		this.childrenCount = childrenCount;
	}
	public void setIsRelativeHere(Boolean isRelativeHere) {
		this.isRelativeHere = isRelativeHere;
	}
	public void setCurrentResidence(String currentResidence) {
		this.currentResidence = currentResidence;
	}
	public void setFamilyResidence(String familyResidence) {
		this.familyResidence = familyResidence;
	}
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	public void setStudentOrigin(String studentOrigin) {
		this.studentOrigin = studentOrigin;
	}
	public void setRegisteredResidence(String registeredResidence) {
		this.registeredResidence = registeredResidence;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public void setPersonality(String personality) {
		this.personality = personality;
	}
	public void setWorkYear(String workYear) {
		this.workYear = workYear;
	}
	public void setWorkCity(String workCity) {
		this.workCity = workCity;
	}
	public void setHealth(String health) {
		this.health = health;
	}
	public void setRecruitType(String recruitType) {
		this.recruitType = recruitType;
	}
	public void setBeginWorkDate(Date beginWorkDate) {
		this.beginWorkDate = beginWorkDate;
	}
	public void setBeginSchoolDate(Date beginSchoolDate) {
		this.beginSchoolDate = beginSchoolDate;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public void setSchoolType(String schoolType) {
		this.schoolType = schoolType;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public Boolean getIsSubmit() {
		return isSubmit;
	}
	public void setIsSubmit(Boolean isSubmit) {
		this.isSubmit = isSubmit;
	}
	public Boolean getIsLocked() {
		return isLocked;
	}
	public void setIsLocked(Boolean isLocked) {
		this.isLocked = isLocked;
	}
	public List<ResumeAward> getAwardList() {
		return awardList;
	}
	public void setAwardList(List<ResumeAward> awardList) {
		this.awardList = awardList;
	}
	public List<ResumeEducation> getEducationList() {
		return educationList;
	}
	public void setEducationList(List<ResumeEducation> educationList) {
		this.educationList = educationList;
	}
	public List<ResumeFamily> getFamilyList() {
		return familyList;
	}
	public void setFamilyList(List<ResumeFamily> familyList) {
		this.familyList = familyList;
	}
	public List<ResumeStudentCadre> getStudentCadreList() {
		return studentCadreList;
	}
	public void setStudentCadreList(List<ResumeStudentCadre> studentCadreList) {
		this.studentCadreList = studentCadreList;
	}
	public List<ResumeWork> getWorkList() {
		return workList;
	}
	public void setWorkList(List<ResumeWork> workList) {
		this.workList = workList;
	}
	public List<ResumeComputer> getComputerList() {
		return computerList;
	}
	public void setComputerList(List<ResumeComputer> computerList) {
		this.computerList = computerList;
	}
	public List<ResumeForeignLanguage> getForeignLanguageList() {
		return foreignLanguageList;
	}
	public void setForeignLanguageList(List<ResumeForeignLanguage> foreignLanguageList) {
		this.foreignLanguageList = foreignLanguageList;
	}
	public List<ResumePractice> getPracticeList() {
		return practiceList;
	}
	public void setPracticeList(List<ResumePractice> practiceList) {
		this.practiceList = practiceList;
	}
	public List<ResumeTrain> getTrainList() {
		return trainList;
	}
	public void setTrainList(List<ResumeTrain> trainList) {
		this.trainList = trainList;
	}
	
}
