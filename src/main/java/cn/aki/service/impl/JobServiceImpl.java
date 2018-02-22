package cn.aki.service.impl;

import cn.aki.dao.DictDataMapper;
import cn.aki.dao.JobMapper;
import cn.aki.entity.DictData;
import cn.aki.entity.Job;
import cn.aki.form.JobQueryForm;
import cn.aki.service.JobService;
import cn.aki.utils.Constants;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.assertj.core.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("jobService")
public class JobServiceImpl extends BaseServiceImpl<Job> implements JobService {
    @Autowired
    private JobMapper jobMapper;
    @Autowired
    private DictDataMapper dictDataMapper;

    /**
     * 直接传递education会报错
     */
    public List<Job> getList(Job condition) {
        return jobMapper.getList(condition);
    }

    public PageInfo<Job> getPage(JobQueryForm form) {
        //由于分页的原因不能写到getList中
        if (form.getEducation() != null) {
            //特殊查询字段处理
            DictData dict = new DictData();
            dict.setTypeCode(Constants.DICT_TYPE_CODE_SEARCH_EDUCATION);
            dict.setCode(form.getEducation());
            dict = dictDataMapper.get(dict);
            if (dict != null && !Strings.isNullOrEmpty(dict.getRemark())) {
                form.setEducation(dict.getRemark());
            } else {
                form.setEducation(null);
            }
        }
        Job job = form.createJob();
        job.setDisabled(false);
        return getPage(form.getPageNum(), form.getPageSize(), job);
    }

    public Job get(Integer id) {
        return jobMapper.get(id);
    }

    public PageInfo<Job> getHotList(Integer pageNum) {
        final int defaultCount = 16;
        if (pageNum == null) {
            pageNum = 1;
        }
        PageHelper.startPage(pageNum, defaultCount, true);
        List<Job> list = jobMapper.getHotList(defaultCount);
        return new PageInfo<Job>(list);
    }

}
