package cn.aki.service.impl;

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
import cn.aki.service.DictDataService;

@Lazy(false)
@Service("dictDataService")
public class DictDataServiceImpl implements DictDataService,ServletContextAware,InitializingBean{
	@Autowired
	private DictDataMapper dictDataMapper;
//	@Autowired
	private ServletContext servletContext;
	
	private Map<String,Map<String,String>> dictMap; 
	
	public Map<String, String> getMap(String typeCode) {
		return dictMap==null?null:dictMap.get(typeCode);
	}

	public String getName(String typeCode, String code) {
		if(dictMap!=null&&dictMap.get(typeCode)!=null){
			return dictMap.get(typeCode).get(code);
		}else{
			return null;
		}
	}
	
	public void setServletContext(ServletContext servletContext) {
		this.servletContext=servletContext;
	}
	
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

}
