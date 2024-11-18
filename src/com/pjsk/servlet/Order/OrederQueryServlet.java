package com.pjsk.servlet.Order;

import com.pjsk.entity.OrderVO;
import com.pjsk.service.OrderService;
import com.pjsk.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/order_query")
public class OrederQueryServlet extends HttpServlet {

    private OrderService orderService = new OrderServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int userid = Integer.parseInt(request.getParameter("userid"));

        // 获取当前用户的订单列表
        List<OrderVO> orders = orderService.getOrdersForUser(userid);

        // 将订单列表存入请求属性中
        request.setAttribute("orders", orders);

        // 转发到订单列表页面
        request.getRequestDispatcher("order_query.jsp").forward(request, response);
}
}
