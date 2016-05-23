package cn.aki.dao;

import java.util.List;

import cn.aki.entity.${type};

public interface ${type}Mapper {
	void save(${type} ${bean});
	${type} get(${type} ${bean});
	List<${type}> getList(${type} ${bean});
	void update(${type} ${bean});
	void delete(${type} ${bean});
}