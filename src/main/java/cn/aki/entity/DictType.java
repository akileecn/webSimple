package cn.aki.entity;

import java.io.Serializable;

/**
 * 字典类型
 * @author aki
 * 2016年4月15日 下午5:05:38
 */
public class DictType implements Serializable{
	private static final long serialVersionUID = 6494695048671602631L;
	private Integer id;
	private String code;
	private String name;
	private String remark;
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
	@Override
	public String toString() {
		return "DictType [id=" + id + ", code=" + code + ", name=" + name + ", remark=" + remark + "]";
	}
}
