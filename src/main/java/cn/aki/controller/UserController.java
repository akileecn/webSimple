package cn.aki.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;

import cn.aki.entity.User;
import cn.aki.form.UserLoginForm;
import cn.aki.service.UserService;

/**
 * 用户控制层
 * @author Aki
 * 2016年3月29日 上午12:24:54
 */
@Controller
@RequestMapping("/user")
public class UserController {
	private final Logger logger=LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	
	@ModelAttribute("userLoginForm")
	public UserLoginForm createUserLoginForm(){
		return new UserLoginForm();
	}
	/**
	 * 用户列表
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model){
		Page<User> page=userService.getPage(1, 4, null);
		model.addAttribute("page", page);
		model.addAttribute("total",page.getTotal());
		return "user/list";
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
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String handleLogin(@Valid UserLoginForm userLoginForm,BindingResult result){
		final String FIELD_USERNAME="username";
		if(!result.hasErrors()){
			UsernamePasswordToken token=new UsernamePasswordToken(userLoginForm.getUsername(), userLoginForm.getPassword());
			token.setRememberMe(true);
			Subject subject=SecurityUtils.getSubject();
			try{
				subject.login(token);
				return "redirect:/home";
			}catch(IncorrectCredentialsException ex){
				//验证失败
				logger.info("{} 验证失败",userLoginForm.getUsername());
				result.rejectValue(FIELD_USERNAME, null, "验证失败");
			}catch(UnknownAccountException ex){
				//其他异常
				logger.info("{} 未知异常",userLoginForm.getUsername());
				result.rejectValue(FIELD_USERNAME, null, "未知异常");
			}
		}
		return "user/login";
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
	 * 文件上传
	 * @param file
	 * @param model
	 */
	@ResponseBody
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public Map<String, String> handleFileUpload(MultipartFile file,Model model){
		Map<String,String> result=new HashMap<String, String>();
		if(file!=null){
			String fileName=file.getOriginalFilename();
			result.put("message", "上传文件"+fileName);
		}else{
			result.put("message", "上传文件失败");
		}
		return result;
	}
}
