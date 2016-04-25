package cn.aki.test;

import java.math.BigDecimal;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

public class MyTest {
	public static void main(String[] args) {
		System.err.println("hello world");
		Md5Hash md5=new Md5Hash("123456");
		System.err.println(md5.toString());
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
	}
}
