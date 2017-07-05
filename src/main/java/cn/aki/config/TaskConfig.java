package cn.aki.config;

import cn.aki.job.RefreshDictJob;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by Administrator on 2017/7/5.
 * 任务
 */
@Configuration
@EnableScheduling
public class TaskConfig {
	@Bean
	public RefreshDictJob refreshDictJob(){
		return new RefreshDictJob();
	}
}
