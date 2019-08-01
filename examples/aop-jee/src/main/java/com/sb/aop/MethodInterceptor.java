package com.sb.aop;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class MethodInterceptor {

    @AroundInvoke
    public Object interceptorMethod(InvocationContext ctx) throws Exception {
        System.out.println("Interceptor method invoked BEFORE");
        Object result = ctx.proceed();
        System.out.println("Interceptor method invoked AFTER");
        return result;
    }
}
