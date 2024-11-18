package com.pjsk.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pjsk.dao.impl.UserDAOImpl.DBConnection;
import com.pjsk.entity.User;
public class Userdao  {
    private Connection conn=null;//数据库连接对象
    private PreparedStatement pstmt=null;//数据库操作对象
    private DBConnection db=null;
    public Userdao() throws Exception {
        this.db=new DBConnection();
        this.conn=db.getConnection();
    }
    //添加名称和图片
    public boolean addUser(User user) throws Exception{
        boolean flag=false;
        String sql="update  user set profile=? where username=?";
        this.pstmt=this.conn.prepareStatement(sql);
        this.pstmt.setString(1,user.getProfile());
        this.pstmt.setString(2,user.getUsername());
        if(this.pstmt.executeUpdate()>0){
            flag=true;
        }
        this.pstmt.close();
        return flag;
    }
    public List<User> findAll() throws Exception{
        List<User> list =new ArrayList<User>();
        String sql="select * from user";
        this.pstmt=this.conn.prepareStatement(sql);
        ResultSet rs=this.pstmt.executeQuery();
        while(rs.next()){
            User u=new User();
            u.setUserid(rs.getInt(1));
            u.setUsername(rs.getString(2));
            u.setProfile(rs.getString(4));
            list.add(u);
        }
        this.pstmt.close();
        return list;

    }

}
