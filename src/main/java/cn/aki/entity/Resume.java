package cn.aki.entity;

import java.util.Date;
import java.util.List;

/**
 * 简历主表
 * @author aki
 * 2016年4月19日 上午10:28:56
 */
public class Resume extends BaseEntity{
	private static final long serialVersionUID = -1238330598304598884L;
										//id int primary key auto_increment
	private Integer userId;				//,user_id int not null -- 用户ID
	private String name;				//,name varchar(32)	
	private String gender;				//,gender varchar(32)
	private Date birthday;				//,birthday timestamp
	private String nation;				//,nation varchar(32) -- 民族
	private Integer height;				//,height int
	private Integer weight;				//,weight int
	private String idType;				//,id_type varchar(32) -- 证件类型
	private String idNumber;			//,id_number varchar(32)
	private String marriage;			//,marriage varchar(32) -- 婚姻状况
	private String politicsStatus;		//,politics_status varchar(32) -- 政治面貌
	private Date joinPartyDate;			//,join_party_date timestamp -- 入党时间
	private String mobile;				//,mobile varchar(11)
	private String email;				//,email varchar(50)
	private String highestEducation;	//,highest_education varchar(32) -- 最高学历
	private String highestDegree;		//,highest_degree varchar(32) -- 最高学位
	private Date graduateDate;			//,graduate_date timestamp -- 毕业时间
	private String ceeProvince;			//,cee_province varchar(32) -- 高考省份
	private Integer ceeScore;			//,cee_score int -- 高考分数
	private Boolean isFirstLine;		//,is_first_line tinyint -- 是否一本分数线以上
	private String artsOrScience;		//,arts_or_science varchar(32) -- 文理科
	private String admissionOrder;		//,admission_order varchar(32) -- 录取批次
	private String emergencyContact;	//,emergency_contact varchar(32) -- 紧急联系人
	private String emergencyMobile;		//,emergency_mobile varchar(32) -- 紧急联系人电话
	private Integer childrenCount;		//,children_count int -- 子女
	private Boolean isEelativeHere;		//,is_relative_here tinyint -- 是否有亲友受雇与本公司
	private String currentResidence;	//,current_residence varchar(100) -- 现居住地址
	private String familyResidence;		//,family_residence varchar(100) -- 家庭住址
	private String nativePlace;			//,native_place varchar(100) -- 籍贯
	private String studentOrigin;		//,student_origin varchar(100) -- 生源地
	private String registeredResidence;	//,registered_residence varchar(100) -- 户口所在地
	private String certificate;			//,certificate varchar(500) -- 持证情况
	private String hobby;				//,hobby varchar(500) -- 爱好特长
	private String personality;			//,personality varchar(500) -- 性格特点
	
	/*关联*/
	private List<ResumeAward> awardList;
	private List<ResumeEducation> educationList;
	private List<ResumeFamily> familyList;
	private List<ResumeStudentCadre> studentCadreList;
	private List<ResumeWork> workList;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getMarriage() {
		return marriage;
	}
	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}
	public String getPoliticsStatus() {
		return politicsStatus;
	}
	public void setPoliticsStatus(String politicsStatus) {
		this.politicsStatus = politicsStatus;
	}
	public Date getJoinPartyDate() {
		return joinPartyDate;
	}
	public void setJoinPartyDate(Date joinPartyDate) {
		this.joinPartyDate = joinPartyDate;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHighestEducation() {
		return highestEducation;
	}
	public void setHighestEducation(String highestEducation) {
		this.highestEducation = highestEducation;
	}
	public String getHighestDegree() {
		return highestDegree;
	}
	public void setHighestDegree(String highestDegree) {
		this.highestDegree = highestDegree;
	}
	public Date getGraduateDate() {
		return graduateDate;
	}
	public void setGraduateDate(Date graduateDate) {
		this.graduateDate = graduateDate;
	}
	public String getCeeProvince() {
		return ceeProvince;
	}
	public void setCeeProvince(String ceeProvince) {
		this.ceeProvince = ceeProvince;
	}
	public Integer getCeeScore() {
		return ceeScore;
	}
	public void setCeeScore(Integer ceeScore) {
		this.ceeScore = ceeScore;
	}
	public Boolean getIsFirstLine() {
		return isFirstLine;
	}
	public void setIsFirstLine(Boolean isFirstLine) {
		this.isFirstLine = isFirstLine;
	}
	public String getArtsOrScience() {
		return artsOrScience;
	}
	public void setArtsOrScience(String artsOrScience) {
		this.artsOrScience = artsOrScience;
	}
	public String getAdmissionOrder() {
		return admissionOrder;
	}
	public void setAdmissionOrder(String admissionOrder) {
		this.admissionOrder = admissionOrder;
	}
	public String getEmergencyContact() {
		return emergencyContact;
	}
	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}
	public String getEmergencyMobile() {
		return emergencyMobile;
	}
	public void setEmergencyMobile(String emergencyMobile) {
		this.emergencyMobile = emergencyMobile;
	}
	public Integer getChildrenCount() {
		return childrenCount;
	}
	public void setChildrenCount(Integer childrenCount) {
		this.childrenCount = childrenCount;
	}
	public Boolean getIsEelativeHere() {
		return isEelativeHere;
	}
	public void setIsEelativeHere(Boolean isEelativeHere) {
		this.isEelativeHere = isEelativeHere;
	}
	public String getCurrentResidence() {
		return currentResidence;
	}
	public void setCurrentResidence(String currentResidence) {
		this.currentResidence = currentResidence;
	}
	public String getFamilyResidence() {
		return familyResidence;
	}
	public void setFamilyResidence(String familyResidence) {
		this.familyResidence = familyResidence;
	}
	public String getNativePlace() {
		return nativePlace;
	}
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	public String getStudentOrigin() {
		return studentOrigin;
	}
	public void setStudentOrigin(String studentOrigin) {
		this.studentOrigin = studentOrigin;
	}
	public String getRegisteredResidence() {
		return registeredResidence;
	}
	public void setRegisteredResidence(String registeredResidence) {
		this.registeredResidence = registeredResidence;
	}
	public String getCertificate() {
		return certificate;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getPersonality() {
		return personality;
	}
	public void setPersonality(String personality) {
		this.personality = personality;
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
	
}
