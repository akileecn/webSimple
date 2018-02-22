package cn.aki.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 响应基类
 *
 * @param <T>
 * @author aki
 * 2016年4月26日 上午11:54:43
 */
@Data
public class Response<T> {
    @ApiModelProperty("返回数据")
    protected T data;
    @ApiModelProperty("错误信息")
    protected String message;
    @ApiModelProperty("错误代码")
    protected String code;
    @ApiModelProperty("是否成功")
    private Boolean success;

    public static Response<Void> success() {
        return success(null);
    }

    public static <T> Response<T> success(T t) {
        Response<T> response = new Response<>();
        response.setSuccess(true);
        response.setData(t);
        return response;
    }

    public static Response<Void> fail(String message) {
        return fail(null, message);
    }

    public static Response<Void> fail(String code, String message) {
        Response<Void> response = new Response<>();
        response.setSuccess(false);
        response.setCode(code);
        response.setMessage(message);
        return response;
    }

}
