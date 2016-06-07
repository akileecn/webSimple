package cn.aki.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cn.aki.dao.NoticeMapper;
import cn.aki.entity.Notice;
import cn.aki.service.WechatNoticeService;

@Service("wechatNoticeService")
public class WechatNoticeServiceImpl  implements WechatNoticeService{

	@Autowired
	private NoticeMapper noticeMapper ;
	
	public List<Notice> getList(Notice notice) {
	      return noticeMapper.getList(notice) ;
	}

	public Notice get(Notice notice) {
		return noticeMapper.get(notice) ;
	}


}
