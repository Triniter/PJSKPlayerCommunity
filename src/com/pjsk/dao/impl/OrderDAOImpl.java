package com.pjsk.dao.impl;

import com.pjsk.dao.OrderDAO;
import com.pjsk.entity.OrderVO;
import com.pjsk.util.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {

    private JDBCUtil jdbcUtil = new JDBCUtil();

    @Override
    public boolean createOrder(Integer goodid, Integer userid, Integer quantity, Float total, Integer rest, Float balance) {

        rest = rest - quantity;
        balance = balance - total;

        String sql1 = "insert into orders values(null, ?, ?, ?, '未发货', ?, now())";
        String sql2 = "update good set quantity = ? where goodid = ?";
        String sql3 = "update user set balance = ? where userid = ?";

        boolean insert = jdbcUtil.execUpdate(sql1, goodid, userid, quantity, total);
        boolean update1 = jdbcUtil.execUpdate(sql2, rest, goodid);
        boolean update2 = jdbcUtil.execUpdate(sql3, balance, userid);

        return insert && update1 && update2;
    }

    @Override
    public List<OrderVO> getOrdersForUser(int userid) {

        List<OrderVO> orderVOList = new ArrayList<>();

        String sql = "SELECT orderid, o.quantity, total, order_status,ordertime,goodname, photo " +
                "FROM orders o " +
                "JOIN good g ON o.goodid = g.goodid " +
                "WHERE o.userid = ? ";

        ResultSet rs = jdbcUtil.execQuery(sql, userid);



        try {

            while (rs.next()) {

                OrderVO orderVO = new OrderVO();

                orderVO.setOrderid(rs.getInt(1));
                orderVO.setQuantity(rs.getInt(2));
                orderVO.setTotal(rs.getFloat(3));
                orderVO.setOrder_status(rs.getString(4));
                orderVO.setOrdertime(rs.getDate(5));
                orderVO.setGoodname(rs.getString(6));
                orderVO.setPhoto(rs.getString(7));


                orderVOList.add(orderVO);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderVOList;

    }
}
