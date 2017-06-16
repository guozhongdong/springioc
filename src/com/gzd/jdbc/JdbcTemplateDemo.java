package com.gzd.jdbc;

import com.gzd.ioc.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by gzd on 2017/5/20.
 * 测试spring jdbc
 */
public class JdbcTemplateDemo {

    private ComboPooledDataSource dataSource;

    public void setDataSource(ComboPooledDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Test
    public void add(){
        //1、加载驱动
        /*DriverManagerDataSource dataSource =  new DriverManagerDataSource();

        //2、创建数据库连接
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/gzd");
        dataSource.setUsername("gzd");
        dataSource.setPassword("123456");*/

        //1、插入语句，执行sql语句
        /*String sql = "insert into users values(?,?)";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int rows = jdbcTemplate.update(sql,"haha","123456");
        System.out.println(rows);*/
        //2、update语句
        /*String sql = "update  users set password =? where username=?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int rows = jdbcTemplate.update(sql,"12","haha");

        System.out.println(rows);*/
        //3、delete语句
        /*String sql = "delete from users where username=?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int rows = jdbcTemplate.update(sql,"haha");
        System.out.println(rows);*/
        //JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        //4、 查询一 返回一个值
        /*String sql  = "select count(*) from users";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int count =  jdbcTemplate.queryForObject(sql,Integer.class);
        System.out.println(count);*/

        //4、 查询一 返回一个对象/
        /*String sql  = "select * from users where username =?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Users user =  jdbcTemplate.queryForObject(sql,new myMapper(),"gzd" );
        System.out.println(user);*/

        //4、 查询一 返回一个集合
       /* String sql  = "select * from users";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<Map<String,Object>> list  = jdbcTemplate.queryForList(sql);
        System.out.println(list);*/

        //System.out.println(user);

    }

    /*添加用户*/
    public void addUser (){

        String sql = "insert into users values(?,?)";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int rows = jdbcTemplate.update(sql,"haha1","1234788");
    }

    /*添加用户*/
    public void addSalary(){

        String sql = "update account set salary=salary+? where username='wang'";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int rows = jdbcTemplate.update(sql,1000);
    }

    public void delSalary(){

        String sql = "update account set salary=salary-? where username='li'";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int rows = jdbcTemplate.update(sql,1000);
    }
}

/*实现类 实现RowMapper接口*/
class myMapper implements RowMapper<Users>{

    @Override
    public Users mapRow(ResultSet resultSet, int i) throws SQLException {

        Users user = new Users();

        String username = resultSet.getString("username");
        String password = resultSet.getString("password");
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }
}


