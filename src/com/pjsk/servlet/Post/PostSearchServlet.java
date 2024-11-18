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

@WebServlet("/post_search")
public class PostSearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Post> searchList = new ArrayList<>();

        String title = request.getParameter("title");

        JDBCUtil jdbcUtil = new JDBCUtil();

        String sql ="SELECT * FROM post WHERE title LIKE ?";

        try {
            ResultSet rs = jdbcUtil.execQuery(sql,"%" + title + "%");

            while (rs.next()) {
                Post post = new Post();
                post.setPostid(rs.getInt("postid"));
                post.setUserid(rs.getInt("userid"));
                post.setTitle(rs.getString("title"));
                post.setText(rs.getString("text"));
                post.setPosttime(rs.getTimestamp("posttime"));

                searchList.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //System.out.println(postdetailList);
        request.setAttribute("searchList", searchList);
        request.getRequestDispatcher("search_result.jsp").forward(request, response);
    }
}
