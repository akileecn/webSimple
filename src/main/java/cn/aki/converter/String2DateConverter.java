package cn.aki.converter;

import java.util.Date;

import org.springframework.core.convert.converter.Converter;

import cn.aki.utils.DateUtils;
/**
 * 转换器String->Date
 * @author aki
 * 2016年4月29日 下午2:21:33
 */
public class String2DateConverter implements Converter<String, Date>{

	public Date convert(String source) {
		return DateUtils.parse(source);
	}

}
