package cn.aki.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageInfo;

import cn.aki.dao.DictDataMapper;
import cn.aki.dao.JobMapper;
import cn.aki.entity.DictData;
import cn.aki.entity.Job;
import cn.aki.form.JobQueryForm;
import cn.aki.service.JobService;
import cn.aki.utils.Constants;

@Service("jobService")
public class JobServiceImpl extends BaseServiceImpl<Job> implements JobService{
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
		if(form.getEducation()!=null){
			//特殊查询字段处理
			DictData dict=new DictData();
			dict.setTypeCode(Constants.DICT_TYPE_CODE_SEARCH_EDUCATION);
			dict.setCode(form.getEducation());
			dict=dictDataMapper.get(dict);
			if(dict!=null&&!StringUtils.isEmpty(dict.getRemark())){
				form.setEducation(dict.getRemark());
			}else{
				form.setEducation(null);
			}
		}
		return getPage(form.getPageNum(), form.getPageSize(),form.createJob());
	}

	public Job get(Integer id) {
		return jobMapper.get(id);
	}

	public List<Job> getHotList() {
		final int dedaultCount=16;
		return jobMapper.getHotList(dedaultCount);
	}

}
