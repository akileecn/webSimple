package cn.aki.form;

import cn.aki.entity.Job;

/**
 * 岗位查询表单
 * @author aki
 * 2016年4月27日 下午6:10:59
 */
public class JobQueryForm extends Job{
	private static final long serialVersionUID = -5757313811555628318L;
	private String publishDateType;//发布时间类型
	
	public String getPublishDateType() {
		return publishDateType;
	}
	public void setPublishDateType(String publishDateType) {
		this.publishDateType = publishDateType;
		//TODO 转化为publishDate
	}
	
}
