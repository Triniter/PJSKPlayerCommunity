package com.pjsk.servlet.Maneger;

import com.pjsk.entity.Order;
import com.pjsk.util.JDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/or_get")
public class OrGetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //接收数据
        int orderid = Integer.parseInt(request.getParameter("orderid"));

        //根据用户用户编号删除记录
        JDBCUtil jdbcUtil = new JDBCUtil();

        String sql = "select * from orders where orderid = ?";

        ResultSet rs = jdbcUtil.execQuery(sql, orderid);

        //创建实体类对象
        Order user = new Order();

        try {
            if(rs.next()){


                //填充实体类对象
                user.setOrderid(rs.getInt(1));
                user.setGoodid(rs.getInt(2));
                user.setUserid(rs.getInt(3));
                user.setStatus(rs.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //在request属性范围中保存用户对象
        request.setAttribute("user", user);

        //跳转到用户修改页面
        request.getRequestDispatcher("ma_order_modify.jsp").forward(request, response);


    }
}
