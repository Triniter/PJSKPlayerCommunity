package com.pjsk.servlet.Maneger;

import com.pjsk.util.JDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ma_register")
public class MaRegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //设置响应的内容类型
        response.setContentType("text/html;charset=utf-8");

        //获取out对象
        PrintWriter out = response.getWriter();

        //设置字符编码
        request.setCharacterEncoding("utf-8");

        //接收数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //插入新的用户记录
        JDBCUtil jdbcUtil = new JDBCUtil();

        String sql = "insert into user values(null, ?, ?, null,null, null,null,null,'ma')";

        boolean flag = jdbcUtil.execUpdate(sql, username, password);

        if(flag){
            out.print("<script>alert('管理员添加成功');location='maneger_home.jsp'</script>");
        }else{
            out.print("<script>alert('管理员添加失败');history.back()</script>");
        }
    }
}
