package cn.aki.form.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * 身份证号码验证注解
 * @author aki
 * 2016年4月22日 下午2:51:07
 */
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=IdNumberValidator.class)
public @interface IdNumber {
	/*规定如此*/
	String message() default "{v.idNumber}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
