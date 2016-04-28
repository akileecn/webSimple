package cn.aki.other;

import java.io.IOException;

import org.springframework.beans.factory.InitializingBean;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

import cn.aki.utils.DateUtils;
/**
 * json解析
 * @author Aki
 * 2016年4月29日 上午2:00:03
 */
public class MyObjectMapper extends ObjectMapper implements InitializingBean{
	private static final long serialVersionUID = -2630859793877303917L;

	public void afterPropertiesSet() throws Exception {
		//设置默认时间格式
		setDateFormat(DateUtils.FORMAT_SHORT);
		//null用""替换
		getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
			@Override
			public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers)
					throws IOException, JsonProcessingException {
				gen.writeString("");
			}
		});
	}
	
}
