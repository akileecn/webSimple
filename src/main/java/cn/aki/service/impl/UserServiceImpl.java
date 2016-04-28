package cn.aki.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.aki.dao.UserMapper;
import cn.aki.entity.User;
import cn.aki.form.UserRegisterForm;
import cn.aki.service.UserService;
import cn.aki.utils.Md5Utils;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	@Transactional
	public void save(UserRegisterForm form) {
		User user=form.createUser();
		//密码加密
		user.setPassword(Md5Utils.encrypt(user.getPassword()));
		userMapper.save(user);
	}

	public boolean exists(User user) {
		int count=userMapper.exists(user);
		return count>0;
	}

}
