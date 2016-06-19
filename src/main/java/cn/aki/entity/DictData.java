package cn.aki.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 字典数据
 * @author aki
 * 2016年4月15日 下午5:07:40
 */
public class DictData implements Serializable{
	private static final long serialVersionUID = -5581421912677787537L;
	
	private Integer id;
	private String typeCode;
	private String code;
	private String name;
	private String remark;
	private Boolean disabled;
	private Date create_time;
	private Date modify_time;
	private Integer orderby;//orderby int default 0;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
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
	public Boolean getDisabled() {
		return disabled;
	}
	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getModify_time() {
		return modify_time;
	}
	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}
	public Integer getOrderby() {
		return orderby;
	}
	public void setOrderby(Integer orderby) {
		this.orderby = orderby;
	}
	@Override
	public String toString() {
		return "DictData [id=" + id + ", typeCode=" + typeCode + ", code=" + code + ", name=" + name + ", remark="
				+ remark + ", disabled=" + disabled + ", create_time=" + create_time + ", modify_time=" + modify_time
				+ "]";
	}
	
}
