package com.pjsk.servlet.Good;

import com.pjsk.entity.Good;
import com.pjsk.entity.User;
import com.pjsk.service.GoodService;
import com.pjsk.service.impl.GoodServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/good_query")
public class GoodQueryServlet extends HttpServlet {

    private GoodService goodService = new GoodServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        User user = (User)session.getAttribute("user");
        if (user==null) {
            out.print("<script>alert('你没有登录');location.href='base.jsp'</script>");
        } else {
            // 调用 Service 层方法获取所有商品数据
            List<Good> goods = goodService.getAllGoods();

            // 将获取到的数据放入请求的属性中
            request.setAttribute("goods", goods);

            // 转发到 JSP 页面进行展示
            request.getRequestDispatcher("/shop.jsp").forward(request, response);
        }

    }
}
