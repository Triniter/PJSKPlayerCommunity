package com.pjsk.dao;

import com.pjsk.entity.User;

import java.lang.ref.SoftReference;

public interface UserDAO {
    User findUser(String username, String password);
    User updateUser(Integer userid);
    boolean checkUser(String username);
    boolean checkModifyUser(Integer  userid, String username);
    boolean register(String username, String password, String tel, String address);
    boolean modify(Integer userid, String username, String password, String tel, String address);
    boolean recharge(Integer userid, Double amount);
    boolean ModifyMessage(Integer userid, String message);

}
