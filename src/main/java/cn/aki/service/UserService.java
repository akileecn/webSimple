package cn.aki.service;

import cn.aki.entity.User;
import cn.aki.form.UserRegisterForm;

public interface UserService {
	/**
	 * 根据注册表单保存用户 
	 * @param form
	 */
	void save(UserRegisterForm form);
	/**
	 * 用户是否存在
	 * @param user
	 * @return
	 */
	boolean exists(User user);
}
