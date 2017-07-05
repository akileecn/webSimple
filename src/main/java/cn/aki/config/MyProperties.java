package cn.aki.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * Created by Administrator on 2017/7/5.
 * 配置文件
 */
@Data
@ConfigurationProperties(prefix = "my")
public class MyProperties {
	private String refererBase; // 跨站请求伪造
	private Integer applicationInterval; // 应聘周期
	private Map<String,String> shiro;
}
