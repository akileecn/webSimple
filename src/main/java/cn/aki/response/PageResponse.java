package cn.aki.response;

import com.github.pagehelper.PageInfo;

/**
 * 分页数据响应
 * @author aki
 * 2016年4月28日 上午11:36:38
 */
public class PageResponse<T> extends Response<PageInfo<T>, Void>{

	@Override
	public boolean isSuccess() {
		return data!=null&&data.getList()!=null&&data.getList().size()>0;
	}

}
