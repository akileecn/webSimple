package cn.aki.other;

import cn.aki.utils.Constants;
import cn.aki.utils.Response;
import com.alibaba.fastjson.JSON;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

public class AjaxFormAuthenticationFilter extends FormAuthenticationFilter {

    @Override
    protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
        String requestType = ((HttpServletRequest) request).getHeader("X-Requested-With");
        //如果是ajax请求
        if ("XMLHttpRequest".equalsIgnoreCase(requestType)) {
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json; charset=utf-8");
            Response json = new Response();
            json.setSuccess(false);
            json.setCode(Constants.ErrorCode.NOT_LOGIN);
            json.setMessage("请登录后操作");
            PrintWriter out = response.getWriter();
            out.println(JSON.toJSONString(json));
        } else {
            super.redirectToLogin(request, response);
        }
    }

}
