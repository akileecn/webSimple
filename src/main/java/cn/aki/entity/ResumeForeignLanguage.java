package cn.aki.entity;

import cn.aki.entity.base.ResumeSubEntity;
import cn.aki.entity.translate.TranslateTypeCode;
/**
 * 外语
 * @author Aki
 * 2016年5月24日 上午12:14:46
 */
public class ResumeForeignLanguage extends ResumeSubEntity{
	private static final long serialVersionUID = 7626704777069635325L;
	@TranslateTypeCode("languageLevel")
	private String level;//,level nvarchar(32)
	private Integer score;//,score int
	@TranslateTypeCode("languageProficiency")
	private String speaking;//,speaking nvarchar(32) -- 口语
	@TranslateTypeCode("language")
	private String others;//,others nvarchar(32) -- 其他语言
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
