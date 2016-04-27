package cn.aki.other;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 时间类型工具
 * @author aki
 * 2016年4月28日 下午7:36:46
 */
public class DateUtils {
	private final static SimpleDateFormat FORMAT=new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * 格式化时间为yyyy-MM-dd
	 * @param date
	 * @return
	 */
	public static String formatDate(Date date){
		return date==null?null:FORMAT.format(date);
	}
}
