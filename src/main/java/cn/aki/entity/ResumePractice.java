package cn.aki.entity;
/**
 * 实践活动
 * @author aki
 * 2016年4月19日 上午11:16:20
 */
public class ResumePractice extends BaseEntity{
	private static final long serialVersionUID = 2960290685156243511L;
								//id int primary key auto_increment
	private Integer remsumeId;	//,remsume_id int not null
	private String company;		//,company varchar(100)
	private String beginEnd;	//,begin_end varchar(32) -- 起止时间
	private String job;			//,job varchar(32)
	private String duty;		//,duty varchar(500) -- 职责
	public Integer getRemsumeId() {
		return remsumeId;
	}
	public void setRemsumeId(Integer remsumeId) {
		this.remsumeId = remsumeId;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getBeginEnd() {
		return beginEnd;
	}
	public void setBeginEnd(String beginEnd) {
		this.beginEnd = beginEnd;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	
}
