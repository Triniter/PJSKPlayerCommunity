package com.pjsk.dao.impl;

import com.pjsk.dao.GoodDAO;
import com.pjsk.entity.Good;
import com.pjsk.util.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodDAOImpl implements GoodDAO {

    private JDBCUtil jdbcUtil = new JDBCUtil();

    // 获取所有商品
    @Override
    public List<Good> getAllGoods() {

        List<Good> goodList = new ArrayList<>();

        String sql = "select goodid,goodname,price,photo from good";

        ResultSet rs = jdbcUtil.execQuery(sql);

        try {


            while (rs.next()) {

                Good good = new Good();

                good.setGoodid(rs.getInt(1));
                good.setGoodname(rs.getString(2));
                good.setPrice(rs.getFloat(3));
                good.setPhoto(rs.getString(4));

                goodList.add(good);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return goodList;
    }

    @Override
    public List<Good> myGoods(int userid) {

        List<Good> goodList = new ArrayList<>();

        String sql ="select goodid,goodname,price,quantity,photo from good where userid = ?";

        ResultSet rs = jdbcUtil.execQuery(sql, userid);

        try {
            while (rs.next()) {
                Good good = new Good();

                good.setGoodid(rs.getInt(1));
                good.setGoodname(rs.getString(2));
                good.setPrice(rs.getFloat(3));
                good.setQuantity(rs.getInt(4));
                good.setPhoto(rs.getString(5));

                goodList.add(good);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return goodList;

    }

    @Override
    public List<Good> searchGoods(String keyword, float minPrice, float maxPrice) {
        List<Good> goodList = new ArrayList<>();

        String sql = "SELECT goodid, goodname, price, photo FROM good WHERE goodname LIKE ? AND price >= ? AND price <= ?";

        ResultSet rs = jdbcUtil.execQuery(sql,"%" + keyword + "%",minPrice,maxPrice);

        try {
            while (rs.next()) {
                Good good = new Good();
                good.setGoodid(rs.getInt("goodid"));
                good.setGoodname(rs.getString("goodname"));
                good.setPrice(rs.getFloat("price"));
                good.setPhoto(rs.getString("photo"));
                goodList.add(good);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return goodList;
    }

    @Override
    public Good getGoodById(int goodid) {

        String sql ="select * from good where goodid = ?";

        final ResultSet rs = jdbcUtil.execQuery(sql, goodid);

        Good good = new Good();

        try {

            if (rs.next()) {
                good = new Good();
                good.setGoodid(rs.getInt("goodid"));
                good.setGoodname(rs.getString("goodname"));
                good.setPrice(rs.getFloat("price"));
                good.setQuantity(rs.getInt("quantity"));
                good.setPhoto(rs.getString("photo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return good;

    }

    @Override
    public boolean addGood(String goodName, float price, int quantity, String photo, int userId) {


        String sql = "INSERT INTO good (goodname, price, quantity, photo, userid) VALUES (?, ?, ?, ?, ?)";

        final boolean flag = jdbcUtil.execUpdate(sql, goodName, price, quantity, photo, userId);

        if(flag){
            return true;
        }else {
            return false;
        }

    }
}
