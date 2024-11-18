package com.pjsk.servlet;

import com.pjsk.entity.Good;
import com.pjsk.service.GoodService;
import com.pjsk.service.impl.GoodServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/good_search")
public class GoodSearchServlet extends HttpServlet {

    private GoodService goodService = new GoodServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String keyword = request.getParameter("keyword");
        String minPriceStr = request.getParameter("minPrice");
        String maxPriceStr = request.getParameter("maxPrice");

        // 转换价格参数为 float 类型，如果输入为空则默认为最小和最大值
        float minPrice = (minPriceStr != null && !minPriceStr.isEmpty()) ? Float.parseFloat(minPriceStr) : Float.MIN_VALUE;
        float maxPrice = (maxPriceStr != null && !maxPriceStr.isEmpty()) ? Float.parseFloat(maxPriceStr) : Float.MAX_VALUE;


        // 调用 Service 层方法进行模糊搜索
        List<Good> goods = goodService.searchGoods(keyword, minPrice, maxPrice);

        // 将搜索结果存入 request 属性中
        request.setAttribute("goods", goods);

        // 转发到 JSP 页面进行显示
        request.getRequestDispatcher("/shop.jsp").forward(request, response);


    }
}
