package com.sb.aop;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

@Stateless
public class SomeBean {

    @Interceptors(MethodInterceptor.class)
    public String someMethod(){
        System.out.println("Method invoke");
        return "";
    }
}
