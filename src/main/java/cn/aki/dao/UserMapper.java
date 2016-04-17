package cn.aki.dao;

import java.util.List;

import cn.aki.entity.User;

public interface UserMapper {
	List<User> getList(User user);
	User getByUsername(String username);
	/**
	 * 获得简单用户信息
	 * @param username
	 * @return
	 */
	User getSimpleByUsername(String username);
}
