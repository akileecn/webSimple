package cn.aki.test;

import cn.aki.entity.StaticPage;

public class CreateSqlTest {

	public static void main(String[] args) throws Exception{
		CreateSql.newInstance(StaticPage.class).create();
//		CreateSql.simpelCreate("dict.ftl", null);
	}
}
