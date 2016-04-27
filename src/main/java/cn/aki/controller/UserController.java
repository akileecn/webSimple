package cn.aki.controller;

import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.aki.form.UserLoginForm;
import cn.aki.form.UserRegisterForm;
import cn.aki.response.FormResponse;
import cn.aki.service.UserService;

/**
 * 用户控制层
 * @author Aki
 * 2016年3月29日 上午12:24:54
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	private final Logger logger=LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	@Autowired
	private ResourceBundleMessageSource messageSource;
	
	@ModelAttribute("userLoginForm")
	public UserLoginForm createUserLoginForm(){
		return new UserLoginForm();
	}
	/**
	 * 跳转到登录页面
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String toLogin(){
		return "user/login";
	}
	/**
	 * 登录操作
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public FormResponse handleLogin(@Valid UserLoginForm userLoginForm,BindingResult result){
		FormResponse response=handleFormError(result);
		if(response.isSuccess()){
			UsernamePasswordToken token=new UsernamePasswordToken(userLoginForm.getUsername(), userLoginForm.getPassword());
			token.setRememberMe(true);
			Subject subject=SecurityUtils.getSubject();
			try{
				subject.login(token);
			}catch(IncorrectCredentialsException ex){
				//验证失败
				logger.info("{} 验证失败",userLoginForm.getUsername());
				response.putError("username", messageSource.getMessage("shiro.incorrect", null,null));
			}catch(UnknownAccountException ex){
				//其他异常
				logger.info("{} 未知异常",userLoginForm.getUsername());
				response.putError("username", messageSource.getMessage("shiro.unknow", null,null));
			}
		}
		return response;
	}
	/**
	 * 跳转至注册
	 * @return
	 */
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String toRegister(){
		return "user/register";
	}
	/**
	 * 注册处理
	 * @param userRegisterForm
	 * @param result
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public FormResponse handleRegister(@Valid UserRegisterForm userRegisterForm,BindingResult result){
		FormResponse response=handleFormError(result);
		if(response.isSuccess()){
			//保存用户
			userService.save(userRegisterForm);
		}
		return response;
	}
}
