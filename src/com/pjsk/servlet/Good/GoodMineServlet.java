package com.pjsk.servlet.Good;

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

@WebServlet("/good_mine")
public class GoodMineServlet extends HttpServlet {

    private GoodService goodService = new GoodServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int userid =Integer.parseInt(request.getParameter("userid"));

        // 调用 Service 层方法获取所有商品数据
        List<Good> goods = goodService.myGoods(userid);

        // 将获取到的数据放入请求的属性中
        request.setAttribute("goods", goods);

        // 转发到 JSP 页面进行展示
        request.getRequestDispatcher("/good_mine.jsp").forward(request, response);

    }
}
