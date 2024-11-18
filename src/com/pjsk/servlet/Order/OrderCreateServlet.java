package com.pjsk.servlet;

import com.pjsk.service.OrderService;
import com.pjsk.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/create_order")
public class OrderCreateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        Integer goodid = Integer.parseInt(request.getParameter("goodid"));
        Integer userid = Integer.parseInt(request.getParameter("userid"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));
        Float total = Float.parseFloat(request.getParameter("total"));
        Integer rest = Integer.parseInt(request.getParameter("rest"));
        Float balance = Float.parseFloat(request.getParameter("balance"));

        OrderService orderService = new OrderServiceImpl();
        boolean flag = orderService.create(goodid, userid, quantity, total, rest, balance);
        if (flag) {
            session.setAttribute("targetAddress", "/good_query");
            out.print("<script>alert('提交订单成功');location.href='/user_update'</script>");
        } else {
            out.print("<script>alert('提交订单失败');history.back()</script>");
        }
    }
}
