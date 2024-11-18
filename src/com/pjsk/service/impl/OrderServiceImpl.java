package com.pjsk.service.impl;

import com.pjsk.dao.OrderDAO;
import com.pjsk.dao.impl.OrderDAOImpl;
import com.pjsk.entity.OrderVO;
import com.pjsk.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    @Override
    public boolean create(Integer goodid, Integer userid, Integer quantity, Float total, Integer rest, Float balance) {
        OrderDAO orderDAO = new OrderDAOImpl();

        return orderDAO.createOrder(goodid, userid, quantity, total, rest, balance);
    }

    private OrderDAO orderDAO = new OrderDAOImpl();

    @Override
    public List<OrderVO> getOrdersForUser(int userid) {

        return orderDAO.getOrdersForUser(userid);

    }
}
