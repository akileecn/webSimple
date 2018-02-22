package cn.aki.controller;

import cn.aki.entity.User;
import cn.aki.form.UserForgetPasswordForm;
import cn.aki.form.UserLoginForm;
import cn.aki.form.UserRegisterForm;
import cn.aki.form.UserUpdatePassworForm;
import cn.aki.service.NoticeService;
import cn.aki.service.UserService;
import cn.aki.utils.Md5Utils;
import cn.aki.utils.Response;
import cn.aki.utils.UserUtils;
import cn.aki.vo.LoginVO;
import com.alibaba.druid.util.StringUtils;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Date;

/**
 * 用户控制层
 *
 * @author Aki
 * 2016年3月29日 上午12:24:54
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private NoticeService noticeService;

    @ModelAttribute("userLoginForm")
    public UserLoginForm createUserLoginForm() {
        return new UserLoginForm();
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

    @ApiOperation("登录")
    @ResponseBody
    @PostMapping("/login")
    public Response<LoginVO> handleLogin(@Valid UserLoginForm form, BindingResult result) {
        Response<LoginVO> response = handleFormError(result, form.getCaptcha());
        if (response.getSuccess()) {
            UsernamePasswordToken token = new UsernamePasswordToken(form.getUsername(), form.getPassword());
            token.setRememberMe(true);
            Subject subject = SecurityUtils.getSubject();
            try {
                subject.login(token);
            } catch (IncorrectCredentialsException ex) {
                //验证失败
                logger.info("{} 验证失败", form.getUsername());
                response.setSuccess(false);
                response.setMessage(messageSource.getMessage("shiro.incorrect", null, null));
            } catch (UnknownAccountException ex) {
                //其他异常
                logger.info("{} 未知异常", form.getUsername());
                response.setSuccess(false);
                response.setMessage(messageSource.getMessage("shiro.unknow", null, null));
            }
        }
        LoginVO vo = new LoginVO();
        User user = UserUtils.getUser();
        vo.setName(user.getName());
        vo.setNoticeCount(noticeService.countNewByUserId(user.getId()));
        response.setData(vo);
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
    public Response<Void> handleRegister(@Valid UserRegisterForm form, BindingResult result) {
        Response<Void> response = handleFormError(result, form.getCaptcha());
        if (response.getSuccess()) {
            //保存用户
            userService.save(form);
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
    public Response<Void> handleUpdatePassword(@Valid UserUpdatePassworForm form, BindingResult result) {
        Response<Void> response = handleFormError(result, form.getCaptcha());
        if (response.getSuccess()) {
            User user = UserUtils.getUser();
            if (Md5Utils.isEncrypted(form.getOldPassword(), user.getPassword())) {
                user.setModifyTime(new Date());
                //密码加密
                user.setPassword(Md5Utils.encrypt(form.getPassword()));
                userService.update(user);
                UserUtils.refreshUser(user);
            } else {
                response.setSuccess(false);
                response.setMessage("密码不正确");
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
    public Response<User> getUserQuestion(String username) {
        Response<User> response = new Response<>();
        if (StringUtils.isEmpty(username)) {
            response.setSuccess(false);
            response.setMessage("用户名不能为空");
        } else {
            //user对象含密码，不能直接丢前台
            User user = userService.getByUsername(username);
            if (user != null) {
                User data = new User();
                data.setUsername(username);
                data.setQuestion(user.getQuestion());
                response.setData(data);
            } else {
                response.setSuccess(false);
                response.setMessage("用户不存在");
            }
        }
        return response;

    }

    //密保问题找回密码
    @ResponseBody
    @RequestMapping(value = "/forgetPassword/byQuestion", method = RequestMethod.POST)
    public Response<Void> handleForgetPassword(@Valid UserForgetPasswordForm form, BindingResult result) {
        Response<Void> response = handleFormError(result, form.getCaptcha());
        if (response.getSuccess()) {
            User user = userService.getByUsername(form.getUsername());
            if (user == null) {
                return Response.fail("用户不存在");
            } else if (user.getAnswer() == null) {
                return Response.fail("用户未设置答案");
            } else if (user.getAnswer().equals(form.getAnswer())) {
                user.setModifyTime(new Date());
                //密码加密
                user.setPassword(Md5Utils.encrypt(form.getPassword()));
                userService.update(user);
            } else {
                return Response.fail("问题答案不正确");
            }
        }
        return response;
    }

    @ResponseBody
    @PostMapping("/logout")
    public Response handleLogout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return Response.success();
    }

    /**
     * 带验证码的校验
     */
    private <T> Response<T> handleFormError(BindingResult result, String captcha) {
        Response<T> response = super.handleFormError(new Response<>(), result);
        //TODO 调试跳过验证码
//        if (!UserUtils.isValidCaptcha(captcha)) {
//            response.putError("captcha", "验证码错误");
//        }
        return response;
    }

}
