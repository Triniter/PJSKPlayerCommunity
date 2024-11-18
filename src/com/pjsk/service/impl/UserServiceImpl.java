package com.pjsk.service.impl;

import com.pjsk.dao.UserDAO;
import com.pjsk.dao.impl.UserDAOImpl;
import com.pjsk.entity.User;
import com.pjsk.service.UserService;


public class UserServiceImpl implements UserService {

    @Override
    public User login(String username, String password) {
        UserDAO userDAO = new UserDAOImpl();

        User user = userDAO.findUser(username, password);

        if (user!=null) {
            return user;
        }
        return null;
    }

    @Override
    public User update(Integer userid) {
        UserDAO userDAO = new UserDAOImpl();

        User user = userDAO.updateUser(userid);

        if (user!=null) {
            return user;
        }
        return null;
    }

    @Override
    public boolean checkUsername(String username) {
        UserDAO userDAO = new UserDAOImpl();

        return userDAO.checkUser(username);
    }

    @Override
    public boolean checkModifyUsername(Integer userid, String username) {
        UserDAO userDAO = new UserDAOImpl();

        return userDAO.checkModifyUser(userid, username);
    }

    @Override
    public boolean Register(String username, String password, String tel, String address) {
        UserDAO userDAO = new UserDAOImpl();

        return userDAO.register(username, password, tel, address);
    }

    @Override
    public boolean Modify(Integer userid, String username, String password, String tel, String address) {
        UserDAO userDAO = new UserDAOImpl();

        return userDAO.modify(userid, username, password, tel, address);
    }

    @Override
    public boolean recharge(int userid, double amount) {
        UserDAO userDAO = new UserDAOImpl();

        return userDAO.recharge(userid, amount);
    }

    @Override
    public boolean ModifyMessage(Integer userid, String message) {
        UserDAO userDAO = new UserDAOImpl();

        return userDAO.ModifyMessage(userid, message);
    }


}
