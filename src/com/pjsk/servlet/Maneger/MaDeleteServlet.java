package com.pjsk.servlet.Maneger;

import com.pjsk.util.JDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ma_delete")
public class MaDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置响应的内容类型
        response.setContentType("text/html;charset=utf-8");

        //获取out对象
        PrintWriter out = response.getWriter();

        //接收数据
        int userid = Integer.parseInt(request.getParameter("userid"));

        //根据用户编号删除用户记录
        JDBCUtil jdbcUtil = new JDBCUtil();

        String sql = "delete from user where userid = ?";

        boolean flag = jdbcUtil.execUpdate(sql, userid);

        if(flag){
            out.print("<script>alert('用户删除成功');location='/ma_query'</script>");
        }else{
            out.print("<script>alert('用户删除失败');history.back()</script>");
        }

    }
}