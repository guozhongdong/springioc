package com.gzd.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by gzd on 2017/5/20.
 * 测试aop
 */
public class TestAop {

    @Test
    public void buyBook(){
        ApplicationContext context = new ClassPathXmlApplicationContext("springaop.xml");
        Book book = (Book) context.getBean("book");
        book.buy();
    }
}
