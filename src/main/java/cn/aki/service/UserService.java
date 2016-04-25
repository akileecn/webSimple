package cn.aki.service;

import java.util.List;

import com.github.pagehelper.Page;

import cn.aki.entity.User;
import cn.aki.form.UserRegisterForm;

public interface UserService {
	List<User> getList(User user);
	/**
	 * 分页
	 * @param pageNum 起始页1开始
	 * @param pageSize 每页条数
	 * @param user
	 * @return
	 */
	Page<User> getPage(int pageNum,int pageSize,User user);
	/**
	 * 根据注册表单保存用户 
	 * @param form
	 */
	void save(UserRegisterForm form);
}
