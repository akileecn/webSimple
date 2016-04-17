package cn.aki.test;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring/spring.xml"})
public class SpringMailTest {
	@Autowired
	private JavaMailSender javaMailSender;
	@Value("${mail.username}")
	private String from;
	
	@Test
	public void test(){
		MimeMessage message=javaMailSender.createMimeMessage();
		
		MimeMessageHelper helper=new MimeMessageHelper(message);
		try {
			helper.setSubject("测试主题");
			//发送人必须与授权帐号一致
			helper.setFrom(from);
			helper.setTo("416299889@qq.com");
			helper.setText("测试文本内容");
			javaMailSender.send(message);
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
		System.err.println("done");
	}
}
