package cn.aki.entity;

import java.util.Set;

import cn.aki.entity.base.BaseTimeEntity;
/**
 * 用户
 * @author aki
 * 2016年4月1日 上午9:25:56
 */
public class User extends BaseTimeEntity{
	private static final long serialVersionUID = 4316328239249215538L;
	private String username;	//,username varchar(32) -- 暂时不需要
	private String password;	//,password varchar(32) not null
	private String idNumber;	//,id_number varchar(32) -- 身份证号码
	private String mobile;		//,mobile varchar(32) -- 手机号码
	private String email;		//,email varchar(50) -- 邮箱
	private String question;	//,question varchar(100) -- 问题
	private String answer;		//,answer varchar(100) -- 答案
	
	/*关联*/
	private Set<Role> roles;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
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
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
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
