package com.pjsk.servlet.Post;

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

@WebServlet("/post")
public class PostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        List<Post> postList = new ArrayList<>();

        JDBCUtil jdbcUtil = new JDBCUtil();

        String sql = "SELECT post.*, user.username FROM post JOIN user ON post.userid = user.userid";

        try {
            ResultSet rs = jdbcUtil.execQuery(sql);

            while (rs.next()) {
                Post post = new Post();
                post.setPostid(rs.getInt("postid"));
                post.setUserid(rs.getInt("userid"));
                post.setTitle(rs.getString("title"));
                post.setText(rs.getString("text"));
                post.setPosttime(rs.getTimestamp("posttime"));
                post.setUsername(rs.getString("username"));
                postList.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("postList", postList);
        request.getRequestDispatcher("forum.jsp").forward(request, response);
    }
}




