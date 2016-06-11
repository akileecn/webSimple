package cn.aki.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import cn.aki.entity.base.ResumeSubEntity;
import cn.aki.entity.translate.TranslateTypeCode;

/**
 * 获奖经历
 * @author aki
 * 2016年4月21日 下午7:21:15
 */
public class ResumeAward extends ResumeSubEntity{
	private static final long serialVersionUID = 2140345429528353456L;
	private String name;		//,name varchar(32) -- 奖励名称
	private Date time;			//,time datetime -- 获得时间
	@TranslateTypeCode("awardLevel")
	private String level;		//,level varchar(32) -- 级别
	private String description;	//,description varchar(500) -- 奖励描述
	
	@Size(max=32)@NotBlank()
	public String getName() {
		return name;
	}
	@NotNull
	public Date getTime() {
		return time;
	}
	@Size(max=32)
	public String getLevel() {
		return level;
	}
	@Size(max=500)
	public String getDescription() {
		return description;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
