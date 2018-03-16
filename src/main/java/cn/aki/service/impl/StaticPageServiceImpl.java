package cn.aki.service.impl;

import cn.aki.dao.StaticPageMapper;
import cn.aki.entity.StaticPage;
import cn.aki.service.StaticPageService;
import org.assertj.core.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("staticPageService")
public class StaticPageServiceImpl implements StaticPageService {
    @Autowired
    private StaticPageMapper staticPageMapper;

    public StaticPage get(StaticPage staticPage) {
        return staticPageMapper.get(staticPage);
    }

    @Override
    public List<StaticPage> listByCode(String code) {
        if (Strings.isNullOrEmpty(code)) {
            return null;
        }
        StaticPage condition = new StaticPage();
        condition.setCode(code);
        return staticPageMapper.getList(condition);
    }


}
