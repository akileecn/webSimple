package cn.aki.test;

import org.junit.Test;

import cn.aki.entity.Resume;

public class CreateSqlTest {
	@Test
	public void resumeSub(){
		CreateSql.newInstance(Resume.class).create();
//		CreateSql.newInstance(ResumeAward.class).create();
//		CreateSql.newInstance(ResumeEducation.class).create();
//		CreateSql.newInstance(ResumeFamily.class).create();
//		CreateSql.newInstance(ResumeWork.class).create();
	}
}
