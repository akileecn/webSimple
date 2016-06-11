package cn.aki.service;

import java.util.List;
import java.util.Map;

import cn.aki.entity.translate.Translatable;
/**
 * 字段翻译service
 * @author Aki
 * 2016年5月22日 下午9:34:38
 */
public interface TranslateService {
	/**
	 * 字段翻译
	 */
	void translate(Translatable obj);
	/**
	 * 字段翻译
	 */
	void translate(List<? extends Translatable> list);
	/*
	 * 获得单个字典
	 */
	Map<String,String> findDict(String type);
	/**
	 * 获得多个指定的字典
	 * @param types 字典的typeCode
	 * @return
	 */
	Map<String,Map<String,String>> findDicts(String[] types);
	/**
	 * 全部刷新
	 */
	void refresh();
}
