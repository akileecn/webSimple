package cn.aki.entity.base;

import java.io.Serializable;
import java.util.Map;

import cn.aki.service.DictDataService;
/**
 * 实体基类
 * @author aki
 * 2016年4月19日 上午10:27:58
 */
public abstract class BaseEntity implements Serializable,DictDataService.Translatable{
	private static final long serialVersionUID = -876875333935298576L;
	protected Integer id;//主键
	protected Map<String,String> translation;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setT(Map<String, String> translation) {
		this.translation=translation;
	}
	public Map<String, String> getT() {
		return translation;
	}
	
}
