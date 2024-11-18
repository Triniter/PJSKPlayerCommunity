package com.pjsk.servlet.User;

import com.pjsk.service.UserService;
import com.pjsk.service.impl.UserServiceImpl;
import com.pjsk.util.JDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/user_register")
public class UserRegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String tel = request.getParameter("tel");
        String address = request.getParameter("address");

        HttpSession session = request.getSession();

        if(username.length()<5 || username.length()>8){
            out.print("<script>alert('用户名长度为5~8个字符');history.back()</script>");
            return;
        }

        UserService userService = new UserServiceImpl();

        if(userService.checkUsername(username)){
            out.print("<script>alert('用户名已存在');history.back()</script>");
            return;
        }

        if(password.length()==0){
            out.print("<script>alert('密码不能为空');history.back()</script>");
            return;
        }

        boolean flag = userService.Register(username, password, tel, address);

        if(flag){
            session.setAttribute("loginJump","1");
            out.print("<script>alert('用户注册成功');location='index.jsp'</script>");
        }else{
            out.print("<script>alert('用户注册失败');history.back()</script>");
        }
    }
}
