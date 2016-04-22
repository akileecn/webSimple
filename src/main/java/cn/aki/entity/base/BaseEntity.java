package cn.aki.entity.base;

import java.io.Serializable;
/**
 * 实体基类
 * @author aki
 * 2016年4月19日 上午10:27:58
 */
public abstract class BaseEntity implements Serializable{
	private static final long serialVersionUID = -876875333935298576L;
	protected Integer id;//主键

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
