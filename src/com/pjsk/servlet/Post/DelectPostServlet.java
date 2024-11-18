package com.pjsk.servlet.Post;

import com.pjsk.util.JDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deletePost")
public class DelectPostServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        request.setCharacterEncoding("utf-8");

        PrintWriter out = response.getWriter();

        String postId = request.getParameter("postId");

        JDBCUtil jdbcUtil = new JDBCUtil();

        String sql = "DELETE FROM post WHERE postId = ?;";

        boolean flag = jdbcUtil.execUpdate(sql,postId);

        if (flag) {
            // 帖子发布成功，使用JavaScript弹出提示并跳转到post.jsp
            out.print("<script>alert('删除成功');location='/my_post'</script>");
        } else {
            // 帖子发布失败，使用JavaScript弹出提示并返回上一页
            out.print("<script>alert('删除失败');history.back()</script>");
        }
    }
}



