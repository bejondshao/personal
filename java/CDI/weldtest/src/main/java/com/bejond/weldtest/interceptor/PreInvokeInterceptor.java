package com.bejond.weldtest.interceptor;

import com.bejond.weldtest.annotation.PreInvoke;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

/**
 * Created by bejond on 5/29/16.
 */
@Interceptor
@PreInvoke
public class PreInvokeInterceptor implements Serializable {
	@AroundInvoke
	public Object preInvoke(InvocationContext invocationContext) throws Exception {
		System.out.println("This is for around invoking");
		return invocationContext.proceed();
	}
}
