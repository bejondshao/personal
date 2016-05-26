package com.bejond.weldtest.annotation;

/**
 * Created by bejond on 2016/5/26.
 */

import javax.interceptor.InterceptorBinding;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention (RUNTIME)
@Target ({ METHOD, TYPE })
@InterceptorBinding
public @interface Prepare {
}
