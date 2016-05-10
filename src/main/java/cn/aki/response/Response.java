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
		return error==null&&data!=null;
	}
	public E getError() {
		return error;
	}
	public void setError(E error) {
		this.error = error;
	}
}
