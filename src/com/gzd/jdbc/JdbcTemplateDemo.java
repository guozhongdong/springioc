package com.gzd.jdbc;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Created by gzd on 2017/5/20.
 * 测试spring jdbc
 */
public class JdbcTemplateDemo {

    @Test
    public void add(){
        //1、加载驱动
        DriverManagerDataSource dataSource =  new DriverManagerDataSource();

        //2、创建数据库连接
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/gzd");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        //执行sql语句
        String sql = "insert into users values(?,?)";

       JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
       int rows = jdbcTemplate.update(sql,"haha","123456");
       System.out.println(rows);

    }
}
