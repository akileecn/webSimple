package cn.aki.service;

import java.util.List;

import com.github.pagehelper.Page;

import cn.aki.entity.User;

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
}
