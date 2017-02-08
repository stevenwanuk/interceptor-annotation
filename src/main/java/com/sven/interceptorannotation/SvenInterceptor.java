package com.sven.interceptorannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Autowired
@Retention(RetentionPolicy.RUNTIME)
@Target(value = { ElementType.TYPE })
@Component
public @interface SvenInterceptor
{
    String value() default "";

    String inclusivePathPatterns() default "";

    String exclusivePathPatterns() default "";
}
