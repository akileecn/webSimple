package cn.aki.form.validator;

import java.lang.reflect.Field;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

import cn.aki.entity.User;
import cn.aki.other.SpringContextUtils;
import cn.aki.service.UserService;

/**
 * 用户唯一字段验证
 * @author aki
 * 2016年4月26日 下午2:00:26
 */
public class UserUniqueValidator implements ConstraintValidator<UserUnique, String>{
	private UserService userService;
	private String fieldName;
	public void initialize(UserUnique constraintAnnotation) {
		userService=SpringContextUtils.getBean(UserService.class);
		fieldName=constraintAnnotation.field();
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		//不验证空
		if(StringUtils.isEmpty(value)){
			return true;
		}
		User user=new User();
		Field field;
		try {
			field = User.class.getDeclaredField(fieldName);
			field.setAccessible(true);
			field.set(user,value);
			return !userService.exists(user);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
