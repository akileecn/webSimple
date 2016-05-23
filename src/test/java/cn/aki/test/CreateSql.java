package cn.aki.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
/**
 * 自动生成动态sql
 * @author Aki
 * 2016年4月30日 上午1:06:15
 */
public class CreateSql {
	private Class<?> clazz;
	private static final Configuration CONFIGURATION;
	static{
		/*配置*/
		CONFIGURATION=new Configuration(Configuration.VERSION_2_3_24);
		try {
			CONFIGURATION.setDirectoryForTemplateLoading(new File(CreateSql.class.getResource("./template").getPath()));
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
	
	/**
	 * 简单生成
	 * @param templateName
	 * @param data
	 * @throws Exception
	 */
	public static void create(String templateName,Object data) throws Exception{
		Template template = CONFIGURATION.getTemplate(templateName);
		template.process(data, new OutputStreamWriter(System.err));
	}
	
	//sql类型
	public static enum Type{
		insert,update,select,all
	}
	/**
	 * 解析结果类型
	 * @author Aki
	 * 2016年4月30日 上午1:25:36
	 */
	public static class TableResult{
		private String table;//表名
		private String bean;//实体名
		private String type;//类型
		private Map<String,String> columns;//列名 属性名键值对
		public String getTable() {
			return table;
		}
		public void setTable(String table) {
			this.table = table;
		}
		public String getBean() {
			return bean;
		}
		public void setBean(String bean) {
			this.bean = bean;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
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
	public void create(){
		try {
			Template template = CONFIGURATION.getTemplate("mapper.ftl");
			TableResult result=parseClass(clazz);
			Writer out=new OutputStreamWriter(new FileOutputStream("D:/"+result.bean+"-mapper.xml"));
			template.process(result, out);
			out.close();
			Template template2=CONFIGURATION.getTemplate("dao.ftl");
			Writer out2=new OutputStreamWriter(new FileOutputStream("D:/"+result.type+"Mapper.java"));
			template2.process(result, out2);
			out2.close();
			System.err.println("done");
		} catch (Exception e) {
			e.printStackTrace();
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
		result.type=className;
		result.bean=Character.toLowerCase(className.charAt(0))+className.substring(1);
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
