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
import java.io.PrintWriter;

@WebServlet("/user_update")
public class UserUpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        User user = (User) session.getAttribute("user");
        Integer userid = user.getUserid();
        UserService userService = new UserServiceImpl();
        User newuser = userService.update(userid);

        String targetAddress = (String)session.getAttribute("targetAddress");
        session.removeAttribute("targetAddress");

        if (user!=null) {
            session.setAttribute("user", newuser);
        }
        response.sendRedirect(targetAddress);
    }
}
