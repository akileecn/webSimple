package cn.aki.service;

import com.github.pagehelper.PageInfo;
/**
 * service基本接口
 * @author aki
 * 2016年4月27日 下午3:30:55
 * @param <T>
 */
public interface BaseService<T> {
	/**
	 * 分页查询
	 * @param pageNum 页码(从1开始)
	 * @param pageSize 每页显示条数
	 * @param condition 查询条件
	 * @return
	 */
	PageInfo<T> getPage(Integer pageNum,Integer pageSize,T condition);
	/**
	 * 分页查询
	 * @param pageNum 页码(从1开始)
	 * @param pageSize 每页显示条数
	 * @return
	 */
	PageInfo<T> getPage(Integer pageNum,Integer pageSize);
}
