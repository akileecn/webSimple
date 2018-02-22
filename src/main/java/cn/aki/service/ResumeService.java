package cn.aki.service;

import cn.aki.entity.Resume;
import cn.aki.utils.Response;
import cn.aki.vo.ResumeAllVO;

import java.util.List;

public interface ResumeService {
    /**
     * 获得简历
     */
    @Deprecated
    Resume get(Resume resume);

    /**
     * 获得简历全部信息
     */
    ResumeAllVO getAll(Resume resume);

    void update(Resume resume);

    /**
     * 更新照片
     */
    void updatePhoto(Resume resume);

    /**
     * 获得照片
     */
    Resume getPhoto(Resume resume);

    /**
     * 校验
     */
    void validate(Resume resume, Response<?> response);

    /**
     * 提交简历
     */
    String submit(Resume resume);

    /**
     * 获得轻量级的简历集合
     */
    List<Resume> getList(Resume resume);
}
