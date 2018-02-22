package cn.aki.form.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;

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
		if(value.matches("\\d{17}[0-9xX]")){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
			String datePart=value.substring(6, 14);
			try {
				//时间校验
				sdf.parse(datePart);
			} catch (ParseException e) {
				return false;
			}
			//最后一位校验
			int[] b={7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
			char[] lasts={'1','0','X','9','8','7','6','5','4','3','2'};
			int sum=0;
			Integer a=null;
			for(int i=0;i<b.length;i++){
				a=Integer.parseInt(value.substring(i, i+1));
				sum+=a*b[i];
			}
			char last=lasts[sum%11];
			return value.charAt(17)==last;
		}
		return false;
	}

}
