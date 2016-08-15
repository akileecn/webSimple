package cn.aki.utils;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.patchca.color.SingleColorFactory;
import org.patchca.filter.predefined.CurvesRippleFilterFactory;
import org.patchca.service.Captcha;
import org.patchca.service.ConfigurableCaptchaService;
import org.patchca.word.AdaptiveRandomWordFactory;

import cn.aki.entity.User;

/**
 * 用户工具类
 * @author aki
 * 2016年5月5日 上午11:36:16
 */
public class UserUtils {
	/**
	 * 获得用户
	 * @return
	 */
	public static User getUser(){
		return (User)getAttribute(Constants.SessionKey.USER);
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
//		return 0;
		return null;
	}
	/**
	 * 是否拥有简历操作权限
	 * @return
	 */
	public static boolean hasResume(Integer resumeId){
		@SuppressWarnings("unchecked")
		List<Integer> ids=(List<Integer>)getAttribute(Constants.SessionKey.RESUME_IDS);
		if(ids!=null&&resumeId!=null){
			for(Integer id:ids){
				if(id.equals(resumeId)){
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * 创建验证码
	 * @return
	 */
	public static void createCaptcha(HttpServletResponse response){
		ConfigurableCaptchaService cs = new ConfigurableCaptchaService();
        cs.setColorFactory(new SingleColorFactory(new Color(25, 60, 170)));
        cs.setFilterFactory(new CurvesRippleFilterFactory(cs.getColorFactory()));
        AdaptiveRandomWordFactory wordFactory=new AdaptiveRandomWordFactory();
        wordFactory.setMinLength(4);
        wordFactory.setMaxLength(4);
        cs.setWordFactory(wordFactory);
        Captcha captcha=cs.getCaptcha();
        setAttribute(Constants.SessionKey.CAPTCHA, captcha.getChallenge());
        try {
			ImageIO.write(captcha.getImage(), "png", response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 验证码是否正确
	 * @param captcha
	 * @return
	 */
	public static boolean isValidCaptcha(String captcha){
		Session session=SecurityUtils.getSubject().getSession();
		String validCaptcha=(String) session.getAttribute(Constants.SessionKey.CAPTCHA);
		System.err.println(validCaptcha);
		boolean isValid=(captcha!=null&&captcha.equals(validCaptcha));
		//原验证码失效
		session.removeAttribute(Constants.SessionKey.CAPTCHA);
		return isValid;
	}
	
	/**
	 * 刷新用户
	 * @param user
	 */
	public static void refreshUser(User user){
		setAttribute(Constants.SessionKey.USER,user);
	}
	
	/**
	 * 设置个人中心类型
	 * @param recruitType
	 */
	public static void setUserCenterType(String recruitType){
		setAttribute(Constants.SessionKey.USER_CENTER_TYPE,recruitType);
	}
	
	/**
	 * 获取个人中心类型
	 * @return
	 */
	public static String getUserCenterType(){
		return (String)getAttribute(Constants.SessionKey.USER_CENTER_TYPE);
	}

	/**
	 * 设置用户属性
	 * @param key
	 * @param value
	 * 2016年8月15日下午4:44:17
	 */
	public static void setAttribute(String key,Object value){
		SecurityUtils.getSubject().getSession().setAttribute(key, value);
	}
	/**
	 * 获取用户属性
	 * @param key
	 * @return
	 * 2016年8月15日下午4:44:30
	 */
	public static Object getAttribute(String key){
		return SecurityUtils.getSubject().getSession().getAttribute(key);
	}
}
