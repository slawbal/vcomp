package com.sb.aop.aopspring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = {AopSpringApplication.class, MethodInterceptor.class})
@AutoConfigureMockMvc
public class SomeAspectBeanTest {

    @Autowired
    SomeAspectBean bean;

    @Test
    public void interceptorShouldPrintMessageBeforeAndAfterMethodInvoke() {
        bean.someMethod();
    }
}