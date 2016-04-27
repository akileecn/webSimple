package cn.aki.service.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.aki.service.BaseService;
/**
 * service基本实现类型
 * @author aki
 * 2016年4月27日 下午3:21:34
 * @param <T>
 */
public abstract class BaseServiceImpl<T> implements BaseService<T>{
	private static final int DEFAULT_NUM=1;//默认页码
	private static final int DEFAULT_SIZE=10;//默认每页条数
	
	public PageInfo<T> getPage(Integer pageNum, Integer pageSize, T condition) {
		int num=(pageNum==null?DEFAULT_NUM:pageNum);
		int size=(pageSize==null?DEFAULT_SIZE:pageSize);
		PageHelper.startPage(num, size, true);
		List<T> list=getList(condition);
		return new PageInfo<T>(list);
	}
	
	public PageInfo<T> getPage(Integer pageNum, Integer pageSize) {
		return getPage(pageNum, pageSize, null);
	}
	
	/**
	 * 基本查询
	 * @param condition
	 * @return
	 */
	public abstract List<T> getList(T condition);
}
