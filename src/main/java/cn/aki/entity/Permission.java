package cn.aki.entity;

import java.io.Serializable;
/**
 * 权限
 * @author aki
 * 2016年4月1日 上午9:27:11
 */
public class Permission implements Serializable{
	private static final long serialVersionUID = -3136185490519776467L;
	
	private Integer id;
	private String name;
	private String remark;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
