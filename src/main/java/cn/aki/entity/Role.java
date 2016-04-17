package cn.aki.entity;

import java.io.Serializable;
import java.util.Set;
/**
 * 角色
 * @author aki
 * 2016年4月1日 上午9:25:16
 */
public class Role implements Serializable{
	private static final long serialVersionUID = -5148877337525015432L;
	
	private Integer id;
	private String name;
	private String remark;
	private Set<Permission> permissions;//权限集合
	
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
	public Set<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}
	
}
