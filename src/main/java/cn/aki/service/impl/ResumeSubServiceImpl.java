package cn.aki.service.impl;

import java.lang.reflect.Field;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.aki.dao.BaseResumeSubMapper;
import cn.aki.dao.ResumeAwardMapper;
import cn.aki.dao.ResumeEducationMapper;
import cn.aki.dao.ResumeFamilyMapper;
import cn.aki.dao.ResumeWorkMapper;
import cn.aki.entity.base.ResumeSub;
import cn.aki.service.ResumeSubService;

@Service("resumeSubService")
public class ResumeSubServiceImpl implements ResumeSubService{
	@SuppressWarnings("unused")
	@Autowired
	private ResumeAwardMapper awardMapper;
	@SuppressWarnings("unused")
	@Autowired
	private ResumeEducationMapper educationMapper;
	@SuppressWarnings("unused")
	@Autowired
	private ResumeFamilyMapper familyMapper;
	@SuppressWarnings("unused")
	@Autowired
	private ResumeWorkMapper workMapper;

	public <T extends ResumeSub> void save(T t) {
		getMapper(t).save(t);
	}

	public <T extends ResumeSub> T get(T t) {
		return getMapper(t).get(t);
	}

	public <T extends ResumeSub> List<T> getList(T t) {
		return getMapper(t).getList(t);
	}

	public <T extends ResumeSub> void update(T t) {
		getMapper(t).update(t);
	}

	public <T extends ResumeSub> void delete(T t) {
		getMapper(t).delete(t);
	}
	
	/**
	 * 获得对应的mapper
	 */
	@SuppressWarnings("unchecked")
	private <T extends ResumeSub>BaseResumeSubMapper<T> getMapper(T t){
		Field[] fields=getClass().getDeclaredFields();
		String tClassName=t.getClass().getSimpleName();
		for(Field field:fields){
			if(BaseResumeSubMapper.class.isAssignableFrom(field.getType())){
				if(field.getType().getSimpleName().equals(tClassName+"Mapper")){
					try {
						return (BaseResumeSubMapper<T>) field.get(this);
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return null;
	}

}
