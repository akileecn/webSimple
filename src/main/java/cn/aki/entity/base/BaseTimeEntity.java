package cn.aki.entity.base;

import java.util.Date;
/**
 * 带时间戳的实体
 * @author aki
 * 2016年4月22日 上午9:49:31
 */
public abstract class BaseTimeEntity extends BaseEntity{
	private static final long serialVersionUID = -978810034602619384L;
	private Date createTime;	//,create_time datetime -- 创建时间
	private Date modifyTime;	//,modify_time datetime -- 修改时间
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
}
