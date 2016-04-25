package cn.aki.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import cn.aki.other.Response;

/**
 * controller基类
 * @author aki
 * 2016年4月25日 上午10:54:41
 */
public abstract class BaseController {

	/**
	 * 处理验证的公共方法
	 * @param response
	 * @param result
	 * @return 
	 * @return
	 */
	protected <T> Response<T, Map<String, String>> handleError(Response<T, Map<String, String>> response,BindingResult result){
		if(result.hasErrors()){
			response.setSuccess(false);
			List<FieldError> errorList=result.getFieldErrors();
			Map<String,String> errorMap=new HashMap<String, String>();
			for(FieldError error:errorList){
				String field=error.getField();
				String message=errorMap.get(field);
				if(message==null){
					errorMap.put(field, error.getDefaultMessage());
				}else{
					errorMap.put(field, message+","+error.getDefaultMessage());
				}
			}
			response.setError(errorMap);
		}else{
			response.setSuccess(true);
		}
		return response;
	}
}
