package com.pjsk.dao.impl;

import com.pjsk.dao.UserDAO;
import com.pjsk.entity.User;
import com.pjsk.util.JDBCUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {

    private JDBCUtil jdbcUtil = new JDBCUtil();

    @Override
    public User findUser(String username, String password) {
        String sql = "select * from user where username = ? and password = ?";
        ResultSet rs = jdbcUtil.execQuery(sql, username, password);

        try {
            //登录验证
            if(rs.next()){

                User user = new User();

                user.setUserid(rs.getInt(1));
                user.setUsername(username);
                user.setPassword(password);
                user.setProfile(rs.getString(4));
                user.setBalance(rs.getFloat(5));
                user.setTel(rs.getString(6));
                user.setAddress(rs.getString(7));
                user.setMessage(rs.getString(8));
                user.setRole(rs.getString(9));

                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User updateUser(Integer userid) {
        String sql = "select * from user where userid = ?";
        ResultSet rs = jdbcUtil.execQuery(sql, userid);
        try {
            //登录验证
            if(rs.next()){

                User user = new User();

                user.setUserid(userid);
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setProfile(rs.getString(4));
                user.setBalance(rs.getFloat(5));
                user.setTel(rs.getString(6));
                user.setAddress(rs.getString(7));
                user.setMessage(rs.getString(8));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public boolean checkUser(String username) {
        String sql = "select * from user where username = ?";
        ResultSet rs = jdbcUtil.execQuery(sql, username);
        try {
            if(rs.next()){

                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkModifyUser(Integer userid, String username) {
        String sql = "select * from user where username = ? and userid not in (?)";
        ResultSet rs = jdbcUtil.execQuery(sql, username, userid);
        try {
            if(rs.next()){

                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean register(String username, String password, String tel, String address) {
        String sql = "insert into user values(null, ?, ?, null, 100, ?,  ?, null, 'us')";
        return jdbcUtil.execUpdate(sql, username, password, tel, address);
    }

    @Override
    public boolean modify(Integer userid, String username, String password, String tel, String address) {
        String sql = "update user set username = ?, password = ?, tel = ?, address = ? where userid = ?";
        return jdbcUtil.execUpdate(sql, username, password, tel, address, userid);
    }

    @Override
    public boolean recharge(Integer userid, Double amount) {
        String sql = "update user set balance = ? where userid = ?";
        return jdbcUtil.execUpdate(sql, amount, userid);
    }

    @Override
    public boolean ModifyMessage(Integer userid, String message) {
        String sql = "update user set message = ? where userid = ?";
        return jdbcUtil.execUpdate(sql, message, userid);
    }

    public static class DBConnection {
        private static final String Driver = "com.mysql.cj.jdbc.Driver";
        private static final String url="jdbc:mysql://localhost:3306/pjsk?serverTimezone=Asia/Shanghai";
        private static final String user = "root";
        private static final String password = "123456";
        private Connection conn = null;

        public DBConnection() throws Exception { // 进行数据库连接
            try {
                Class.forName(Driver); // 用反射加载数据库驱动
                this.conn = DriverManager.getConnection(url, user, password);
            } catch (Exception e) {
                throw e; // 抛出异常
            }
        }

        public Connection getConnection() {
            return this.conn; // 取得数据库的连接
        }

        public void close() throws Exception { // 关闭数据库
            if (this.conn != null) {
                try {
                    this.conn.close(); // 数据库关闭
                } catch (Exception e) {
                    throw e;
                }
            }
        }
    }

}
