package cn.aki.entity;

import cn.aki.entity.base.BaseEntity;

/**
 * 密码找回问题
 * @author aki
 * 2016年4月22日 上午9:59:55
 */
public class UserPasswordQuestion extends BaseEntity{
	private static final long serialVersionUID = -7439883262971152960L;
	private Integer userId;		//,user_id int
	private String question;	//,question varchar(100) -- 问题
	private String answer;		//,answer varchar(100) -- 答案
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
}
