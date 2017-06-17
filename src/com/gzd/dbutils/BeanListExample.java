package com.gzd.dbutils;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class BeanListExample {

    private ComboPooledDataSource dataSource;

    public void setDataSource(ComboPooledDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static void main(String[] args) {

        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/gzd";
        String jdbcDriver = "com.mysql.jdbc.Driver";
        String user = "gzd";
        String password = "123456";
        DbUtils.loadDriver(jdbcDriver);
        try {
            conn = DriverManager.getConnection(url, user, password);
            QueryRunner qr = new QueryRunner();
            List results = (List) qr.query(conn, "select id,name from guestbook", new BeanListHandler(Guestbook.class));
            for (int i = 0; i < results.size(); i++) {
                Guestbook gb = (Guestbook) results.get(i);
                System.out.println("id:" + gb.getId() + ",name:" + gb.getName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }
}
