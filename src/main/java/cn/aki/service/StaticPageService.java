package cn.aki.service;

import cn.aki.entity.StaticPage;

import java.util.List;

public interface StaticPageService {
    StaticPage get(StaticPage staticPage);

    List<StaticPage> listByCode(String code);
}
