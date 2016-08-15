package cn.aki.service;

import cn.aki.response.SimpleResponse;

public interface MessageService {
	/**
	 * 发送短信
	 * @return
	 */
	SimpleResponse send(String mobile,String content);
	/**
	 * 发送注册短信
	 * @param mobile
	 * @return
	 * 2016年8月15日下午4:12:51
	 */
	SimpleResponse sendRegisterMessage(String mobile);
	/**
	 * 发送修改密码短信
	 * @param mobile
	 * @return
	 * 2016年8月15日下午4:13:05
	 */
	SimpleResponse sendUpdatePasswordMessage(String mobile);
	/**
	 * 验证码是否正确
	 * @param code
	 * @return
	 * 2016年8月15日下午5:02:43
	 */
	boolean isValidCaptcha(String code);
}
