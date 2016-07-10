package cn.aki.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import cn.aki.dao.StaticPageMapper;
import cn.aki.entity.StaticPage;
import cn.aki.entity.User;
import cn.aki.service.MailService;
import cn.aki.utils.DateUtils;

//@Service("mailService")
@Deprecated
public class MailServiceImpl implements MailService{
	@Autowired
	private StaticPageMapper staticPageMapper;
	@Autowired
	private JavaMailSender javaMailSender;
	@Value("${mail.username}")
	private String from;

	public boolean send(User user,StaticPage staticPage,Map<String, String> data){
		staticPage=staticPageMapper.get(staticPage);
		if(staticPage==null){
			return false;
		}
		if(data==null){
			data=new HashMap<String, String>();
		}
		data.put("name", user.getName());
		data.put("time", DateUtils.formatDate(new Date()));
		MimeMessage message=javaMailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message);
		try {
			helper.setSubject(staticPage.getTitle());
			//发送人必须与授权帐号一致
			helper.setFrom(from);
			helper.setTo(user.getEmail());
			helper.setText(createText(data, staticPage.getContent()));
			javaMailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private String createText(Map<String, String> data,String template){
		Set<String> keys=data.keySet();
		for(String key:keys){
			template=template.replace("${"+key+"}", data.get(key));
		}
		return template;
	}
}
