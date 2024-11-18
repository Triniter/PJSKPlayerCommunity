package com.pjsk.servlet.Post;

import com.pjsk.entity.Comment;
import com.pjsk.entity.Post;
import com.pjsk.util.JDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/post_detail")
public class PostDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Post> postdetailList = new ArrayList<>();
        List<Comment> commentList = new ArrayList<>();

        Integer postid = Integer.parseInt(request.getParameter("id"));

        JDBCUtil jdbcUtil = new JDBCUtil();

        String sql ="SELECT p.*, u.username FROM post p JOIN user u ON p.userid = u.userid WHERE p.postid = ?";


        try {
            ResultSet rs1 = jdbcUtil.execQuery(sql,postid);

            while (rs1.next()) {
                Post post = new Post();
                post.setUserid(rs1.getInt("userid"));
                post.setTitle(rs1.getString("title"));
                post.setText(rs1.getString("text"));
                post.setPosttime(rs1.getTimestamp("posttime"));
                post.setUsername(rs1.getString("username"));
                postdetailList.add(post);
            }
            rs1.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        String sqlComment = "SELECT c.*, u.username FROM comment c JOIN user u ON c.userid = u.userid WHERE c.postid = ?";

        ResultSet rs2 = jdbcUtil.execQuery(sqlComment,postid);

        try {
            while (rs2.next()) {
                Comment comment = new Comment();
                comment.setCommentid(rs2.getInt("commentid"));
                comment.setPostid(rs2.getInt("postid"));
                comment.setText(rs2.getString("text"));
                comment.setUserid(rs2.getInt("userid"));
                comment.setUsername(rs2.getString("username"));
                commentList.add(comment);
            }
            rs2.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        session.setAttribute("postid", postid);
        request.setAttribute("commentList", commentList);
        request.setAttribute("postdetailList", postdetailList);
        request.getRequestDispatcher("post_detail.jsp").forward(request, response);
    }
}
