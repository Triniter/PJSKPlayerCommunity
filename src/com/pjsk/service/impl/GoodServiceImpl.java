package com.pjsk.service.impl;

import com.pjsk.dao.GoodDAO;
import com.pjsk.dao.impl.GoodDAOImpl;
import com.pjsk.entity.Good;
import com.pjsk.service.GoodService;

import java.io.PrintWriter;
import java.util.List;

public class GoodServiceImpl implements GoodService {

    private GoodDAO goodDAO = new GoodDAOImpl();

    @Override
    public List<Good> getAllGoods() {
        return goodDAO.getAllGoods();
    }

    @Override
    public List<Good> myGoods(int userid) {

        return goodDAO.myGoods(userid);
    }

    @Override
    public List<Good> searchGoods(String keyword, float minPrice, float maxPrice) {

        return goodDAO.searchGoods(keyword, minPrice, maxPrice);

    }

    @Override
    public Good getGoodById(int goodid) {
        return goodDAO.getGoodById(goodid);
    }

    @Override
    public boolean addGood(String goodName, float price, int quantity, String photo, int userId) {
        return goodDAO.addGood(goodName, price, quantity, photo, userId);
    }
}
