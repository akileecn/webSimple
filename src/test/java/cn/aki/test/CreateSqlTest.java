package cn.aki.test;

import org.junit.Test;

import cn.aki.entity.Application;

public class CreateSqlTest {
	@Test
	public void resumeSub() throws Exception{
//		CreateSql.newInstance(Resume.class).create();
//		CreateSql.newInstance(ResumeAward.class).create();
//		CreateSql.newInstance(ResumeEducation.class).create();
//		CreateSql.newInstance(ResumeFamily.class).create();
//		CreateSql.newInstance(ResumeWork.class).create();
//		CreateSql.newInstance(ResumeComputer.class).create();
//		CreateSql.newInstance(ResumeForeignLanguage.class).create();
//		CreateSql.newInstance(ResumeStudentCadre.class).create();
//		CreateSql.create("dict.ftl", null);
		CreateSql.newInstance(Application.class).create();
//		CreateSql.newInstance(Notice.class).create();
	}
}
