package cn.aki.entity;

import java.util.Date;

/**
 * 计算机技能
 * @author aki
 * 2016年4月19日 上午11:07:44
 */
public class ResumeComputer extends BaseEntity{
	private static final long serialVersionUID = -6098243785297976087L;
								//id int primary key auto_increment
	private Integer remsumeId;	//,remsume_id int not null
	private String certificate;	//,certificate varchar(32)
	private Date obtainDate;	//,obtain_date timestamp
	private String level;		//,level varchar(32)
	private String detail;		//,detail varchar(500)
	public Integer getRemsumeId() {
		return remsumeId;
	}
	public void setRemsumeId(Integer remsumeId) {
		this.remsumeId = remsumeId;
	}
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
