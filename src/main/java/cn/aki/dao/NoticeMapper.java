package cn.aki.dao;

import java.util.List;

import cn.aki.entity.Notice;

public interface NoticeMapper {
	void save(Notice notice);
	Notice get(Notice notice);
	List<Notice> getList(Notice notice);
	void update(Notice notice);
	void delete(Notice notice);
	Integer getCountByUserId(Integer userId);
}