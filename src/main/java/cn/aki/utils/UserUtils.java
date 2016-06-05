package cn.aki.utils;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
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
	//shiro session中的属性
	public static final String SHIRO_SESSION_KEY_USER="user";//用户对象
	public static final String SHIRO_SESSION_KEY_RESUME_IDS="resumeIds";//简历ID
	public static final String SHIRO_SESSION_KEY_CAPTCHA="captcha";//图片验证码
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
	 * 是否拥有简历操作权限
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
	/**
	 * 获得用户的简历Id
	 * @return
	 */
	public static Integer getResumeId(){
		@SuppressWarnings("unchecked")
		List<Integer> ids=(List<Integer>) SecurityUtils.getSubject().getSession().getAttribute(SHIRO_SESSION_KEY_RESUME_IDS);
		if(ids!=null&&ids.size()>0){
			return ids.get(0);
		}
		return 1;
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
        SecurityUtils.getSubject().getSession().setAttribute(SHIRO_SESSION_KEY_CAPTCHA, captcha.getChallenge());
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
		String validCaptcha=(String) SecurityUtils.getSubject().getSession().getAttribute(SHIRO_SESSION_KEY_CAPTCHA);
		System.err.println(validCaptcha);
		return (captcha!=null&&captcha.equals(validCaptcha));
	}
	
	/**
	 * 刷新用户
	 * @param user
	 */
	public static void refreshUser(User user){
		SecurityUtils.getSubject().getSession().setAttribute(SHIRO_SESSION_KEY_USER,user);
	}
}
