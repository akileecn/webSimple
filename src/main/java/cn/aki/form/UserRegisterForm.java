package cn.aki.form;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import cn.aki.form.validator.IdNumber;

/**
 * 用户注册表单
 * @author aki
 * 2016年4月22日 上午11:01:43
 */
public class UserRegisterForm {
	@NotBlank()@Size(max=50)@Email()
	private String email;//邮箱
	@NotBlank()@Size(max=32)@IdNumber()
	private String idNumber;//身份证号码
	@Pattern(regexp="^1\\d{10}$")
	private String mobile;//手机号码
	@NotBlank()@Size(max=100)
	private String question;//找回密码问题
	@NotBlank()@Size(max=100)
	private String answer;//答案
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
