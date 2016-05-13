package cn.aki.utils;

import java.util.List;

import org.apache.shiro.SecurityUtils;

import cn.aki.entity.User;

/**
 * 用户工具类
 * @author aki
 * 2016年5月5日 上午11:36:16
 */
public class UserUtils {
	//shiro session中的属性
	public static final String SHIRO_SESSION_KEY_USER="user";//用户对象
	public static final String SHIRO_SESSION_KEY_RESUME_IDS="resumeIds";//简历ID
	/**
	 * 获得用户
	 * @return
	 */
	public static User getUser(){
		return (User)SecurityUtils.getSubject().getSession().getAttribute(SHIRO_SESSION_KEY_USER);
	}
	/**
	 * 获得用户ID
	 * @return
	 */
	public static Integer getUserId(){
		User user=getUser();
		if(user!=null){
			return user.getId();
		}
		return 0;
	}
	/**
	 * 使用拥有简历操作权限
	 * @return
	 */
	public static boolean hasResume(Integer resumeId){
		@SuppressWarnings("unchecked")
		List<Integer> ids=(List<Integer>) SecurityUtils.getSubject().getSession().getAttribute(SHIRO_SESSION_KEY_RESUME_IDS);
		if(ids!=null&&resumeId!=null){
			for(Integer id:ids){
				if(id.equals(resumeId)){
					return true;
				}
			}
		}
		return false;
	}
}
