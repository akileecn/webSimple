package cn.aki.other;

/**
 * 请求响应数据
 * @author aki
 * 2016年4月25日 上午9:30:42
 */
public class Response<T,E> {
	private T data;//返回数据
	private boolean success;//是否成功
	private E error;//错误信息
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public E getError() {
		return error;
	}
	public void setError(E error) {
		this.error = error;
	}
	
}
