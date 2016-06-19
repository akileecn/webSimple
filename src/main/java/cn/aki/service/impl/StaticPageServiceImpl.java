package cn.aki.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.aki.dao.StaticPageMapper;
import cn.aki.entity.StaticPage;
import cn.aki.service.StaticPageService;

@Service("staticPageService")
public class StaticPageServiceImpl implements StaticPageService{
	@Autowired
	private StaticPageMapper staticPageMapper;
	
	public StaticPage get(StaticPage staticPage) {
		return staticPageMapper.get(staticPage);
	}

}
