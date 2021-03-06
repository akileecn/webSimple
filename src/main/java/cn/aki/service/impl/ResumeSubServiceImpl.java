package cn.aki.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.aki.dao.BaseResumeSubMapper;
import cn.aki.dao.ResumeAwardMapper;
import cn.aki.dao.ResumeComputerMapper;
import cn.aki.dao.ResumeEducationMapper;
import cn.aki.dao.ResumeFamilyMapper;
import cn.aki.dao.ResumeForeignLanguageMapper;
import cn.aki.dao.ResumeMapper;
import cn.aki.dao.ResumePracticeMapper;
import cn.aki.dao.ResumeStudentCadreMapper;
import cn.aki.dao.ResumeTrainMapper;
import cn.aki.dao.ResumeWorkMapper;
import cn.aki.entity.Resume;
import cn.aki.entity.base.ResumeSubEntity;
import cn.aki.service.ResumeSubService;

@Service("resumeSubService")
public class ResumeSubServiceImpl implements ResumeSubService,InitializingBean{
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
	@SuppressWarnings("unused")
	@Autowired
	private ResumeComputerMapper computerMapper;
	@SuppressWarnings("unused")
	@Autowired
	private ResumeForeignLanguageMapper foreignLanguageMapper;
	@SuppressWarnings("unused")
	@Autowired
	private ResumeStudentCadreMapper studentCadreMapper;
	@SuppressWarnings("unused")
	@Autowired
	private ResumePracticeMapper practiceMapper;
	@SuppressWarnings("unused")
	@Autowired
	private ResumeTrainMapper trainMapper;
	
	@Autowired
	private ResumeMapper resumeMapper;
	
	private HashMap<Class<? extends ResumeSubEntity>, BaseResumeSubMapper<? extends ResumeSubEntity>> mapperMap;

	@Transactional
	public <T extends ResumeSubEntity> void saveOrUpdate(T t) {
		Resume resume=new Resume();
		resume.setId(t.getResumeId());
		resume=resumeMapper.getStatus(resume);
		//简历未锁定
		if(resume!=null&&resume.getIsLocked()==false){
			BaseResumeSubMapper<T> mapper=getMapper(t);
			if(t.getId()!=null){
				mapper.update(t);
			}else{
				mapper.save(t);
			}
			//更新简历提交状态
			resume.setIsSubmit(false);
			resumeMapper.updateStatus(resume);
		}
	}
	
	public <T extends ResumeSubEntity> T get(T t) {
		return getMapper(t).get(t);
	}

	public <T extends ResumeSubEntity> List<T> getList(T t) {
		return getMapper(t).getList(t.getResumeId());
	}

	@Transactional
	public <T extends ResumeSubEntity> void delete(T t) {
		Resume resume=new Resume();
		resume.setId(t.getResumeId());
		resume=resumeMapper.getStatus(resume);
		//简历未锁定
		if(resume!=null&&resume.getIsLocked()==false){
			getMapper(t).delete(t);
			//更新简历提交状态
			resume.setIsSubmit(false);
			resumeMapper.updateStatus(resume);
		}
	}
	
	/**
	 * 获得对应的mapper
	 */
	@SuppressWarnings("unchecked")
	private <T extends ResumeSubEntity>BaseResumeSubMapper<T> getMapper(T t){
		for(Class<? extends ResumeSubEntity> clazz:mapperMap.keySet()){
			if(clazz.isAssignableFrom(t.getClass())){
				return (BaseResumeSubMapper<T>) mapperMap.get(clazz);
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public void afterPropertiesSet() throws Exception {
		mapperMap=new HashMap<Class<? extends ResumeSubEntity>, BaseResumeSubMapper<? extends ResumeSubEntity>>();
		Field[] fields=getClass().getDeclaredFields();
		for(Field field:fields){
			if(BaseResumeSubMapper.class.isAssignableFrom(field.getType())){
				//泛型父类接口
				ParameterizedType type=(ParameterizedType)field.getType().getGenericInterfaces()[0];
				//泛型类型
				Class<? extends ResumeSubEntity> clazz=(Class<? extends ResumeSubEntity>) type.getActualTypeArguments()[0];
				mapperMap.put(clazz, (BaseResumeSubMapper<? extends ResumeSubEntity>) field.get(this));
			}
		}
	}
	
}
