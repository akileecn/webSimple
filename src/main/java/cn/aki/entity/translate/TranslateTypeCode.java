package cn.aki.entity.translate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 翻译字段类型
 * @author Aki
 * 2016年5月18日 下午9:48:16
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TranslateTypeCode {
	String value() default "";
}
