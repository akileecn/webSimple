package cn.aki.form.validator;

import java.util.Date;

/**
 * 拥有开始时间和结束时间
 * @author Aki
 * 2016年7月1日 上午12:26:16
 */
public interface BeginAndEndDate {
	/**
	 * 获得开始时间
	 * @return
	 */
	public Date getBeginDate();
	/**
	 * 获得结束时间
	 * @return
	 */
	public Date getEndDate();
	
}
