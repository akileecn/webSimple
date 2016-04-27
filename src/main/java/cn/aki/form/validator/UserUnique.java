package cn.aki.form.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * 用户唯一字段
 * @author aki
 * 2016年4月26日 下午1:02:28
 */
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=UserUniqueValidator.class)
public @interface UserUnique {
	String message() default "{v.userUnique}";
	/**
	 * 用户实体字段
	 * @return
	 */
	String field();
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
