package com.pjsk.util;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

//JDBC的工具类
public class  JDBCUtil {

    //读取属性文件
    private static String driver, url, username, password;

    static {
        Properties properties = new Properties();

        try {

            //加载属性文件到内存
            properties.load(JDBCUtil.class.getResourceAsStream("jdbc-config.properties"));

            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Connection conn;
    private PreparedStatement pstmt;

    public JDBCUtil(){
        //加载JDBC驱动
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //只在类内部使用
    private void openConnection(){
        try {
            this.conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection(){

        try {
            if(this.pstmt!=null) {
                this.pstmt.close();
                this.pstmt = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if(this.conn!=null) {
                this.conn.close();
                this.conn = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //数据更新
    public boolean execUpdate(String sql, Object... params){

        try {
            //获取连接
            openConnection();

            //通过conn创建语句对象
            this.pstmt = conn.prepareStatement(sql);

            //参数赋值
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i+1, params[i]);
            }

           return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            //关闭连接
            this.closeConnection();
        }

    }

    //数据查询
    public ResultSet execQuery(String sql, Object... params){

        try {
            //获取连接
            openConnection();

            //通过conn创建语句对象
            this.pstmt = conn.prepareStatement(sql);

            //参数赋值
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i+1, params[i]);
            }

            return pstmt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {

        JDBCUtil jdbcUtil = new JDBCUtil();

        String sql = "insert into user values(null, ?, ?, ?, ?, now())";

        boolean flag = jdbcUtil.execUpdate(sql,"user5", "5", 50, "5,gif");

        System.out.println("flag = " + flag);



    }

}
