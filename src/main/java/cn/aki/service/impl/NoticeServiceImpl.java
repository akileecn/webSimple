package cn.aki.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.aki.dao.NoticeMapper;
import cn.aki.entity.Notice;
import cn.aki.service.NoticeService;

@Service("noticeService")
public class NoticeServiceImpl extends BaseServiceImpl<Notice> implements NoticeService{
	@Autowired
	private NoticeMapper noticeMapper;
	
	public void save(Notice notice) {
		noticeMapper.save(notice);
	}

	public Notice get(Notice notice) {
		return noticeMapper.get(notice);
	}

	public List<Notice> getList(Notice notice) {
		return noticeMapper.getList(notice);
	}

	public void delete(Notice notice) {
		noticeMapper.delete(notice);
	}

}
