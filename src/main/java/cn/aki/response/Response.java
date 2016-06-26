package cn.aki.response;
/**
 * 响应基类
 * @author aki
 * 2016年4月26日 上午11:54:43
 * @param <T>
 * @param <E>
 */
public abstract class Response<T, E>{
	protected T data;//返回数据
	protected E error;//错误信息
	protected String message;//提示信息
	protected String code;//错误代码
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	/**
	 * 是否成功
	 * @return
	 */
	public boolean isSuccess(){
		return error==null&&code==null&&message==null&&data!=null;
	}
	public E getError() {
		return error;
	}
	public void setError(E error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
