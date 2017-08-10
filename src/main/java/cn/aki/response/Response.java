package cn.aki.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 响应基类
 *
 * @param <T>
 * @param <E>
 * @author aki
 * 2016年4月26日 上午11:54:43
 */
@Data
public abstract class Response<T, E> {
	@ApiModelProperty("返回数据")
	protected T data;
	@ApiModelProperty("错误信息")
	protected E error;
	@ApiModelProperty("提示信息")
	protected String message;
	@ApiModelProperty("错误代码")
	protected String code;

	/**
	 * 是否成功
	 *
	 * @return
	 */
	public boolean isSuccess() {
		return error == null && code == null && message == null && data != null;
	}
}
