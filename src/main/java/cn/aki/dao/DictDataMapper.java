package cn.aki.dao;

import java.util.List;

import cn.aki.entity.DictData;

public interface DictDataMapper {
	List<DictData> getListByTypes(List<String> typeCodes);
	List<DictData> getAllList();
}
