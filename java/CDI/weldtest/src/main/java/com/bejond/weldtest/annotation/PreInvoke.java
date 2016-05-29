package com.bejond.weldtest.annotation;

import javax.inject.Qualifier;
import javax.interceptor.InterceptorBinding;
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by bejond on 5/29/16.
 */
@Qualifier
@InterceptorBinding
@Target ({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PreInvoke {
}
