package cn.aki.other;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
/**
 * spring上下文工具类
 * @author aki
 * 2016年4月26日 下午1:10:22
 */
@Component
public class SpringContextUtils implements ApplicationContextAware{
	private static ApplicationContext context;
	
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context=applicationContext;
	}
	
	/**
	 * 获得spring中的bean对象
	 * @param clazz
	 * @return
	 */
	public static <T> T getBean(Class<T> clazz){
		return context.getBean(clazz);
	}

}
