package com.pjsk.servlet.Post;

import com.pjsk.entity.Post;
import com.pjsk.util.JDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/user_profile")
public class UserPostProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Post> userPosts = new ArrayList<>();

        Integer userid = Integer.parseInt(request.getParameter("userid"));

        JDBCUtil jdbcUtil = new JDBCUtil();

        // 查询用户的帖子
        String sql = "SELECT p.*, u.username FROM post p JOIN user u ON p.userid = u.userid WHERE p.userid = ?";

        try {
            ResultSet rs = jdbcUtil.execQuery(sql, userid);

            while (rs.next()) {
                Post post = new Post();
                post.setUserid(rs.getInt("userid"));
                post.setTitle(rs.getString("title"));
                post.setText(rs.getString("text"));
                post.setPosttime(rs.getTimestamp("posttime"));
                post.setUsername(rs.getString("username")); // 设置 username
                userPosts.add(post);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("userPosts", userPosts);
        request.getRequestDispatcher("user_profile.jsp").forward(request, response);
    }
}
