package cn.aki.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.output.WriterOutputStream;

import cn.aki.entity.Resume;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

public class CreateSql {
	public static void main(String[] args)throws Exception {
		new CreateSql().create(Resume.class);
//		System.err.println(new CreateSql().parseClass(Resume.class));
	}
	
	public void create(Class<?> clazz)throws Exception{
		Configuration configuration=new Configuration(Configuration.VERSION_2_3_24);
		/*配置*/
		final String tempatePath="D:/Workspace/mine/webSimple/src/main/webapp/WEB-INF/template";
		configuration.setDirectoryForTemplateLoading(new File(tempatePath));
		configuration.setDefaultEncoding("utf-8");
		configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		//不记录，抛出来
		configuration.setLogTemplateExceptions(false);
		/*模版*/
		Template template=configuration.getTemplate("sqlCreate.ftl");
		template.process(parseClass(clazz), new OutputStreamWriter(System.out));
	}
	
	private Map<String,Object> parseClass(Class<?> clazz){
		Map<String,Object> result=new HashMap<String, Object>();
		String className=clazz.getSimpleName();
		result.put("table", toLower(className));
		Field[] fields=clazz.getDeclaredFields();
		Map<String,String> columns=new HashMap<String, String>();
		for(Field field:fields){
			if(isColumn(field)){
				columns.put(toLower(field.getName()),field.getName());
			}
		}
		result.put("columns", columns);
		return result;
	}
	
	//大写转"_"+小写
	private String toLower(String source){
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<source.length();i++){
			char word=source.charAt(i);
			if(Character.isUpperCase(word)){
				if(i!=0){
					sb.append("_");
				}
				sb.append(Character.toLowerCase(word));
			}else{
				sb.append(word);
			}
		}
		return sb.toString();
	}
	
	//是否为列
	private boolean isColumn(Field field){
		Class<?> fieldType=field.getType();
		return (Integer.class.isAssignableFrom(fieldType)
				||Boolean.class.isAssignableFrom(fieldType)
				||String.class.isAssignableFrom(fieldType)
				||Date.class.isAssignableFrom(fieldType));
	}
}
