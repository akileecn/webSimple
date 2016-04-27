package cn.aki.form.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;
/**
 * 身份证号码验证
 * @author aki
 * 2016年4月22日 下午3:05:26
 */
public class IdNumberValidator implements ConstraintValidator<IdNumber, String>{

	public void initialize(IdNumber constraintAnnotation) {
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		//不验证空
		if(StringUtils.isEmpty(value)){
			return true;
		}
		//TODO 具体验证
		int length=value.length();
		if(length==15||length==18){
			return true;
		}
		return false;
	}

}
