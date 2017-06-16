package com.gzd.util;

import com.gzd.service.UserDao;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by gzd on 2017/6/11.
 */
public class ParseCode {

    @Test
    public void testParse(){

        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("spring.xml"));
        UserDao userdao = (UserDao) bf.getBean("userdao");
    }
}
