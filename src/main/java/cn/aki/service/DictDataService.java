package cn.aki.service;

import java.util.Map;

public interface DictDataService {
	Map<String,String> getMap(String typeCode);
	String getName(String typeCode,String code);
}
