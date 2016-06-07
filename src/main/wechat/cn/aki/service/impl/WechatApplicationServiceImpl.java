package cn.aki.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.aki.dao.ApplicationMapper;
import cn.aki.entity.Application;
import cn.aki.service.WechatApplicationService;

@Service("wechatApplicationService")
public class WechatApplicationServiceImpl implements WechatApplicationService {

	@Autowired
	ApplicationMapper applictionMapper ;


	public List<Application> getList(Application application) {
		return applictionMapper.getList(application);
	}




	
}
