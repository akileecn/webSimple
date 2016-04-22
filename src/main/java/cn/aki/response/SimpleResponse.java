package cn.aki.response;

import java.util.HashMap;
import java.util.Map;
/**
 * 简单响应
 * @author aki
 * 2016年4月22日 下午3:29:28
 */
public class SimpleResponse implements Response{
	private Map<String, String> data;
	
	public boolean success() {
		// TODO Auto-generated method stub
		return false;
	}

	public Map<String, String> getData() {
		if(data==null){
			data=new HashMap<String, String>();
		}
		return data;
	}

	public void put(String key,String value){
		
	}
}
