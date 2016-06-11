package cn.aki.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import cn.aki.response.FormResponse;

/**
 * controller基类
 * @author aki
 * 2016年4月25日 上午10:54:41
 */
public abstract class BaseController {

	/**
	 * 处理表单验证的公共方法
	 * @param response
	 * @param result
	 * @return
	 */
	protected <T> FormResponse<T> handleFormError(FormResponse<T> response,BindingResult result){
		if(response==null){
			response=new FormResponse<T>();
		}
		if(result.hasErrors()){
			List<FieldError> errorList=result.getFieldErrors();
			Map<String,String> errorMap=response.getError();
			if(errorMap==null){
				errorMap=new HashMap<String, String>();
			}
			for(FieldError error:errorList){
				String field=error.getField();
				String message=errorMap.get(field);
				String errorMessage=error.getDefaultMessage();
				//数字格式异常报错转译
				if(errorMessage!=null&&errorMessage.contains("NumberFormatException")){
					errorMessage="请输入整数";
				}
				if(message==null){
					errorMap.put(field, errorMessage);
				}else{
					errorMap.put(field, message+","+errorMessage);
				}
			}
			response.setError(errorMap);
		}
		return response;
	}
	
	/**
	 * 处理表单验证的公共方法
	 * @param result
	 * @return
	 */
	protected <T> FormResponse<T> handleFormError(BindingResult result){
		return handleFormError(null, result);
	}
}
