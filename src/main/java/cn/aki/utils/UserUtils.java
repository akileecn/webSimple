package cn.aki.utils;

import cn.aki.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.patchca.color.SingleColorFactory;
import org.patchca.filter.predefined.CurvesRippleFilterFactory;
import org.patchca.service.Captcha;
import org.patchca.service.ConfigurableCaptchaService;
import org.patchca.word.AdaptiveRandomWordFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

/**
 * 用户工具类
 *
 * @author aki
 * 2016年5月5日 上午11:36:16
 */
public class UserUtils {
    private static final Logger logger = LoggerFactory.getLogger(UserUtils.class);

    /**
     * 获得用户
     */
    public static User getUser() {
        return (User) getAttribute(Constants.SessionKey.USER);
    }

    /**
     * 获得用户ID
     */
    public static Integer getUserId() {
        User user = getUser();
        if (user != null) {
            return user.getId();
        }
        return null;
    }

    /**
     * 是否拥有简历操作权限
     */
    public static boolean hasResume(Integer resumeId) {
        @SuppressWarnings("unchecked")
        List<Integer> ids = (List<Integer>) getAttribute(Constants.SessionKey.RESUME_IDS);
        if (ids != null && resumeId != null) {
            for (Integer id : ids) {
                if (id.equals(resumeId)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 创建验证码
     */
    public static void createCaptcha(HttpServletResponse response) {
        ConfigurableCaptchaService cs = new ConfigurableCaptchaService();
        cs.setColorFactory(new SingleColorFactory(new Color(25, 60, 170)));
        cs.setFilterFactory(new CurvesRippleFilterFactory(cs.getColorFactory()));
        AdaptiveRandomWordFactory wordFactory = new AdaptiveRandomWordFactory();
        wordFactory.setMinLength(4);
        wordFactory.setMaxLength(4);
        cs.setWordFactory(wordFactory);
        Captcha captcha = cs.getCaptcha();
        setAttribute(Constants.SessionKey.CAPTCHA, captcha.getChallenge());
        try {
            ImageIO.write(captcha.getImage(), "png", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 验证码是否正确
     */
    public static boolean isValidCaptcha(String captcha) {
        Session session = SecurityUtils.getSubject().getSession();
        String validCaptcha = (String) session.getAttribute(Constants.SessionKey.CAPTCHA);
        logger.debug(validCaptcha);
        boolean isValid = (captcha != null && captcha.equals(validCaptcha));
        //原验证码失效
        session.removeAttribute(Constants.SessionKey.CAPTCHA);
        return isValid;
    }

    /**
     * 刷新用户
     */
    public static void refreshUser(User user) {
        setAttribute(Constants.SessionKey.USER, user);
    }

    /**
     * 设置个人中心类型
     */
    public static void setUserCenterType(String recruitType) {
        setAttribute(Constants.SessionKey.USER_CENTER_TYPE, recruitType);
    }

    /**
     * 获取个人中心类型
     */
    public static String getUserCenterType() {
        return (String) getAttribute(Constants.SessionKey.USER_CENTER_TYPE);
    }

    /**
     * 设置用户属性
     */
    public static void setAttribute(String key, Object value) {
        SecurityUtils.getSubject().getSession().setAttribute(key, value);
    }

    /**
     * 获取用户属性
     */
    public static Object getAttribute(String key) {
        return SecurityUtils.getSubject().getSession().getAttribute(key);
    }
}
