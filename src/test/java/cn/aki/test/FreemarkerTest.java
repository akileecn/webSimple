package cn.aki.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class FreemarkerTest {

	@Test
	public void initTest(){
		Configuration configuration=new Configuration(Configuration.VERSION_2_3_24);
		OutputStreamWriter osw=null;
		try {
			/*配置*/
			final String tempatePath="C:/Users/Aki/git/web/src/main/webapp/WEB-INF/template";
			configuration.setDirectoryForTemplateLoading(new File(tempatePath));
			configuration.setDefaultEncoding("utf-8");
			configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
			//不记录，抛出来
			configuration.setLogTemplateExceptions(false);
			/*model*/
			Map<String,String> data=new HashMap<String, String>();
			data.put("name", "姓名1");
			data.put("gender", "男");
			data.put("birthday", "2016-4-14");
			/*模版*/
			Template template=configuration.getTemplate("wordTemplate.xml");
			/*目标文件*/
			final String targetFilePath="D:/Download/生成的word.doc";
			osw=new OutputStreamWriter(new FileOutputStream(new File(targetFilePath)),"utf-8");
			template.process(data, osw);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		} finally {
			if(osw!=null){
				try {
					osw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
