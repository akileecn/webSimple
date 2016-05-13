package cn.aki.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import cn.aki.entity.base.ResumeSub;
import cn.aki.utils.UserUtils;

/**
 * 简历从属实体操作权限
 * @author aki
 * 2016年5月13日 下午5:33:49
 */
@Component
@Aspect
public class ResumeSubAspect {
	@Pointcut("execution(* cn.aki.controller.ResumeController.*(..))")
	private void inAnyMethod(){
	}
	
	@Around("inAnyMethod()")
	public Object doAspect(ProceedingJoinPoint pjp){
		Object result=null;
		try {
			Object[] args=pjp.getArgs();
			if(args!=null){
				for(int i=0;i<args.length;i++){
					if(args[i] instanceof ResumeSub){
						ResumeSub resumeSub=(ResumeSub)args[i];
						//判断是否为用户的简历
						if(UserUtils.hasResume(resumeSub.getResumeId())){
							return pjp.proceed(args);
						}else{
							System.err.println("doAspect");
							return null;
						}
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
