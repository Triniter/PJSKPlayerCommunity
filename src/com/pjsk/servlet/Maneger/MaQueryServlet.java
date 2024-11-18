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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ma_query")
public class MaQueryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        JDBCUtil jdbcUtil = new JDBCUtil();

        String sql = "select * from user";

        ResultSet rs = jdbcUtil.execQuery(sql);

        //准备空的用户列表
        List<User> userList = new ArrayList<>();

        try {
            while(rs.next()) {

                //创建实体类对象
                User user = new User();

                //填充实体类对象
                user.setUserid(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setBalance(rs.getFloat(5));
                user.setProfile(rs.getString(4));
                user.setRole(rs.getString(9));

                //将用户对象添加到用户列表中
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //System.out.println(userList);

        //在request属性范围中保存用户列表
        request.setAttribute("userList", userList);

        //跳转到用户查询页面
        request.getRequestDispatcher("ma_user_query.jsp").forward(request, response);

    }
}
