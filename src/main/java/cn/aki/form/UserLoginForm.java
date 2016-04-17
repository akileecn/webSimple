package cn.aki.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 用户登录表单
 * @author aki
 * 2016年4月6日 上午10:28:29
 */
public class UserLoginForm {
	@NotBlank(message="用户名不能为空")
	@Size(min=3,max=20)
	private String username;
	
	@NotEmpty
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
