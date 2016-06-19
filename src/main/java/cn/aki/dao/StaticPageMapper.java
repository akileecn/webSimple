package cn.aki.dao;

import java.util.List;

import cn.aki.entity.StaticPage;

public interface StaticPageMapper {
	void save(StaticPage staticPage);
	StaticPage get(StaticPage staticPage);
	List<StaticPage> getList(StaticPage staticPage);
	void update(StaticPage staticPage);
	void delete(StaticPage staticPage);
}