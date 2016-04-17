package cn.aki.test;

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
}
