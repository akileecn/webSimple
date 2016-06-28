package cn.aki.other;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import com.alibaba.fastjson.JSON;

import cn.aki.response.SimpleResponse;
import cn.aki.utils.Constants;

public class AjaxFormAuthenticationFilter extends FormAuthenticationFilter{

	@Override
	protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
		String requestType=((HttpServletRequest)request).getHeader("X-Requested-With");
		//如果是ajax请求
		if("XMLHttpRequest".equalsIgnoreCase(requestType)){
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json; charset=utf-8");
			SimpleResponse json=new SimpleResponse();
			json.setSuccess(false);
			json.setCode(Constants.ErrorCode.NOT_LOGIN);
			json.setMessage("请登录后操作");
			PrintWriter out=response.getWriter();
			out.println(JSON.toJSONString(json));
		}else{
			super.redirectToLogin(request, response);
		}
	}
	
}
