package cn.aki.service;

import cn.aki.entity.Notice;
/**
 * 通知
 * @author Aki
 * 2016年5月30日 下午11:20:17
 */
public interface NoticeService extends BaseService<Notice>{
	void save(Notice notice);
	Notice get(Notice notice);
	void delete(Notice notice);
}
