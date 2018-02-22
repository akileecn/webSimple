package cn.aki.service;

import cn.aki.entity.Application;
import cn.aki.utils.Response;

import java.util.List;

/**
 * 申请
 *
 * @author Aki
 * 2016年5月30日 下午11:13:29
 */
public interface ApplicationService {
    void save(Application application);

    void delete(Application application);

    void update(Application application);

    Application get(Application application);

    List<Application> getList(Application application);

    /**
     * 投递简历
     *
     * @param application
     * @return
     */
    Response<Application> apply(Application application);
}
