package com.dao.impl.constance;


import com.entity.User;
import com.dao.UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    private static Connection con = new SqlDaoImpl().getConnection();

    @Override
    public boolean addUser(User user) throws Exception {
        ResultSet rs = null;
        String sql = "insert into user (user_name,user_phone,user_password) values (?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPhone());
            ps.setString(3,user.getPassword());
            int i = ps.executeUpdate();
            return i>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User login(String username, String password) throws Exception {
        ResultSet rs = null;
        String sql = "select * from user where user_name = ? and user_password = ?";
        PreparedStatement ps = null;
        User user = new User();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            rs = ps.executeQuery();
            if(rs.next()){
                user.setId(rs.getString("user_id"));
                user.setUsername(rs.getString("user_name"));
                user.setPhone(rs.getString("user_phone"));
                user.setPassword(rs.getString("user_password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean findUserByName(String username) {
        return getUser(username).getUsername() == null || getUser(username).getUsername().equals("");
    }

    @Override
    public boolean updateUser(User user,String username) {
        ResultSet rs = null;
        String sql = "update user set user_name=?,user_phone=?,user_password=? where user_name=?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPhone());
            ps.setString(3,user.getPassword());
            ps.setString(4,username);
            int i = ps.executeUpdate();
            return i>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User getUser(String username) {
        ResultSet rs = null;
        String sql = "select * from user where user_name = ?";
        PreparedStatement ps = null;
        User user = new User();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,username);
            rs = ps.executeQuery();
            if(rs.next()){
                user.setId(rs.getString("user_id"));
                user.setUsername(rs.getString("user_name"));
                user.setPhone(rs.getString("user_phone"));
                user.setPassword(rs.getString("user_password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
