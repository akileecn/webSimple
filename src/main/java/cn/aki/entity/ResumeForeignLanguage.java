package cn.aki.entity;
/**
 * 外语信息
 * @author aki
 * 2016年4月19日 上午11:05:35
 */
public class ResumeForeignLanguage extends BaseEntity{
	private static final long serialVersionUID = -2671468104925416944L;
								//id int primary key auto_increment
	private Integer remsumeId;	//,remsume_id int not null
	private String level;		//,level varchar(32)
	private Integer score;		//,score int
	private String speaking;	//,speaking varchar(32) -- 口语
	private String others;		//,others varchar(32) -- 其他语言
	public Integer getRemsumeId() {
		return remsumeId;
	}
	public void setRemsumeId(Integer remsumeId) {
		this.remsumeId = remsumeId;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getSpeaking() {
		return speaking;
	}
	public void setSpeaking(String speaking) {
		this.speaking = speaking;
	}
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
	}
	
}
