package cn.aki.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 用户登录表单
 * @author aki
 * 2016年4月6日 上午10:28:29
 */
public class UserLoginForm {
	@NotBlank()
	@Size(max=50)
	private String username;
	@NotBlank()
	@Size(min=6,max=20)
	private String password;

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
	
}
