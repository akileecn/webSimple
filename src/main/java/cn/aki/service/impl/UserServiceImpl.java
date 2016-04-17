package cn.aki.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.aki.dao.UserMapper;
import cn.aki.entity.User;
import cn.aki.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	public List<User> getList(User user) {
		return userMapper.getList(user);
	}

	public Page<User> getPage(int pageNum, int pageSize, User user) {
		Page<User> page=PageHelper.startPage(pageNum, pageSize, true);
		userMapper.getList(user);
		return page;
	}

}
