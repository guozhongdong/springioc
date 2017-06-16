package com.gzd.jdbc;

import com.gzd.jdbc.service.UserService;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.beans.PropertyVetoException;

/**
 * Created by gzd on 2017/5/20.
 * 测试类
 */
public class TestC3P0 {

    @Test
    public void add(){
        ApplicationContext context = new ClassPathXmlApplicationContext("springjdbc.xml");
        UserService userService = (UserService)context.getBean("userService");
        userService.buy();
    }

}
