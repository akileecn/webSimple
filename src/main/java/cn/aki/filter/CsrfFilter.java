package cn.aki.filter;

import cn.aki.config.MyProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 跨站请求伪造简单拦截
 * @author Aki
 * 2016年7月10日 下午8:24:43
 */
@Component("csrfFilter")
public class CsrfFilter extends GenericFilterBean{
	@Autowired
	private MyProperties properties;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest=(HttpServletRequest) request;
		String referer=httpRequest.getHeader("Referer");
		String method=httpRequest.getMethod();
		if("POST".equals(method)){
			//对不是来源自本网站的请求做拦截
			if(referer==null||!referer.startsWith(properties.getRefererBase())){
				return;
			}
		}
		chain.doFilter(httpRequest, response);
	}

}
