package com.gzd.jdbc;

import com.gzd.dbutils.MapListExample;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by gzd on 2017/5/20.
 * 测试类
 */
public class TestC3P0 {

    @Test
    public void add(){
        ApplicationContext context = new ClassPathXmlApplicationContext("springdbutil.xml");
        MapListExample mapListExample = (MapListExample)context.getBean("mapListExample");
        mapListExample.testDButil();
    }

}
