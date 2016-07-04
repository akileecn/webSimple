package cn.aki.service;

import java.util.Map;

import cn.aki.entity.StaticPage;
import cn.aki.entity.User;

/**
 * 邮件服务
 * @author Aki
 * 2016年6月28日 上午12:15:58
 */
public interface MailService {
	/**
	 * 发送邮件
	 * @param data 数据
	 * @param condition 模版查询条件
	 * @return
	 */
	boolean send(User user,StaticPage staticPage,Map<String, String> more);
}
