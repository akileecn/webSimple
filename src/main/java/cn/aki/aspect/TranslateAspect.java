package cn.aki.aspect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.ServletContextAware;

import com.github.pagehelper.PageInfo;

import cn.aki.dao.DictDataMapper;
import cn.aki.entity.DictData;
import cn.aki.entity.translate.Translatable;
import cn.aki.entity.translate.TranslateTypeCode;

/**
 * 实体字段翻译切面
 * @author Aki
 * 2016年5月18日 下午10:36:29
 */
@Component
@Aspect
public class TranslateAspect implements ServletContextAware,InitializingBean{
	@Autowired
	private DictDataMapper dictDataMapper;
	//@Autowired,使用ServletContextAware时不需要注解注入
	private ServletContext servletContext;
	private Map<String,Map<String,String>> dictMap;
	
	@Pointcut("execution(* cn.aki.service.*.get*(..))")
	private void inAnyMethod(){
	}
	
	@SuppressWarnings("unchecked")
	@Around("inAnyMethod()")
	public Object doAspect(ProceedingJoinPoint pjp){
		try {
			Object result=pjp.proceed();
			if(result!=null){
				if(result instanceof Translatable){
					translate((Translatable) result);
				}else if(result instanceof List){
					if(result!=null&&((List<?>)result).size()>0){
						if(((List<?>)result).get(0) instanceof Translatable){
							translate((List<? extends Translatable>)result);
						}
					}
				}else if(result instanceof PageInfo){
					List<?> list=((PageInfo<?>)result).getList();
					if(list!=null&&list.size()>0){
						if(list.get(0) instanceof Translatable){
							translate((List<? extends Translatable>)list);
						}
					}
				}
			}
			return result;
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
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

	/**
	 * 字段翻译
	 */
	private void translate(Translatable obj){
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
					if(value!=null&&value instanceof String){
						String translateName=getCodeName(typeCode, (String)value);
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
	
	/**
	 * 字段翻译
	 */
	private void translate(List<? extends Translatable> list) {
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
			if(code!=null){
				return codeMap.get(code);
			}
		}
		return null;
	}
}
