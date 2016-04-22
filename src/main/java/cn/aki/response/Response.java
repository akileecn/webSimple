package cn.aki.response;

/**
 * 响应
 * @author aki
 * 2016年4月22日 下午3:28:50
 */
public interface Response {
	/**
	 * 是否成功
	 * @return
	 */
	boolean success();
	/**
	 * 返回数据
	 * @return
	 */
	Object getData();
}
