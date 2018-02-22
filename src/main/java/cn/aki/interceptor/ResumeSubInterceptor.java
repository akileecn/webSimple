package cn.aki.interceptor;

import cn.aki.utils.UserUtils;
import com.alibaba.druid.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 简历操作拦截器
 *
 * @author aki
 * 2016年5月16日 上午9:50:11
 */
public class ResumeSubInterceptor extends HandlerInterceptorAdapter {
    private Logger logger = LoggerFactory.getLogger(ResumeSubInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        boolean pass = true;
        String resumeIdStr = request.getParameter("resumeId");
        if (!StringUtils.isEmpty(resumeIdStr)) {
            try {
                Integer resumeId = Integer.parseInt(resumeIdStr);
                pass = UserUtils.hasResume(resumeId);
            } catch (NumberFormatException ex) {
                pass = false;
            }
        }
        logger.info("resumeId={},pass={}", resumeIdStr, pass);
        return pass;
    }

}
