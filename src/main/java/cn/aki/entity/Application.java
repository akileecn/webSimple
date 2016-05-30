package cn.aki.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import cn.aki.entity.base.UserSub;
import cn.aki.entity.translate.Translatable;
import cn.aki.entity.translate.TranslateTypeCode;
/**
 * 志愿
 * @author Aki
 * 2016年5月30日 下午10:33:41
 */
public class Application implements UserSub,Translatable,Serializable{
	private static final long serialVersionUID = 562624874883789878L;
	private Integer jobId;		//job_id int -- 岗位id
	private Integer resumeId;	//,resume_id int not null -- 简历id
	private Date createTime;	//,create_time datetime --投递时间
	@TranslateTypeCode
	private String status;		//,status nvarchar(32) -- 申请状态
	private Integer userId;
	
	@TranslateTypeCode
	private Job job;			//岗位
	//翻译字段
	protected Map<String,String> translation;
	public void setT(Map<String, String> translation) {
		this.translation=translation;
	}
	public Map<String, String> getT() {
		return translation;
	}
	public Integer getJobId() {
		return jobId;
	}
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}
	public Integer getResumeId() {
		return resumeId;
	}
	public void setResumeId(Integer resumeId) {
		this.resumeId = resumeId;
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
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
