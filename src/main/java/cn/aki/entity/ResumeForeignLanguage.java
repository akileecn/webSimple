package cn.aki.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

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
	@Deprecated
	private String speaking;//,speaking nvarchar(32) -- 口语
	@TranslateTypeCode("language")
	private String others;//,others nvarchar(32) -- 其他语言
	@TranslateTypeCode("languageProficiency")
	private String proficiency;//proficiency nvarchar(32);-- 熟练程度
	
	@Size(max=32)@NotBlank
	public String getLevel() {
		return level;
	}
	@NotNull
	public Integer getScore() {
		return score;
	}
	@Size(max=32)
	public String getSpeaking() {
		return speaking;
	}
	@Size(max=32)
	public String getOthers() {
		return others;
	}
	@Size(max=32)@NotBlank
	public String getProficiency() {
		return proficiency;
	}
	
	
	public void setLevel(String level) {
		this.level = level;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public void setSpeaking(String speaking) {
		this.speaking = speaking;
	}
	public void setOthers(String others) {
		this.others = others;
	}
	public void setProficiency(String proficiency) {
		this.proficiency = proficiency;
	}
	
}
