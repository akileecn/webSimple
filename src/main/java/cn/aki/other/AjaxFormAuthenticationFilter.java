package cn.aki.other;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class AjaxFormAuthenticationFilter extends FormAuthenticationFilter{

	@Override
	protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
		String requestType=((HttpServletRequest)request).getHeader("X-Requested-With");
		//如果是ajax请求
		if("XMLHttpRequest".equalsIgnoreCase(requestType)){
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json; charset=utf-8"); 
			String json="{\"success\":false,\"message\":\"请登录后操作\",\"error\":\"请登录后操作\"}";
			PrintWriter out=response.getWriter();
			out.println(json);
		}else{
			super.redirectToLogin(request, response);
		}
	}
	
}
