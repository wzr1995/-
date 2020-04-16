package com.wzr.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {

    //获取数据库连接
    public Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("加载数据库驱动异常");
            return null;
        }
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("连接数据库异常");
            return null;
        }
        System.out.println("成功连接数据库");
        return conn;
    }

    //关闭数据库连接
    public void closeConn(Connection conn){
        if(conn!=null){
            try {
                conn.close();
                System.out.println("成功关闭数据库");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
}
