package cn.aki.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 岗位
 * @author aki
 * 2016年4月15日 下午5:08:05
 */
public class Job implements Serializable{
	private static final long serialVersionUID = -448298364939140L;
	private Integer id;
	private String name;
	private String workYear;
	private String workCity;
	private String requirement;
	private String description;
	private Boolean disabled;
	private Date createTime;
	private Date modifyTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWorkYear() {
		return workYear;
	}
	public void setWorkYear(String workYear) {
		this.workYear = workYear;
	}
	public String getWorkCity() {
		return workCity;
	}
	public void setWorkCity(String workCity) {
		this.workCity = workCity;
	}
	public String getRequirement() {
		return requirement;
	}
	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getDisabled() {
		return disabled;
	}
	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	@Override
	public String toString() {
		return "Job [id=" + id + ", name=" + name + ", workYear=" + workYear + ", workCity=" + workCity
				+ ", requirement=" + requirement + ", description=" + description + ", disabled=" + disabled
				+ ", createTime=" + createTime + ", modifyTime=" + modifyTime + "]";
	}
	
}
