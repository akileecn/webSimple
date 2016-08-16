package cn.aki.form;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 根据短信验证码找回密码
 * @author Aki
 * 2016年8月16日下午5:13:33
 */
public class UserForgetPasswordForm2 {
	private String mobile;
	private String messageCaptcha;
	private String password;
	private String captcha;
	@NotBlank()
	public String getMobile() {
		return mobile;
	}
	@NotBlank()
	public String getMessageCaptcha() {
		return messageCaptcha;
	}
	@NotBlank()@Pattern(regexp="^(?![^a-zA-Z]+$)(?!\\D+$)[a-zA-Z\\d]{6,20}$",message="{v.password}")
	public String getPassword() {
		return password;
	}
	@NotBlank()
	public String getCaptcha() {
		return captcha;
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public void setMessageCaptcha(String messageCaptcha) {
		this.messageCaptcha = messageCaptcha;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
