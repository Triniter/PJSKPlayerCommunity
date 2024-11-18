package com.pjsk.service;

import com.pjsk.entity.User;

public interface UserService {
    User login(String username, String password);

    User update(Integer userid);

    boolean checkUsername(String username);

    boolean checkModifyUsername(Integer userid, String username);

    boolean Register(String username, String password, String tel, String address);

    boolean Modify(Integer userid, String username, String password, String tel, String address);

    boolean recharge(int userId, double amount);

    boolean ModifyMessage(Integer userid, String message);
}
