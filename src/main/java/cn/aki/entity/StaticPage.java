package cn.aki.entity;

import java.io.Serializable;
/**
 * 静态页面
 * @author Aki
 * 2016年6月19日 上午11:20:13
 */
public class StaticPage implements Serializable{
	private static final long serialVersionUID = -5553663739033521081L;
	private Integer id;//id int primary key identity(1,1)
	private String code;//,code nvarchar(32) -- 代码
	private String attr;//,attr nvarchar(32) -- 其他属性
	private String template;//,template nvarchar(100) -- 模版路径
	private String title;//,title nvarchar(100) -- 标题
	private String content;//,content ntext -- 内容
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getAttr() {
		return attr;
	}
	public void setAttr(String attr) {
		this.attr = attr;
	}
	public String getTemplate() {
		return template;
	}
	public void setTemplate(String template) {
		this.template = template;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
