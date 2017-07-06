package cn.aki;

import cn.aki.config.MyProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Created by Administrator on 2017/7/4.
 */
@SpringBootApplication
@MapperScan("cn.aki.dao") // mybatis
@EnableConfigurationProperties(MyProperties.class) // 自定配置文件
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
