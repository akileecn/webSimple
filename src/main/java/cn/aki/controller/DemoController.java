package cn.aki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.aki.form.UserLoginForm;

@Controller
@RequestMapping("/demo")
public class DemoController {

	@RequestMapping("/login")
	public String toDemo(Model model){
		model.addAttribute("userLoginForm", new UserLoginForm());
		return "login.jsp";
	}
}
