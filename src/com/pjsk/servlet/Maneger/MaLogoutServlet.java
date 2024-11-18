package com.pjsk.servlet.Maneger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ma_logout")
public class MaLogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取session对象
        HttpSession session = request.getSession();

        //设置响应的内容类型
        response.setContentType("text/html;charset=utf-8");

        //获取out对象
        PrintWriter out = response.getWriter();


        //从session属性范围中删除用户对象
        session.removeAttribute("user");

        //弹框并跳转到登录页面
        out.print("<script>alert('注销成功');location='index.jsp'</script>");

    }
}
