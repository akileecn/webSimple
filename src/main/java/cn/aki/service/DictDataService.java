package cn.aki.service;

import java.util.List;
import java.util.Map;

public interface DictDataService {
	/**
	 * 是否允许翻译接口
	 * @author aki
	 * 2016年4月28日 上午10:57:08
	 */
	interface Translatable{
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
	/**
	 * 获得一个字段的字典集
	 * @param typeCode
	 * @return
	 */
	Map<String,String> getMap(String typeCode);
	/**
	 * 获得指定字段值的翻译
	 * @param typeCode
	 * @param code
	 * @return
	 */
	String getName(String typeCode,String code);
	/**
	 * 翻译指定字段
	 * @param obj
	 * @param codeNames
	 * @return
	 */
	void translate(Translatable obj,String[] codeNames);
	/**
	 * 翻译所有字段
	 * @param obj
	 * @return
	 */
	void translate(Translatable obj);
	/**
	 * 翻译指定字段
	 * @param list
	 * @param codeNames
	 * @return
	 */
	void translate(List<? extends Translatable> list,String[] codeNames);
	/**
	 * 翻译所有字段
	 * @param list
	 * @return
	 */
	void translate(List<? extends Translatable> list);
}
