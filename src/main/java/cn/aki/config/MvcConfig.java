package cn.aki.config;

import cn.aki.converter.String2BooleanConverter;
import cn.aki.converter.String2DateConverter;
import cn.aki.converter.String2StringConverter;
import cn.aki.interceptor.ResumeSubInterceptor;
import cn.aki.utils.DateUtils;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.hibernate.validator.HibernateValidator;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.IOException;

/**
 * Created by Administrator on 2017/7/5.
 * spring mvc
 * 不需要@EnableWebMvc
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 静态资源
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	}

	@Bean
	public HttpMessageConverter httpMessageConverter(){
		// json转换
		ObjectMapper mapper = Jackson2ObjectMapperBuilder.json().build();
		mapper.setDateFormat(DateUtils.FORMAT_SHORT);
		mapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
			public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers)
					throws IOException {
				gen.writeString("");
			}
		});
		return new MappingJackson2HttpMessageConverter(mapper);
	}

	// 参数类型转换器conversion-service自动加载
	@Bean
	public String2BooleanConverter string2BooleanConverter(){
		return new String2BooleanConverter();
	}
	@Bean
	public String2DateConverter string2DateConverter(){
		return new String2DateConverter();
	}
	@Bean
	public String2StringConverter string2StringConverter(){
		return new String2StringConverter();
	}

	// 拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new ResumeSubInterceptor())
				.addPathPatterns("/resume/**")
				.excludePathPatterns("/resume/*/base");
	}

	// 简单映射
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "/index");
	}

	// 国际化
	@Bean("messageSource")
	public MessageSource messageSource(){
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.addBasenames("i18n.validationMessages");
		return messageSource;
	}

	// 表单验证
	@Bean
	public LocalValidatorFactoryBean localValidatorFactoryBean(){
		LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
		validator.setProviderClass(HibernateValidator.class);
		validator.setValidationMessageSource(messageSource());
		return validator;
	}

}
