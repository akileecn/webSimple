package cn.aki;

import cn.aki.config.MyProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by Administrator on 2017/7/4.
 */
@SpringBootApplication
@ImportResource("classpath:spring/spring.xml")
@MapperScan("cn.aki.dao") // mybatis
@EnableConfigurationProperties(MyProperties.class)
public class Application {
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
	}
}
