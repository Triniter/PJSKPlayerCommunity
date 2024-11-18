package com.pjsk.service;

import com.pjsk.entity.OrderVO;

import javax.servlet.http.HttpServlet;
import java.util.List;

public interface OrderService {

    boolean create(Integer goodid, Integer userid, Integer quantity, Float total, Integer rest, Float balance);

    List<OrderVO> getOrdersForUser(int userid);
}
