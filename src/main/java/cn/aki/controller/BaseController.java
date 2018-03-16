package cn.aki.controller;

import cn.aki.utils.Response;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * controller基类
 *
 * @author aki
 * 2016年4月25日 上午10:54:41
 */
public abstract class BaseController {

    /**
     * 处理表单验证的公共方法
     */
    protected <T> Response<T> handleFormError(Response<T> response, BindingResult result) {
        if (result.hasErrors()) {
            response.setSuccess(false);
            FieldError fieldError = result.getFieldError();
            String message = fieldError.getField() + fieldError.getDefaultMessage();
            response.setMessage(message.contains("NumberFormatException") ? "请输入整数" : message);
        } else {
            response.setSuccess(true);
        }
        return response;
    }

    /**
     * 处理表单验证的公共方法
     */
    protected Response<Void> handleFormError(BindingResult result) {
        Response<Void> response = Response.success();
        handleFormError(response, result);
        return response;
    }

}
