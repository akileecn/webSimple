package cn.aki.form;

import cn.aki.entity.Job;
import cn.aki.form.base.BasePageForm;

/**
 * 岗位查询表单
 * @author aki
 * 2016年4月27日 下午6:10:59
 */
public class JobQueryForm extends BasePageForm{
	private Integer id;				//主键
	private String name;			//岗位名称
	private String resumeType;		//招聘类型
	private String workCity;		//工作城市
	private String education;		//学历
	private String publishDateType;	//发布时间类型
	
	public Job createJob(){
		Job job=new Job();
		job.setId(id);//查询时不会用到
		job.setName(name);
		job.setResumeType(resumeType);
		job.setWorkCity(workCity);
		job.setEducation(education);
		return job;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getResumeType() {
		return resumeType;
	}
	public void setResumeType(String resumeType) {
		this.resumeType = resumeType;
	}
	public String getWorkCity() {
		return workCity;
	}
	public void setWorkCity(String workCity) {
		this.workCity = workCity;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getPublishDateType() {
		return publishDateType;
	}
	public void setPublishDateType(String publishDateType) {
		this.publishDateType = publishDateType;
		//TODO 转化为publishDate
	}
	
}
