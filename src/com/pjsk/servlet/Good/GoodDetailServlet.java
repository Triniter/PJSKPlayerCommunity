package com.pjsk.servlet;

import com.pjsk.entity.Good;
import com.pjsk.service.GoodService;
import com.pjsk.service.UserService;
import com.pjsk.service.impl.GoodServiceImpl;
import com.pjsk.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/good_detail")
public class GoodDetailServlet extends HttpServlet {
    private GoodService goodService = new GoodServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取商品ID参数
        int goodid = Integer.parseInt(request.getParameter("goodid"));

        // 调用 Service 层方法获取商品详情
        Good good = goodService.getGoodById(goodid);

        // 将商品对象存入 request 属性中
        request.setAttribute("good", good);

        // 转发到商品详情页面
        request.getRequestDispatcher("good_detail.jsp").forward(request, response);
    }
}
