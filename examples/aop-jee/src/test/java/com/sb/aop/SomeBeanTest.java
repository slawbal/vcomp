package com.sb.aop;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;

public class SomeBeanTest {

    private static EJBContainer ejbContainer;

    private SomeBean someBean;

    @BeforeClass
    public static void startTheContainer() {
        ejbContainer = EJBContainer.createEJBContainer();
    }

    @Before
    public void lookupABean() throws NamingException {
        Object object = ejbContainer.getContext().lookup("java:global/aop-jee/SomeBean");
        this.someBean = (SomeBean) object;
    }

    @AfterClass
    public static void stopTheContainer() {
        if (ejbContainer != null) {
            ejbContainer.close();
        }
    }

    @Test
    public void interceptorShouldPrintMessageBeforeAndAfterMethodInvoke() {
        someBean.someMethod();
    }

}