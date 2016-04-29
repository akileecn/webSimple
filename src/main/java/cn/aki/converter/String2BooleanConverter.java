package cn.aki.converter;

import org.springframework.core.convert.converter.Converter;

/**
 * 字符串转boolean
 * @author aki
 * 2016年4月29日 下午3:56:52
 */
public class String2BooleanConverter implements Converter<String, Boolean>{

	public Boolean convert(String source) {
		if("true".equals(source)){
			return true;
		}else if("false".equals(source)){
			return false;
		}else{
			return null;
		}
	}

}
