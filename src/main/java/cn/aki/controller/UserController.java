package cn.aki.controller;

import cn.aki.entity.User;
import cn.aki.form.*;
import cn.aki.response.FormResponse;
import cn.aki.response.SimpleResponse;
import cn.aki.service.MessageService;
import cn.aki.service.UserService;
import cn.aki.utils.Md5Utils;
import cn.aki.utils.UserUtils;
import com.alibaba.druid.util.StringUtils;
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
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Date;

/**
 * 用户控制层
 *
 * @author Aki
 *         2016年3月29日 上午12:24:54
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	@Autowired
	private ResourceBundleMessageSource messageSource;
	//	@Autowired
	private MessageService messageService;

	@ModelAttribute("userLoginForm")
	public UserLoginForm createUserLoginForm() {
		return new UserLoginForm();
	}

	//发送注册短信验证码
	@ResponseBody
	@RequestMapping(value = "/sendMessage/register", method = RequestMethod.POST)
	public SimpleResponse sendRegisterMessage(String mobile, String captcha) {
//		if(!UserUtils.isValidCaptcha(captcha)){
//			SimpleResponse response=new SimpleResponse();
//			response.setSuccess(false);
//			response.setMessage("验证码错误");
//			return response;
//		}
		return messageService.sendRegisterMessage(mobile);
	}

	//发送修改密码短信验证码
	@ResponseBody
	@RequestMapping(value = "/sendMessage/updatePassword", method = RequestMethod.POST)
	public SimpleResponse sendUpdatePasswordMessage(String mobile, String captcha) {
//		if(!UserUtils.isValidCaptcha(captcha)){
//			SimpleResponse response=new SimpleResponse();
//			response.setSuccess(false);
//			response.setMessage("验证码错误");
//			return response;
//		}
		return messageService.sendUpdatePasswordMessage(mobile);
	}

	//验证码图片
	@RequestMapping(value = "/captchaImage.png", method = RequestMethod.GET)
	public void createCaptchaImage(HttpServletResponse response) {
		UserUtils.createCaptcha(response);
	}

	//跳转到登录页面
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String toLogin() {
		return "user/login";
	}

	//登录操作
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public FormResponse<User> handleLogin(@Valid UserLoginForm form, BindingResult result) {
		FormResponse<User> response = handleFormError(result, form.getCaptcha());
		if (response.isSuccess()) {
			UsernamePasswordToken token = new UsernamePasswordToken(form.getUsername(), form.getPassword());
			token.setRememberMe(true);
			Subject subject = SecurityUtils.getSubject();
			try {
				subject.login(token);
			} catch (IncorrectCredentialsException ex) {
				//验证失败
				logger.info("{} 验证失败", form.getUsername());
				response.putError("username", messageSource.getMessage("shiro.incorrect", null, null));
			} catch (UnknownAccountException ex) {
				//其他异常
				logger.info("{} 未知异常", form.getUsername());
				response.putError("username", messageSource.getMessage("shiro.unknow", null, null));
			}
		}
		return response;
	}

	//跳转至注册
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String toRegister() {
		return "user/register";
	}

	//注册处理
	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public FormResponse<Void> handleRegister(@Valid UserRegisterForm form, BindingResult result) {
		FormResponse<Void> response = handleFormError(result, form.getCaptcha());
		if (response.isSuccess()) {
			//验证短信验证码
//			boolean isValid=messageService.isValidCaptcha(form.getMessageCaptcha(),form.getMobile());
//			if(!isValid){
//				response.putError("messageCaptcha", "短信验证码错误");
//			}else{
			//保存用户
			userService.save(form);
//			}
		}
		return response;
	}

	//跳转至修改密码
	@RequestMapping(value = "/updatePassword", method = RequestMethod.GET)
	public String toUpdatePassword() {
		return "user/updatePassword";
	}

	//修改密码
	@ResponseBody
	@RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
	public FormResponse<Void> handleUpdatePassword(@Valid UserUpdatePassworForm form, BindingResult result) {
		FormResponse<Void> response = handleFormError(result, form.getCaptcha());
		if (response.isSuccess()) {
			User user = UserUtils.getUser();
			if (Md5Utils.isEncrypted(form.getOldPassword(), user.getPassword())) {
				user.setModifyTime(new Date());
				//密码加密
				user.setPassword(Md5Utils.encrypt(form.getPassword()));
				userService.update(user);
				UserUtils.refreshUser(user);
			} else {
				response.putError("oldPassword", "密码不正确");
			}
		}
		return response;
	}

	//跳转至忘记密码
	@RequestMapping(value = "/forgetPassword", method = RequestMethod.GET)
	public String toForgetPassword() {
		return "user/forgetPassword";
	}

	@ResponseBody
	@RequestMapping(value = "/forgetPassword/userInfo")
	public FormResponse<User> getUserQuestion(String username, Model model) {
		FormResponse<User> response = new FormResponse<User>();
		if (StringUtils.isEmpty(username)) {
			response.putError("username", "用户名不能为空");
		} else {
			//user对象含密码，不能直接丢前台
			User user = userService.getByUsername(username);
			if (user != null) {
				User data = new User();
				data.setUsername(username);
				data.setQuestion(user.getQuestion());
				response.setData(data);
			} else {
				response.putError("username", "用户不存在");
			}
		}
		return response;

	}

	//密保问题找回密码
	@ResponseBody
	@RequestMapping(value = "/forgetPassword/byQuestion", method = RequestMethod.POST)
	public FormResponse<Void> handleForgetPassword(@Valid UserForgetPasswordForm form, BindingResult result) {
		FormResponse<Void> response = handleFormError(result, form.getCaptcha());
		if (response.isSuccess()) {
			User user = userService.getByUsername(form.getUsername());
			if (user == null) {
				response.putError("username", "用户不存在");
			} else if (user.getAnswer() == null) {
				response.putError("answer", "用户未设置答案");
			} else if (user.getAnswer().equals(form.getAnswer())) {
				user.setModifyTime(new Date());
				//密码加密
				user.setPassword(Md5Utils.encrypt(form.getPassword()));
				userService.update(user);
			} else {
				response.putError("answer", "问题答案不正确");
			}
		}
		return response;
	}

	//短信验证码找回密码
	@ResponseBody
	@RequestMapping(value = "/forgetPassword/byMobile", method = RequestMethod.POST)
	public FormResponse<Void> handleForgetPassword2(@Valid UserForgetPasswordForm2 form, BindingResult result) {
		FormResponse<Void> response = handleFormError(result, form.getCaptcha());
		if (response.isSuccess()) {
			User user = userService.getByUsername(form.getMobile());
			if (user == null) {
				response.putError("mobile", "用户不存在");
			} else if (messageService.isValidCaptcha(form.getMessageCaptcha(), form.getMobile())) {
				user.setModifyTime(new Date());
				//密码加密
				user.setPassword(Md5Utils.encrypt(form.getPassword()));
				userService.update(user);
			} else {
				response.putError("messageCaptcha", "短信验证码错误");
			}
		}
		return response;
	}

	@ResponseBody
	@RequestMapping(value = "/logout")
	public SimpleResponse handleLogout() {
		SimpleResponse response = new SimpleResponse();
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		response.setSuccess(true);
		return response;
	}

	/**
	 * 带验证码的校验
	 */
	private <T> FormResponse<T> handleFormError(BindingResult result, String captcha) {
		FormResponse<T> response = super.handleFormError(result);
		if (!UserUtils.isValidCaptcha(captcha)) {
			response.putError("captcha", "验证码错误");
		}
		return response;
	}

}
