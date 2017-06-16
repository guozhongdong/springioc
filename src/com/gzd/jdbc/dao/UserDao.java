package com.gzd.jdbc.dao;

import com.gzd.jdbc.JdbcTemplateDemo;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by gzd on 2017/5/21.
 * 测试 配置文件添加 连接池
 */
public class UserDao {

    private JdbcTemplateDemo jdbcTemplateDemo;

    //添加用户
    public void setJdbcTemplateDemo(JdbcTemplateDemo jdbcTemplateDemo) {
        this.jdbcTemplateDemo = jdbcTemplateDemo;
    }

    public void  add(){

        jdbcTemplateDemo.addUser();
    }
    public void  addSalary(){

        jdbcTemplateDemo.addSalary();
    }
    public void  delSalary(){

        jdbcTemplateDemo.delSalary();
    }

}
