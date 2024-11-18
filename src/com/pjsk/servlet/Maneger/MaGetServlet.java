package com.pjsk.servlet.Maneger;


import com.pjsk.entity.User;
import com.pjsk.util.JDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/ma_get")
public class MaGetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //接收数据
        int userid = Integer.parseInt(request.getParameter("userid"));

        //根据用户编号删除用户记录
        JDBCUtil jdbcUtil = new JDBCUtil();

        String sql = "select userid, username, password, balance from user where userid = ?";

        ResultSet rs = jdbcUtil.execQuery(sql, userid);

        //创建实体类对象
        User user = null;

        try {
            if(rs.next()){

                user = new User();

                //填充实体类对象
                user.setUserid(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setBalance(rs.getFloat(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //在request属性范围中保存用户对象
        request.setAttribute("user", user);

        //跳转到用户修改页面
        request.getRequestDispatcher("ma_user_manege.jsp").forward(request, response);


    }
}
