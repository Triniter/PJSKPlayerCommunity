package com.pjsk.service;

import com.pjsk.entity.Good;

import java.util.List;

public interface GoodService {

    List<Good> getAllGoods();

    List<Good> myGoods(int userid);

    List<Good> searchGoods(String keyword, float minPrice, float maxPrice);

    Good getGoodById(int goodid);

    boolean addGood(String goodName, float price, int quantity, String photo, int userId);

}
