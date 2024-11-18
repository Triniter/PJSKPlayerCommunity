package com.pjsk.servlet.Maneger;


import com.pjsk.util.JDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ma_delete_batch")
public class MaDeleteBatchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置响应的内容类型
        response.setContentType("text/html;charset=utf-8");

        //获取out对象
        PrintWriter out = response.getWriter();


        //接收数据
        String[] userids = request.getParameterValues("userid");

        //System.out.println(Arrays.toString(userids));

        //根据用户编号删除多个用户记录
        JDBCUtil jdbcUtil = new JDBCUtil();
        String sql = "delete from user where userid = ?";

        for (String suserid : userids) {
            int userid = Integer.parseInt(suserid);
            jdbcUtil.execUpdate(sql, userid);
        }

        out.print("<script>alert('用户批量删除成功');location='/ma_query'</script>");

    }
}
