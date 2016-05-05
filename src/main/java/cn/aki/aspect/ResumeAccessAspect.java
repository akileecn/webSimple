package cn.aki.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import cn.aki.entity.Resume;
import cn.aki.utils.UserUtils;

/**
 * 简历访问权限切面
 * @author Aki
 * 2016年5月5日 下午10:02:51
 */
@Component
@Aspect
public class ResumeAccessAspect {
	@Pointcut("execution(* cn.aki.service.ResumeService.*(..))")
	private void inAnyMethod(){
	}
	
	@Around("inAnyMethod()")
	public Object doAspect(ProceedingJoinPoint pjp){
		Object result=null;
		try {
			System.err.println("doAspect");
			Object[] args=pjp.getArgs();
			if(args!=null){
				for(int i=0;i<args.length;i++){
					if(args[i] instanceof Resume){
						//条件中添加用户ID约束
						Integer userId=UserUtils.getUserId();
						Resume condition=(Resume)args[i];
						condition.setUserId(userId);
						args[i]=condition;
						return pjp.proceed(args);
					}
				}
			}
			result=pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return result;
	}
}
