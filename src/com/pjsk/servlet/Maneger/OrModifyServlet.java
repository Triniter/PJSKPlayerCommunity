package com.pjsk.servlet.Maneger;


import com.pjsk.util.JDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/or_modify")
public class OrModifyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置响应的内容类型
        response.setContentType("text/html;charset=utf-8");

        //获取out对象
        PrintWriter out = response.getWriter();

        //设置字符编码
        request.setCharacterEncoding("utf-8");

        //接收表单数据
        String goodid = request.getParameter("goodid");
        String userid = request.getParameter("userid");
        String status = request.getParameter("status");

        //接收隐藏域的数据
        int orderid = Integer.parseInt(request.getParameter("orderid"));

        JDBCUtil jdbcUtil = new JDBCUtil();

        String sql = "update orders set  goodid = ?,userid = ?, order_status = ? where orderid = ?";

        boolean flag = jdbcUtil.execUpdate(sql, goodid, userid, status,orderid);

        if(flag){
            out.print("<script>alert('订单修改成功');location='/or_query'</script>");
        }else{
            out.print("<script>alert('订单修改失败');history.back()</script>");
        }

    }
}
