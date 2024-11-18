package com.pjsk.servlet.User;

import com.pjsk.entity.User;
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

@WebServlet("/check_username")
public class checkUsernameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");

        UserService userService = new UserServiceImpl();

        if(userService.checkUsername(username)){
            out.print("no");
        }else{
            out.print("yes");
        }
    }
}

