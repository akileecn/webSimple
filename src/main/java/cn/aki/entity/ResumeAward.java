package cn.aki.entity;

import java.util.Date;

import cn.aki.entity.base.ResumeSubEntity;

/**
 * 获奖经历
 * @author aki
 * 2016年4月21日 下午7:21:15
 */
public class ResumeAward extends ResumeSubEntity{
	private static final long serialVersionUID = 2140345429528353456L;
	private String name;		//,name varchar(32) -- 奖励名称
	private Date time;			//,time datetime -- 获得时间
	private String level;		//,level varchar(32) -- 级别
	private String description;	//,description varchar(500) -- 奖励描述
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
