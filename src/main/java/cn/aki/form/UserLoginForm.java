package cn.aki.form;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import cn.aki.entity.User;

/**
 * 用户登录表单
 * @author aki
 * 2016年4月6日 上午10:28:29
 */
public class UserLoginForm extends User{
	private static final long serialVersionUID = 7977609986583434106L;
	private String captcha;
	
	@NotBlank()
	@Size(max=50)
	public String getUsername() {
		return super.getUsername();
	}
	@NotBlank()
	@Pattern(regexp="^(?![^a-zA-Z]+$)(?!\\D+$).{6,20}$",message="{v.password}")
	public String getPassword() {
		return super.getPassword();
	}
	@NotBlank()
	@Size(min=4,max=4)
	public String getCaptcha() {
		return captcha;
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	
}
