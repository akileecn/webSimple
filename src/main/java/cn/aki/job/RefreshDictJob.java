package cn.aki.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import cn.aki.service.TranslateService;
import cn.aki.utils.SpringContextUtils;
/**
 * 刷新字典任务
 * @author Aki
 * 2016年6月11日 下午9:33:03
 */
@Component("refreshDictJob")
public class RefreshDictJob implements InitializingBean{
	private static Logger logger=LoggerFactory.getLogger(RefreshDictJob.class);
	private TranslateService translateService;
	
	public void execute(){
		logger.info("execute translateService refresh begin");
		translateService.refresh();
		logger.info("translateService refresh done");
	}

	public void afterPropertiesSet() throws Exception {
		translateService=SpringContextUtils.getBean(TranslateService.class);
	}
}
