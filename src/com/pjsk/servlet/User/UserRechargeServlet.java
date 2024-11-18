package com.pjsk.servlet.User;

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

@WebServlet("/user_recharge")
public class UserRechargeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        Integer userid = Integer.parseInt(request.getParameter("userid"));
        Float amount = Float.parseFloat(request.getParameter("amount"));
        Float balance = Float.parseFloat(request.getParameter("balance"));
        System.out.println("servlet");
        UserService userService = new UserServiceImpl();
        PrintWriter out = response.getWriter();

        amount = amount + balance;
        boolean flag = userService.recharge(userid, amount);

        if (flag) {
            session.setAttribute("targetAddress", "profile.jsp");
            out.print("<script>alert('充值成功');location.href='/user_update'</script>");
        } else {
            out.print("<script>alert('充值失败');history.back()</script>");
        }
    }
}
