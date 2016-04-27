package cn.aki.response;

import java.util.HashMap;
import java.util.Map;
/**
 * 表单提交响应
 * @author aki
 * 2016年4月26日 下午12:29:26
 */
public class FormResponse extends Response<Void, Map<String, String>>{

	@Override
	public boolean isSuccess() {
		//判断是否有错误信息
		return error==null||error.size()==0;
	}
	
	/**
	 * 添加错误信息
	 * @param field
	 * @param message
	 */
	public void putError(String field,String message){
		if(error==null){
			error=new HashMap<String, String>();
		}
		String oldMessage=error.get(field);
		if(oldMessage==null){
			error.put(field, message);
		}else{
			error.put(field, oldMessage+","+message);
		}
	}

}
