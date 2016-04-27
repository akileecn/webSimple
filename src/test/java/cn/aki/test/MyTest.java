package cn.aki.test;

import java.lang.reflect.Field;
import java.math.BigDecimal;

import org.junit.Test;

import cn.aki.entity.User;
import cn.aki.other.Md5Utils;

public class MyTest {
	public static void main(String[] args) {
		System.err.println(Md5Utils.encrypt("123456"));
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
}
