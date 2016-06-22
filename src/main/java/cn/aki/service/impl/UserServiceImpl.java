package cn.aki.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.aki.dao.ResumeMapper;
import cn.aki.dao.UserMapper;
import cn.aki.entity.Resume;
import cn.aki.entity.User;
import cn.aki.form.UserRegisterForm;
import cn.aki.service.UserService;
import cn.aki.utils.Constants;
import cn.aki.utils.Md5Utils;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private ResumeMapper resumeMapper;
	
	@Transactional
	public void save(UserRegisterForm form) {
		//密码加密
		form.setPassword(Md5Utils.encrypt(form.getPassword()));
		form.setCreateTime(new Date());
		form.setModifyTime(new Date());
		userMapper.save(form);
		/*创建社招简历*/
		Resume societyResume=form.createResume();
		//id由mybatis保存的赋值
		societyResume.setUserId(form.getId());
		societyResume.setRecruitType(Constants.RECRUIT_TYPE_SOCIETY);
		/*创建校招简历*/
		Resume campusResume=form.createResume();
		campusResume.setUserId(form.getId());
		campusResume.setRecruitType(Constants.RECRUIT_TYPE_CAMPUS);
		/*创建实习生简历*/
		Resume traineeResume=form.createResume();
		traineeResume.setUserId(form.getId());
		traineeResume.setRecruitType(Constants.RECRUIT_TYPE_TRAINEE);
		resumeMapper.save(societyResume);
		resumeMapper.save(campusResume);
		resumeMapper.save(traineeResume);
	}

	public boolean exists(User user) {
		int count=userMapper.exists(user);
		return count>0;
	}

	public void update(User user) {
		userMapper.update(user);
	}

	public User getByUsername(String username) {
		return userMapper.getByUsername(username);
	}

}
