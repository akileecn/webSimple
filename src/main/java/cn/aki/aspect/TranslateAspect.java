package cn.aki.aspect;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.aki.entity.translate.Translatable;
import cn.aki.service.TranslateService;

/**
 * 实体字段翻译切面
 * @author Aki
 * 2016年5月18日 下午10:36:29
 */
@Component
@Aspect
public class TranslateAspect{
	@Autowired
	private TranslateService translateService;
	
	@Pointcut("execution(* cn.aki.dao.*.get*(..))")
	private void inAnyMethod(){
	}
	
	@SuppressWarnings("unchecked")
	@Around("inAnyMethod()")
	public Object doAspect(ProceedingJoinPoint pjp){
		try {
			Object result=pjp.proceed();
			if(result!=null){
				if(result instanceof Translatable){
					translateService.translate((Translatable) result);
				}else if(result instanceof List){
					if(result!=null&&((List<?>)result).size()>0){
						if(((List<?>)result).get(0) instanceof Translatable){
							translateService.translate((List<? extends Translatable>)result);
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
}
