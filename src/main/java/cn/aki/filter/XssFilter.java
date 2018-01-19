package cn.aki.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
/**
 * 防xss攻击
 * @author Aki
 * 2016年7月10日 下午6:22:07
 */
@Component("xssFilter")
public class XssFilter extends GenericFilterBean{

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		XssHttpServletRequestWrapper xssRequest = new XssHttpServletRequestWrapper((HttpServletRequest) request);
		chain.doFilter(xssRequest, response);  
	}

	public static class XssHttpServletRequestWrapper extends HttpServletRequestWrapper{

		XssHttpServletRequestWrapper(HttpServletRequest request) {
			super(request);
		}

		@Override
		public String[] getParameterValues(String name) {
			String[] values=super.getParameterValues(name);
			if(values==null||values.length==0){
				return values;
			}
			String[] newValues=new String[values.length];
			for(int i=0;i<values.length;i++){
				newValues[i]=escapeHtml(values[0]);
			}
			return newValues;
		}
		
		/**
		 * 过滤特殊字符
		 * @param value
		 * @return
		 */
		private String escapeHtml(String value){
			if(value==null||value.isEmpty()){
				return value;
			}
			StringBuilder sb=new StringBuilder();
			for(int i=0;i<value.length();i++){
				switch (value.charAt(i)) {
				case '<':
					sb.append("&lt;");
					break;
				case '>':
					sb.append("&gt;");
					break;
				case '"':
					sb.append("&quot;");
					break;
				case '\'':
					sb.append("&apos;");
					break;
				case '&':
					sb.append("&amp;");
					break;
				default:
					sb.append(value.charAt(i));
					break;
				}
			}
			return sb.toString();
		}
	}
}
