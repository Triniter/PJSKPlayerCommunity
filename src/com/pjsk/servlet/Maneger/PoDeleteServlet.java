package com.pjsk.servlet.Maneger;

import com.pjsk.util.JDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/po_delete")
public class PoDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置响应的内容类型
        response.setContentType("text/html;charset=utf-8");

        //获取out对象
        PrintWriter out = response.getWriter();

        //接收数据
        int postid = Integer.parseInt(request.getParameter("postid"));

        //根据用户编号删除用户记录
        JDBCUtil jdbcUtil = new JDBCUtil();

        String sql = "delete from post where postid = ?";

        boolean flag = jdbcUtil.execUpdate(sql, postid);

        if(flag){
            out.print("<script>alert('帖子删除成功');location='/po_query'</script>");
        }else{
            out.print("<script>alert('帖子删除失败');history.back()</script>");
        }

    }
}