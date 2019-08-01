package com.sb.aop.aopspring;

import org.springframework.stereotype.Component;

@Component
public class SomeAspectBean {

    public String someMethod(){
        System.out.println("Method invoke");
        return "";
    }

}
