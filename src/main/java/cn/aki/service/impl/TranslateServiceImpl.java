package cn.aki.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.context.ServletContextAware;

import cn.aki.dao.DictDataMapper;
import cn.aki.entity.DictData;
import cn.aki.entity.translate.Translatable;
import cn.aki.entity.translate.TranslateTypeCode;
import cn.aki.service.TranslateService;

@Service("translateService")
public class TranslateServiceImpl implements TranslateService,ServletContextAware,InitializingBean{
	@Autowired
	private DictDataMapper dictDataMapper;
	//@Autowired,使用ServletContextAware时不需要注解注入
	private ServletContext servletContext;
	private Map<String,Map<String,String>> dictMap;
	
	/**
	 * 注入servletContext
	 */
	public void setServletContext(ServletContext servletContext) {
		this.servletContext=servletContext;
	}
	
	/**
	 * 初始化dictMap
	 */
	public void afterPropertiesSet() throws Exception {
		List<DictData> list=dictDataMapper.getAllList();
		if(list!=null&&list.size()>0){
			dictMap=new HashMap<String,Map<String,String>>();
			for(DictData dict:list){
				Map<String,String> map=dictMap.get(dict.getTypeCode());
				if(map==null){
					map=new HashMap<String, String>();
					dictMap.put(dict.getTypeCode(), map);
				}
				map.put(dict.getCode(), dict.getName());
			}
		}
		//保存到context中
		servletContext.setAttribute(DictData.CONTEXT_ATTR_KEY, dictMap);
	}

	@SuppressWarnings("unchecked")
	public void translate(Translatable obj){
		if(obj==null){
			return;
		}
		Map<String,String> translation=obj.getT();
		if(translation==null){
			//有序
			translation=new LinkedHashMap<String, String>();
			obj.setT(translation);
		}
		Field[] fields=obj.getClass().getDeclaredFields();
		for(Field field:fields){
			//是否含注解并排除静态变量
			if(field.isAnnotationPresent(TranslateTypeCode.class)&&!Modifier.isStatic(field.getModifiers())){
				String fieldName=field.getName();
				String typeCode=field.getAnnotation(TranslateTypeCode.class).value();
				if(StringUtils.isEmpty(typeCode)){
					typeCode=fieldName;
				}
				try {
					field.setAccessible(true);
					Object value = field.get(obj);
					if(value!=null){
						if(value instanceof String){
							String translateName=getCodeName(typeCode, (String)value);
							if(translateName!=null){
								translation.put(fieldName,translateName);
							}
						}else if(value instanceof Boolean){
							translation.put(fieldName,(Boolean)value?"是":"否");
						}else if(value instanceof Translatable){
							translate((Translatable)value);
						}else if(value instanceof List){
							List<?> listValue=(List<?>) value;
							if(listValue.size()>0&&listValue.get(0) instanceof Translatable){
								//递归翻译
								translate((List<Translatable>)listValue);
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void translate(List<? extends Translatable> list) {
		if(list==null){
			return;
		}
		for(Translatable obj:list){
			if(obj!=null){
				translate(obj);
			}
		}
	}
	
	private String getCodeName(String typeCode, String code) {
		if(typeCode!=null&&code!=null&&dictMap!=null){
			Map<String,String> codeMap=dictMap.get(typeCode);
			if(code!=null&&codeMap!=null){
				return codeMap.get(code);
			}
		}
		return null;
	}
}
