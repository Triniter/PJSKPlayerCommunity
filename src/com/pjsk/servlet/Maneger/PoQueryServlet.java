package com.pjsk.servlet.Maneger;

import com.pjsk.entity.Post;
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

@WebServlet("/po_query")
public class PoQueryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        JDBCUtil jdbcUtil = new JDBCUtil();

        String sql = "select * from post";

        ResultSet rs = jdbcUtil.execQuery(sql);

        //准备空的用户列表
        List<Post> userList = new ArrayList<>();

        try {
            while(rs.next()) {

                //创建实体类对象
                Post user = new Post();

                //填充实体类对象
                user.setPostid(rs.getInt(1));
                user.setUserid(rs.getInt(2));
                user.setProfile(rs.getString(3));
                user.setTitle(rs.getString(4));
                user.setText(rs.getString(5));
                user.setPosttime(rs.getDate(6));

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
        request.getRequestDispatcher("ma_post_manege.jsp").forward(request, response);

    }
}
