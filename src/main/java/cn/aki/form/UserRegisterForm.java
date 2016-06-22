package cn.aki.form;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import cn.aki.entity.Resume;
import cn.aki.entity.User;
import cn.aki.form.validator.IdNumber;
import cn.aki.form.validator.UserUnique;

/**
 * 用户注册表单
 * @author aki
 * 2016年4月22日 上午11:01:43
 */
public class UserRegisterForm extends User{
	private static final long serialVersionUID = 3099193257950243875L;
	private String captcha;
	
	@NotBlank()
	public String getCaptcha() {
		return captcha;
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	@Override
	public String getUsername() {
		return super.getUsername();
	}
	@Override
	@NotBlank()@Pattern(regexp="^(?![^a-zA-Z]+$)(?!\\D+$)[a-zA-Z\\d]{6,16}$",message="{v.password}")
	public String getPassword() {
		return super.getPassword();
	}
	@Override
	@NotBlank()@Size(max=32)@IdNumber()@UserUnique(field="idNumber")
	public String getIdNumber() {
		return super.getIdNumber();
	}
	@Override
	@NotBlank()@Pattern(regexp="^1\\d{10}$",message="{v.mobile}")@UserUnique(field="mobile")
	public String getMobile() {
		return super.getMobile();
	}
	@Override
	@NotBlank()@Size(max=50)@Email()@UserUnique(field="email")
	public String getEmail() {
		return super.getEmail();
	}
	@Override
	@NotBlank()@Size(max=100)
	public String getQuestion() {
		return super.getQuestion();
	}
	@Override
	@NotBlank()@Size(max=100)
	public String getAnswer() {
		return super.getAnswer();
	}

	@Override
	@NotBlank()@Size(max=32)
	public String getName() {
		return super.getName();
	}
	
	/**
	 * 创建简历
	 * @return
	 */
	public Resume createResume(){
		Resume resume=new Resume();
		resume.setEmail(getEmail());
		resume.setIdNumber(getIdNumber());
		resume.setMobile(getMobile());
		//提取生日
		try {
			Date birthday=new SimpleDateFormat("yyyyMMdd").parse(getIdNumber().substring(6, 14));
			resume.setBirthday(birthday);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resume;
	}

}
