package cn.aki.test;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import cn.aki.entity.Resume;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
/**
 * 自动生成动态sql
 * @author Aki
 * 2016年4月30日 上午1:06:15
 */
public class CreateSql {
	public static void main(String[] args)throws Exception {
		CreateSql sql=CreateSql.newInstance(Resume.class);
		sql.create(Type.insert);
		sql.create(Type.update);
		sql.create(Type.select);
	}
	
	private Class<?> clazz;
	private static final Configuration CONFIGURATION;
	static{
		/*配置*/
		CONFIGURATION=new Configuration(Configuration.VERSION_2_3_24);
		try {
			CONFIGURATION.setDirectoryForTemplateLoading(new File(CreateSql.class.getResource("./").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		CONFIGURATION.setDefaultEncoding("utf-8");
		CONFIGURATION.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		//不记录，抛出来
		CONFIGURATION.setLogTemplateExceptions(false);
	}
	private CreateSql(Class<?> clazz){
		this.clazz=clazz;
	}
	
	/**
	 * 创建实例
	 * @param clazz
	 * @return
	 */
	public static final CreateSql newInstance(Class<?> clazz){
		return new CreateSql(clazz);
	}
	
	//sql类型
	public static enum Type{
		insert,update,select
	}
	/**
	 * 解析结果类型
	 * @author Aki
	 * 2016年4月30日 上午1:25:36
	 */
	public static class TableResult{
		private String table;
		private Map<String,String> columns;
		public String getTable() {
			return table;
		}
		public void setTable(String table) {
			this.table = table;
		}
		public Map<String, String> getColumns() {
			return columns;
		}
		public void setColumns(Map<String, String> columns) {
			this.columns = columns;
		}
	}

	/**
	 * 创建sql
	 * @param type
	 * @throws Exception
	 */
	public void create(Type type) throws Exception{
		String tempalteName=null;
		switch(type){
			case insert:tempalteName="sqlInsert.ftl";break;
			case update:tempalteName="sqlUpdate.ftl";break;
			case select:tempalteName="sqlSelect.ftl";break;
		}
		if(tempalteName!=null){
			Template template=CONFIGURATION.getTemplate(tempalteName);
			template.process(parseClass(clazz), new OutputStreamWriter(System.out));	
		}
	}
	
	/**
	 * 解析类
	 * @param clazz
	 * @return
	 */
	public TableResult parseClass(Class<?> clazz){
		TableResult result=new TableResult();
		Map<String,String> columns=parseFields(clazz);
		String className=clazz.getSimpleName();
		result.table=toLower(className);
		result.columns=columns;
		return result;
	}
	
	//解析获得字段
	private Map<String,String> parseFields(Class<?> clazz){
		if(clazz==Object.class){
			return new LinkedHashMap<String, String>();
		}else{
			Map<String,String> columns=parseFields(clazz.getSuperclass());
			Field[] fields=clazz.getDeclaredFields();
			for(Field field:fields){
				if(isColumn(field)){
					columns.put(toLower(field.getName()),field.getName());
				}
			}
			return columns;
		}
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
