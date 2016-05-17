package cn.aki.test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import cn.aki.dao.ResumeAwardMapper;

public class GenericTest {
	public static void main(String[] args) {
		//父类是class时使用getGenericSuperclass()
		Type[] types=ResumeAwardMapper.class.getGenericInterfaces();
		for(Type type:types){
			Class<?> clazz=(Class<?>) ((ParameterizedType)type).getActualTypeArguments()[0];
			System.err.println(clazz);
		}

	}
}