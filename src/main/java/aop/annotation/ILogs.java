package aop.annotation;

import java.lang.annotation.*;

/**
 * @Author ZhangGJ
 * @Date 2019/11/04
 * 日志自定义注解
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ILogs {

    String description() default "";
}
