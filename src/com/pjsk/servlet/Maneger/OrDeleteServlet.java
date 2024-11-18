package com.pjsk.servlet.Maneger;


import com.pjsk.util.JDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/or_delete")
public class OrDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置响应的内容类型
        response.setContentType("text/html;charset=utf-8");

        //获取out对象
        PrintWriter out = response.getWriter();

        //接收数据
        int orderid = Integer.parseInt(request.getParameter("orderid"));

        //根据用户编号删除用户记录
        JDBCUtil jdbcUtil = new JDBCUtil();

        String sql = "delete from orders where orderid = ?";

        boolean flag = jdbcUtil.execUpdate(sql, orderid);

        if(flag){
            out.print("<script>alert('订单删除成功');location='or_query'</script>");
        }else{
            out.print("<script>alert('订单删除失败');history.back()</script>");
        }

    }
}