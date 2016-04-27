package cn.aki.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;

import cn.aki.dao.DictDataMapper;
import cn.aki.entity.DictData;
import cn.aki.other.DateUtils;
import cn.aki.service.DictDataService;

@Lazy(false)
@Service("dictDataService")
public class DictDataServiceImpl implements DictDataService,ServletContextAware,InitializingBean{
	@Autowired
	private DictDataMapper dictDataMapper;
	//@Autowired,使用ServletContextAware时不需要注解注入
	private ServletContext servletContext;
	
	private Map<String,Map<String,String>> dictMap; 
	
	public Map<String, String> getMap(String typeCode) {
		return dictMap==null?null:dictMap.get(typeCode);
	}

	public String getName(String typeCode, String code) {
		if(typeCode==null||code==null||dictMap==null||dictMap.get(typeCode)==null){
			return null;
		}
		return dictMap.get(typeCode).get(code);
	}
	
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

	public void translate(Translatable obj,String[] codeNames){
		if(obj==null){
			return;
		}
		Map<String,String> translation=obj.getT();
		if(translation==null){
			translation=new HashMap<String, String>();
			obj.setT(translation);
		}
		Field[] fields=obj.getClass().getDeclaredFields();
		for(Field field:fields){
			//排除静态变量
			if(!Modifier.isStatic(field.getModifiers())){
					String fieldName=field.getName();
					Object value;
					try {
						field.setAccessible(true);
						value = field.get(obj);
						if(value!=null){
							Class<?> clazz=field.getType();
							String translateName=null;
							//时间格式
							if(Date.class.isAssignableFrom(clazz)){
								translateName=DateUtils.formatDate((Date)value);
							//一般翻译
							}else if(String.class.isAssignableFrom(clazz)){
								if(codeNames==null||contains(codeNames, fieldName)){
									translateName=getName(fieldName, (String)value);
								}
							}
							if(translateName!=null){
								translation.put(fieldName,translateName);
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
			}
		}
	}
	
	public void translate(Translatable obj){
		translate(obj, null);
	}
	
	/**
	 * 是否包含指定字符串
	 * @param arr
	 * @param target
	 * @return
	 */
	private boolean contains(String[] arr,String target){
		for(String item:arr){
			if(item.equals(target)){
				return true;
			}
		}
		return false;
	}

	public void translate(List<? extends Translatable> list, String[] codeNames) {
		if(list==null){
			return;
		}
		for(Translatable obj:list){
			if(obj!=null){
				translate(obj,codeNames);
			}
		}
	}

	public void translate(List<? extends Translatable> list) {
		translate(list,null);
	}
}
