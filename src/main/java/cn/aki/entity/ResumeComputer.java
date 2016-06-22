package cn.aki.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import cn.aki.entity.base.ResumeSubEntity;
import cn.aki.entity.translate.TranslateTypeCode;
/**
 * 计算机
 * @author Aki
 * 2016年5月24日 上午12:16:20
 */
public class ResumeComputer extends ResumeSubEntity{
	private static final long serialVersionUID = -674855584330825786L;
	@TranslateTypeCode("computerCertificate")
	private String certificate;//,certificate nvarchar(32)
	private Date obtainDate;//,obtain_date datetime
	@TranslateTypeCode("computerProficiency")
	private String level;//,level nvarchar(32)
	private String detail;//,detail nvarchar(500)
	
	@Size(max=32)@NotBlank
	public String getCertificate() {
		return certificate;
	}
	@NotNull
	public Date getObtainDate() {
		return obtainDate;
	}
	@Size(max=32)@NotBlank
	public String getLevel() {
		return level;
	}
	@Size(max=500)
	public String getDetail() {
		return detail;
	}
	
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	public void setObtainDate(Date obtainDate) {
		this.obtainDate = obtainDate;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
}
