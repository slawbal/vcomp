package com.sb.aop.aopspring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class MethodInterceptor {

    @Around("execution(* com.sb.aop.aopspring.SomeAspectBean.someMethod())")
    public Object print(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Interceptor method invoked BEFORE");
        var result = joinPoint.proceed();
        System.out.println("Interceptor method invoked AFTER");
        return result;
    }

}
