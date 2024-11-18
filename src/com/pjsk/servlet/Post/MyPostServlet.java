package com.pjsk.servlet.Post;

import com.pjsk.entity.Post;
import com.pjsk.entity.User;
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


@WebServlet("/my_post")
public class MyPostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    HttpSession session = request.getSession();

    User user = (User) session.getAttribute("user");
    Integer userid=user.getUserid();

        List<Post> mypostList = new ArrayList<>();

        JDBCUtil jdbcUtil = new JDBCUtil();

        String sql ="SELECT * FROM post WHERE userid =?";

        try {
            ResultSet rs = jdbcUtil.execQuery(sql,userid);

            while (rs.next()) {
                Post post = new Post();
                post.setPostid(rs.getInt("postid"));
                post.setUserid(rs.getInt("userid"));
                post.setTitle(rs.getString("title"));
                post.setText(rs.getString("text"));
                post.setPosttime(rs.getTimestamp("posttime"));
                mypostList.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("mypostList", mypostList);
        request.getRequestDispatcher("my_post.jsp").forward(request, response);

    }
}
