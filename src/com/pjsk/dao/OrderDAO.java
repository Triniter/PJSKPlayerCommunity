package com.pjsk.dao;

import com.pjsk.entity.OrderVO;

import java.util.List;

public interface OrderDAO {
    boolean createOrder(Integer goodid, Integer userid, Integer quantity, Float total, Integer rest, Float balance);

    List<OrderVO> getOrdersForUser(int userId);
}
