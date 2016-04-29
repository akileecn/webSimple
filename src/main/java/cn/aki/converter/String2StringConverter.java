package cn.aki.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;
/**
 * 空字符串转为null
 * @author aki
 * 2016年4月29日 下午2:45:29
 */
public class String2StringConverter implements Converter<String, String>{

	public String convert(String source) {
		if(StringUtils.isEmpty(source)){
			return null;
		}else{
			return source;
		}
	}

}
