package cn.aki.entity;

import java.util.Date;

import cn.aki.entity.base.ResumeSubEntity;
/**
 * 志愿
 * @author Aki
 * 2016年5月30日 下午10:33:41
 */
public class Application extends ResumeSubEntity{
	private static final long serialVersionUID = 562624874883789878L;
	private Integer jobId;		//job_id int -- 岗位id
	private Date createTime;	//,create_time datetime --投递时间
	private String status;		//,status nvarchar(32) -- 申请状态
	
	private Job job;			//岗位
	public Integer getJobId() {
		return jobId;
	}
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	
}
