package cn.aki.test;

import java.lang.reflect.Field;
import java.math.BigDecimal;

import org.junit.Test;

import cn.aki.entity.User;
import cn.aki.response.FormResponse;
import cn.aki.response.Response;
import cn.aki.utils.DateUtils;
import cn.aki.utils.Md5Utils;

public class MyTest {
	public static void main(String[] args) {
		System.err.println(Md5Utils.encrypt("123qwe"));
		System.err.println(Md5Utils.isEncrypted("123456", "6a15a216fc555826c06f8e0cd8ef141d"));
	}
	
	@Test
	public void test(){
		String realPath=MyTest.class.getResource("/").getPath();
		System.err.println(realPath);
	}
	
	@Test
	public void test1(){
		BigDecimal b1=new BigDecimal(0.1);
		BigDecimal b2=new BigDecimal("0.1");
		System.err.println(b1.compareTo(b2));//b1>b2
		
		BigDecimal b3=new BigDecimal("0.2");
		BigDecimal b4=new BigDecimal("-0.1");
		b3=b3.add(b4);
		System.err.println(b3);
	}
	
	@Test
	public void test2()throws Exception{
		User user=new User();
		Field field=User.class.getDeclaredField("username");
		field.setAccessible(true);
		field.set(user, "用户名");
		System.err.println(user.getUsername());
	}
	
	@Test
	public void test3(){
		//对象是否为参数的同类或父类(接口)
		System.err.println(Response.class.isAssignableFrom(FormResponse.class));
	}
	
	@Test
	public void test4(){
		System.err.println("2016-04-29 11:55:50".length());
		System.err.println(DateUtils.parse("2016-04-29"));
	}
	
	@Test
	public void test5(){
		String password="123qwe";
		System.err.println(password.matches("^(?![^a-zA-Z]+$)(?!\\D+$)[a-zA-Z\\d]{6,20}$"));
		
	}
}
