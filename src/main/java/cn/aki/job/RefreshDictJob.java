package cn.aki.job;

import cn.aki.service.TranslateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 刷新字典任务
 *
 * @author Aki
 *         2016年6月11日 下午9:33:03
 */
public class RefreshDictJob{
	private static Logger logger = LoggerFactory.getLogger(RefreshDictJob.class);
	@Autowired
	private TranslateService translateService;

	@Scheduled(cron = "0 0 7/1 * * ?")
	public void execute() {
		logger.info("execute translateService refresh begin");
		if(translateService != null){
			translateService.refresh();
		}
		logger.info("translateService refresh done");
	}
}
