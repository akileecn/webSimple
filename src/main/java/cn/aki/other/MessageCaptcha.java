package cn.aki.other;

import java.util.Date;
import java.util.Random;
/**
 * 短信验证码
 * @author Aki
 * 2016年8月15日下午3:16:38
 */
public class MessageCaptcha {
	private String mobile;//手机号码
	private String code;//验证码
	private long createTime;//创建时间
	private long validTime;//有效时间(毫秒)
	private static final long DEFAULT_VALID_TIME=3*60*1000L;//默认有效时间3分钟
	
	private MessageCaptcha() {
	}
	public static MessageCaptcha newInstance(){
		return newInstance(DEFAULT_VALID_TIME);
	}
	/**
	 * 创建短信验证码
	 * @param validTime 有效时间
	 * @return
	 * 2016年8月15日下午4:00:52
	 */
	public static MessageCaptcha newInstance(Long validTime){
		MessageCaptcha captcha=new MessageCaptcha();
		captcha.validTime=validTime;
		captcha.createTime=new Date().getTime();
		Random random=new Random();
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<6;i++){
			int r=random.nextInt(10);
			sb.append(String.valueOf(r));
		}
		captcha.code=sb.toString();
		return captcha;
	}
	/**
	 * 是否有效 
	 * @param code
	 * @return
	 * 2016年8月15日下午3:20:07
	 */
	public boolean isValid(String code,String mobile){
		long currentTime=new Date().getTime();
		//有效且验证码相同s
		return (this.mobile.equals(mobile)&&currentTime<createTime+validTime&&this.code.equals(code));
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	public long getValidTime() {
		return validTime;
	}
	public void setValidTime(long validTime) {
		this.validTime = validTime;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
}
