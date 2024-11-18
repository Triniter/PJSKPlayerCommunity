package com.pjsk.servlet.User;

import com.pjsk.entity.User;
import com.pjsk.service.UserService;
import com.pjsk.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/user_login")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setCharacterEncoding("utf-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserService userService = new UserServiceImpl();
        User user = userService.login(username, password);

        if (user!=null) {
            session.setAttribute("user", user);
            session.removeAttribute("loginError");
            if (user.getRole().equals("ma")) {
                response.sendRedirect("maneger_home.jsp");
            } else {
                response.sendRedirect("index.jsp");
            }
        } else {
            session.setAttribute("loginError", "登录失败");
            response.sendRedirect("index.jsp");
        }
    }
}
