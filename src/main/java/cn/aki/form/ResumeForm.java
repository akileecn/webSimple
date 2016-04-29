package cn.aki.form;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import cn.aki.entity.Resume;

public class ResumeForm extends Resume{
	private static final long serialVersionUID = -4887993540675329767L;

	@NotBlank@Size(max=32)
	public String getName() {
		return super.getName();
	}
	@Size(max=32)
	public String getGender() {
		return super.getGender();
	}
	public Date getBirthday() {
		return super.getBirthday();
	}
	@Size(max=32)
	public String getNation() {
		return super.getNation();
	}
	public Integer getHeight() {
		return super.getHeight();
	}
	public Integer getWeight() {
		return super.getWeight();
	}
	@Size(max=32)
	public String getIdType() {
		return super.getIdType();
	}
	@Size(max=32)
	public String getIdNumber() {
		return super.getIdNumber();
	}
	@Size(max=32)
	public String getMarriage() {
		return super.getMarriage();
	}
	@Size(max=32)
	public String getPoliticsStatus() {
		return super.getPoliticsStatus();
	}
	public Date getJoinPartyDate() {
		return super.getJoinPartyDate();
	}
	@Size(max=32)
	public String getMobile() {
		return super.getMobile();
	}
	@Size(max=50)
	public String getEmail() {
		return super.getEmail();
	}
	@Size(max=32)
	public String getHighestEducation() {
		return super.getHighestEducation();
	}
	@Size(max=32)
	public String getHighestDegree() {
		return super.getHighestDegree();
	}
	public Date getGraduateDate() {
		return super.getGraduateDate();
	}
	@Size(max=32)
	public String getCeeProvince() {
		return super.getCeeProvince();
	}
	public Integer getCeeScore() {
		return super.getCeeScore();
	}
	public Boolean getIsFirstLine() {
		return super.getIsFirstLine();
	}
	@Size(max=32)
	public String getArtsOrScience() {
		return super.getArtsOrScience();
	}
	@Size(max=32)
	public String getAdmissionOrder() {
		return super.getAdmissionOrder();
	}
	@Size(max=32)
	public String getEmergencyContact() {
		return super.getEmergencyContact();
	}
	@Size(max=32)
	public String getEmergencyMobile() {
		return super.getEmergencyMobile();
	}
	public Integer getChildrenCount() {
		return super.getChildrenCount();
	}
	public Boolean getIsEelativeHere() {
		return super.getIsEelativeHere();
	}
	@Size(max=100)
	public String getCurrentResidence() {
		return super.getCurrentResidence();
	}
	@Size(max=100)
	public String getFamilyResidence() {
		return super.getFamilyResidence();
	}
	@Size(max=100)
	public String getNativePlace() {
		return super.getNativePlace();
	}
	@Size(max=100)
	public String getStudentOrigin() {
		return super.getStudentOrigin();
	}
	@Size(max=100)
	public String getRegisteredResidence() {
		return super.getRegisteredResidence();
	}
	@Size(max=500)
	public String getCertificate() {
		return super.getCertificate();
	}
	@Size(max=500)
	public String getHobby() {
		return super.getHobby();
	}
	@Size(max=500)
	public String getPersonality() {
		return super.getPersonality();
	}
	
}
