package com.pjsk.servlet;

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
import java.io.PrintWriter;


@WebServlet("/comment")
public class CommentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");

        // 获取out对象
        PrintWriter out = response.getWriter();

        // 设置字符编码
        request.setCharacterEncoding("utf-8");

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
        Integer userid = user.getUserid();
        String profile = user.getProfile();


        Integer postid = (Integer) session.getAttribute("postid");

        // 接收数据
        String text = request.getParameter("text");

        // 插入新的帖子记录
        JDBCUtil jdbcUtil = new JDBCUtil();
        //
        String sql = "insert into comment values(null, ?, ?, ?)";

        boolean flag = jdbcUtil.execUpdate(sql, postid, userid, text);

        if (flag) {
            // 帖子发布成功，使用JavaScript弹出提示并跳转到post.jsp
            out.print("<script>alert('评论发布成功');location='post.jsp'</script>");
        } else {
            // 帖子发布失败，使用JavaScript弹出提示并返回上一页
            out.print("<script>alert('评论发布失败');history.back()</script>");
        }
    }

}

