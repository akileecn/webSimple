package cn.aki.form.base;
/**
 * 分页表单
 * @author aki
 * 2016年4月28日 上午11:19:18
 */
public abstract class BasePageForm {
	private Integer pageNum;//页码(1开始)
	private Integer pageSize;//每页条数
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
}
