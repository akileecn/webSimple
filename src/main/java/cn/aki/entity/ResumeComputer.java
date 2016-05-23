package cn.aki.entity;

import java.util.Date;

import cn.aki.entity.base.ResumeSubEntity;
/**
 * 计算机
 * @author Aki
 * 2016年5月24日 上午12:16:20
 */
public class ResumeComputer extends ResumeSubEntity{
	private static final long serialVersionUID = -674855584330825786L;
	private String certificate;//,certificate nvarchar(32)
	private Date obtainDate;//,obtain_date datetime
	private String level;//,level nvarchar(32)
	private String detail;//,detail nvarchar(500)
	public String getCertificate() {
		return certificate;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	public Date getObtainDate() {
		return obtainDate;
	}
	public void setObtainDate(Date obtainDate) {
		this.obtainDate = obtainDate;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
}
