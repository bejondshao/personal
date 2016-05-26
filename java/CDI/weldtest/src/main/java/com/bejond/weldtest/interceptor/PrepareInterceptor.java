package com.bejond.weldtest.interceptor;

import com.bejond.weldtest.annotation.Prepare;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * Created by bejond on 2016/5/26.
 */
@Interceptor
@Prepare
public class PrepareInterceptor {

	@AroundInvoke
	public Object aroundInvoke(InvocationContext invocationContext) throws Exception{
		System.out.println("This is for preparing invoking");
		return invocationContext.proceed();
	}
}
