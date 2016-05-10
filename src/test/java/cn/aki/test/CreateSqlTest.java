package cn.aki.test;

import org.junit.Test;

import cn.aki.entity.ResumeAward;
import cn.aki.entity.ResumeEducation;
import cn.aki.entity.ResumeFamily;
import cn.aki.entity.ResumeWork;

public class CreateSqlTest {
	@Test
	public void resumeSub(){
		CreateSql.newInstance(ResumeAward.class).create();
		CreateSql.newInstance(ResumeEducation.class).create();
		CreateSql.newInstance(ResumeFamily.class).create();
		CreateSql.newInstance(ResumeWork.class).create();
	}
}
