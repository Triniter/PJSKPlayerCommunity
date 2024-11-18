package com.pjsk.servlet.Maneger;

import com.pjsk.util.JDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ma_modify")
public class MaModifyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置响应的内容类型
        response.setContentType("text/html;charset=utf-8");

        //获取out对象
        PrintWriter out = response.getWriter();

        //设置字符编码
        request.setCharacterEncoding("utf-8");

        //接收表单数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String profile = request.getParameter("profile");

        //接收隐藏域的数据
        int userid = Integer.parseInt(request.getParameter("userid"));

        JDBCUtil jdbcUtil = new JDBCUtil();

        String sql = "update user set username = ?, password = ?, profile = ? where userid = ?";

        boolean flag = jdbcUtil.execUpdate(sql, username, password, profile, userid);

        if(flag){
            out.print("<script>alert('用户修改成功');location='/ma_query'</script>");
        }else{
            out.print("<script>alert('用户修改失败');history.back()</script>");
        }

    }
}
