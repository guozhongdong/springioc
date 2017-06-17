package com.gzd.dbutils;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class MapListExample {

    private DataSource dataSource;

    public void testDButil(){

        QueryRunner qr = new QueryRunner(dataSource);
        List result = null;
        try {
            result = qr.query("select * from guestbook",new MapListHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (int i=0;i<result.size();i++){
            Map map = (Map)result.get(i);
            System.out.println(map);
        }
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    /*public static void main(String[] args){
        *//*Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/gzd";
        String jdbcDriver = "com.mysql.jdbc.Driver";
        String user = "gzd";
        String password = "123456";
        DbUtils.loadDriver(jdbcDriver);*//*

        try {
           //conn = DriverManager.getConnection(url, user, password);
            QueryRunner qr = new QueryRunner(dataSource);
            List result = qr.query(conn,"select * from guestbook",new MapListHandler());
            for (int i=0;i<result.size();i++){
                Map map = (Map)result.get(i);
                System.out.println(map);
            }
            Map map1 = qr.query(conn,"select * from guestbook where id =12",new MapHandler());
            System.out.println("返回ma=============="+map1);

            Guestbook guestbook = (Guestbook)qr.query(conn,"select * from guestbook where id =12",new BeanHandler(Guestbook.class));
            System.out.println(guestbook.getId());

            List li = (List)qr.query(conn,"select * from guestbook ",new ColumnListHandler("name"));
            for (int i=0;i<li.size();i++){
                //Map map = (Map)li.get(i);
                System.out.println(li.get(i));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }*/
}
