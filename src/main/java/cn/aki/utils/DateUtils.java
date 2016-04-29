package cn.aki.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 时间类型工具
 * @author aki
 * 2016年4月28日 下午7:36:46
 */
public class DateUtils {
	/**
	 * yyyy-MM-dd
	 */
	public final static SimpleDateFormat FORMAT_SHORT=new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public final static SimpleDateFormat FORMAT_LONG=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * 格式化时间为yyyy-MM-dd
	 * @param date
	 * @return
	 */
	public static String formatDate(Date date){
		return date==null?null:FORMAT_SHORT.format(date);
	}
	
	/**
	 * 解析时间字符串yyyy-MM-dd或yyyy-MM-dd HH:mm:ss
	 * @param str
	 * @return
	 */
	public static Date parse(String str){
		if(str!=null){
			try {
				if(str.length()==10){
					return FORMAT_SHORT.parse(str);
				}else if(str.length()==19){
					return FORMAT_LONG.parse(str);
				}
			} catch (ParseException e) {
			}
		}
		return null;
	}
}
