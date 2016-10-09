package cn.aki.service.impl;

import java.util.Date;
import java.util.Random;

import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import com.jasson.im.api.APIClient;

import cn.aki.dao.StaticPageMapper;
import cn.aki.dao.UserMapper;
import cn.aki.entity.StaticPage;
import cn.aki.entity.User;
import cn.aki.other.MessageCaptcha;
import cn.aki.response.SimpleResponse;
import cn.aki.service.MessageService;
import cn.aki.utils.Constants;
import cn.aki.utils.UserUtils;

//@Service("messageService")
@Deprecated
public class MessageServiceImpl implements MessageService,InitializingBean{
	private final Logger logger=LoggerFactory.getLogger(MessageServiceImpl.class);
	/**默认发送时间间隔*/
	private static final long DEFAULT_INTERVAL=50*1000;
	/**短信的配置参数*/
	@Value("${message.host}")
	private String host;//短信服务器数据库地址
	@Value("${message.dbName}")
	private String dbName;//数据库名称
	@Value("${message.apiId}")
	private String apiId;//短信应用id
	@Value("${message.name}")
	private String name;//数据库登录名
	@Value("${message.pwd}")
	private String pwd;//数据库登录密码
	/**
	 * 发送短信的客户端
	 */
	private APIClient handler;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private StaticPageMapper staticPageMapper;
	
	public SimpleResponse sendRegisterMessage(String mobile) {
		return sendMessageCaptcha(mobile, Constants.StaticPageCode.MESSAGE_TEMPLATE_ATTR_REGISTER);
	}

	public SimpleResponse sendUpdatePasswordMessage(String mobile) {
		User user=userMapper.getByUsername(mobile);
		if(user==null){
			SimpleResponse response=new SimpleResponse();
			response.setSuccess(false);
			response.setMessage("用户不存在");
			return response;
		}
		return sendMessageCaptcha(mobile, Constants.StaticPageCode.MESSAGE_TEMPLATE_ATTR_UPDATE_PASSWORD);
	}
	
	public boolean isValidCaptcha(String code,String mobile) {
		MessageCaptcha captcha=(MessageCaptcha) UserUtils.getAttribute(Constants.SessionKey.MESSAGE_CAPTCHA);
		return (captcha!=null&&captcha.isValid(code,mobile));
	}
	
	/**
	 * 发送验证码短信
	 * @param mobile
	 * @param templateAttr
	 * @return
	 * 2016年8月15日下午4:38:31
	 */
	private SimpleResponse sendMessageCaptcha(String mobile,String templateAttr){
		//校验
		MessageCaptcha captcha=(MessageCaptcha) UserUtils.getAttribute(Constants.SessionKey.MESSAGE_CAPTCHA);
		if(captcha!=null&&((new Date().getTime()-captcha.getCreateTime())<DEFAULT_INTERVAL)){
			SimpleResponse response=new SimpleResponse();
			response.setSuccess(false);
			response.setMessage("短信发送过于频繁");
			return response;
		}
		//发送
		StaticPage template=new StaticPage();
		template.setCode(Constants.StaticPageCode.MESSAGE_TEMPLATE);
		template.setAttr(templateAttr);
		template=staticPageMapper.get(template);
		String content=template.getContent();
		captcha=MessageCaptcha.newInstance();
		captcha.setMobile(mobile);
		content=content.replace("${code}", captcha.getCode());
		UserUtils.setAttribute(Constants.SessionKey.MESSAGE_CAPTCHA, captcha);
		return send(mobile, content);
	}
	
	public SimpleResponse send(String mobile, String content) {
		SimpleResponse response=new SimpleResponse();
		if(mobile==null||!mobile.matches("^1\\d{10}$")){
			response.setSuccess(false);
			response.setMessage("手机号码格式不正确");
		}
		if(StringUtils.isEmpty(content)){
			response.setSuccess(false);
			response.setMessage("短信内容不能为空");
		}
		Random random = new Random();
		long smId = random.nextInt(1000);
		long srcId = random.nextInt(100);
		int result=1;
		try{
			result=handler.sendSM(new String[]{mobile},content,smId,srcId);
		}finally{
			logger.info("send:[mobile:{},content:{},smId:{},srcId:{},resultCode:{}]",mobile,content,smId,srcId,result);
		}
		switch (result) {
		case APIClient.IMAPI_SUCC:
			response.setSuccess(true);
			break;
		case APIClient.IMAPI_INIT_ERR:
			response.setSuccess(false);
			response.setCode(Integer.toString(result));
			response.setMessage("未初始化");
			break;
		case APIClient.IMAPI_CONN_ERR:
			response.setSuccess(false);
			response.setCode(Integer.toString(result));
			response.setMessage("数据库连接失败");
			break;
		case APIClient.IMAPI_DATA_ERR:
			response.setSuccess(false);
			response.setCode(Integer.toString(result));
			response.setMessage("参数错误");
			break;
		case APIClient.IMAPI_DATA_TOOLONG:
			response.setSuccess(false);
			response.setCode(Integer.toString(result));
			response.setMessage("消息内容太长");
			break;
		case APIClient.IMAPI_INS_ERR:
			response.setSuccess(false);
			response.setCode(Integer.toString(result));
			response.setMessage("数据库插入错误");
			break;
		default:
			response.setSuccess(false);
			response.setCode(Integer.toString(result));
			response.setMessage("出现其他错误");
			break;
		}
		return response;
	}
	
	/**
	 * 初始化
	 */
	public void afterPropertiesSet() throws Exception {
		handler=new APIClient();
		int connectRe = handler.init(host, name, pwd, apiId,dbName);
		switch (connectRe) {
		case APIClient.IMAPI_SUCC:
			logger.info("初始化成功");
			break;
		case APIClient.IMAPI_CONN_ERR:
			logger.error("连接失败");
			break;
		case APIClient.IMAPI_API_ERR:
			logger.error("apiID不存在");
			break;
		default:
			logger.error("位置错误");
			break;
		}
	}

	/**
	 * 销毁时释放资源
	 */
	@PreDestroy
	private void destroy(){
		if(handler!=null){
			handler.release();
		}
	}

}
