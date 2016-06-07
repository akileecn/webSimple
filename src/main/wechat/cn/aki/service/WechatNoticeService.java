package cn.aki.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.aki.entity.Notice;

/**
 * 
 * 通知信
 * @author Administrator
 * 2016年5月31日 上午12:43:58
 */

public interface WechatNoticeService{

	
	Notice get(Notice notice);
	
	List<Notice> getList(Notice notice);
	
}
