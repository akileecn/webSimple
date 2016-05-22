package cn.aki.service;

import java.util.List;

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
}
