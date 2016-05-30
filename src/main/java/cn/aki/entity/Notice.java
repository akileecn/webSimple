package cn.aki.entity;

import java.util.Date;

import cn.aki.entity.base.BaseEntity;

public class Notice extends BaseEntity{
	private static final long serialVersionUID = 3310316156476345895L;
	private Integer userId;		//,user_id int not null -- 用户id
	private Date createTime;	//,create_time datetime -- 创建时间
	private String title;		//,title nvarchar(100) -- 标题
	private String content;		//,content nvarchar(1000) -- 内容
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
