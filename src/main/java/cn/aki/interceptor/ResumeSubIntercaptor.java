package cn.aki.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.druid.util.StringUtils;

import cn.aki.utils.UserUtils;
/**
 * 简历操作拦截器
 * @author aki
 * 2016年5月16日 上午9:50:11
 */
public class ResumeSubIntercaptor extends HandlerInterceptorAdapter{
	private Logger logger=LoggerFactory.getLogger(ResumeSubIntercaptor.class);
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean pass=true;
		String resumeIdStr=request.getParameter("resumeId");
		if(!StringUtils.isEmpty(resumeIdStr)){
			try{
				Integer resumeId=Integer.parseInt(resumeIdStr);
				pass=UserUtils.hasResume(resumeId);
			}catch(NumberFormatException ex){
				pass=false;
			}
		}
		logger.info("resumeId={},pass={}",resumeIdStr,pass);
		return pass;
	}

}
