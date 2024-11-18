package com.pjsk.servlet.Maneger;

import com.pjsk.util.JDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Or_delete_batch")
public class OrDeleteBatchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置响应的内容类型
        response.setContentType("text/html;charset=utf-8");

        //获取out对象
        PrintWriter out = response.getWriter();


        //接收数据
        String[] orderids = request.getParameterValues("orderid");

        //System.out.println(Arrays.toString(userids));

        //根据用户编号删除多个用户记录
        JDBCUtil jdbcUtil = new JDBCUtil();
        String sql = "delete from order where orderid = ?";

        for (String suserid : orderids) {
            int orderid = Integer.parseInt(suserid);
            jdbcUtil.execUpdate(sql, orderid);
        }

        out.print("<script>alert('订单批量删除成功');location='or_query'</script>");

    }
}