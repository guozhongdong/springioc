package com.gzd.anno;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by gzd on 2017/5/20.
 * 测试注解
 */
public class TestAnno {

    @Test
    public void add(){

        ApplicationContext context = new ClassPathXmlApplicationContext("springAnno.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.add();
    }
}
