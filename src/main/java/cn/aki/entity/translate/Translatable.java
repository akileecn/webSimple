package cn.aki.entity.translate;

import java.util.Map;

/**
 * 是否允许翻译接口
 * @author aki
 * 2016年4月28日 上午10:57:08
 */
public interface Translatable{
	/**
	 * 设置翻译map
	 * @param translation
	 */
	void setT(Map<String,String> translation);
	/**
	 * 获得翻译map
	 * @return
	 */
	Map<String,String> getT();
}