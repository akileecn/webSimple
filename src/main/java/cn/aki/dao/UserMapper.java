package cn.aki.dao;

import cn.aki.entity.User;

public interface UserMapper {
	/**
	 * 获得用户账户基本信息(用户名,密码)
	 * @param username
	 * @return
	 */
	User getByUsername(String username);
	/**
	 * 获得用户授权信息(密码,角色,权限)
	 */
	User getAuthByUsername(String username);
	void save(User user);
	/**
	 * 判断用户是否存在
	 * @param user
	 * @return 用户个数
	 */
	int exists(User user);
	void update(User user);
	
}
