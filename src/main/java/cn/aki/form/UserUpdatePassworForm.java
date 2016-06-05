package cn.aki.form;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import cn.aki.entity.User;

public class UserUpdatePassworForm extends User{
	private static final long serialVersionUID = -6085578076561677077L;

	private String oldPassword;
	private String captcha;
	
	@NotBlank()
	public String getCaptcha() {
		return captcha;
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	@Override
	@NotBlank()@Pattern(regexp="^(?![^a-zA-Z]+$)(?!\\D+$)[a-zA-Z\\d]{6,20}$",message="{v.password}")
	public String getPassword() {
		return super.getPassword();
	}

	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	
	
}
