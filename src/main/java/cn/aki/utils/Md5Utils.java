package cn.aki.utils;

import org.apache.shiro.crypto.hash.Md5Hash;
/**
 * MD5加密
 * @author aki
 * 2016年4月26日 上午10:59:12
 */
public class Md5Utils {
	//盐
	private static final String SALT="6fd394b2f8f7e2438ca7f0a87a6db994";
	/**
	 * 加密
	 * @param source
	 * @return
	 */
	public static String encrypt(String source){
		Md5Hash md5=new Md5Hash(source,SALT);
		return md5.toString();
	}
	/**
	 * 是否为密文
	 * @param source 明码
	 * @param encoded 密码
	 * @return
	 */
	public static boolean isEncrypted(String source,String encrypted){
		return encrypt(source).equals(encrypted);
	}
}
