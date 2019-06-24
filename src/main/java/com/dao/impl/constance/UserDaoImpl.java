package com.dao.impl.constance;


import com.dao.JdbcUtils_DBCP;
import com.dao.UserDao;
import com.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    private Connection con;

    {
        try {
            con = new JdbcUtils_DBCP().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean addUser(User user){
        String sql = "insert into user (name,phone,password) values (?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPhone());
            ps.setString(3,user.getPassword());
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils_DBCP.release(con,ps,null);
        }
        return false;
    }

    @Override
    public User login(String username, String password){
        ResultSet rs = null;
        String sql = "select * from user where name = ? and password = ?";
        PreparedStatement ps = null;
        User user = new User();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            rs = ps.executeQuery();
            if(rs.next()){
                user.setId(rs.getString("id"));
                user.setUsername(rs.getString("name"));
                user.setPhone(rs.getString("phone"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils_DBCP.release(con,ps,rs);
        }
        return user;
    }

    @Override
    public boolean findUserByName(String username) {
        return getUser(username).getUsername() == null || getUser(username).getUsername().equals("");
    }

    @Override
    public boolean updateUser(User user,String username) {
        String sql = "update user set name=?,phone=?,password=? where name=?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPhone());
            ps.setString(3,user.getPassword());
            ps.setString(4,username);
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils_DBCP.release(con,ps,null);
        }
        return false;
    }

    @Override
    public User getUser(String username) {
        ResultSet rs = null;
        String sql = "select * from user where name = ?";
        PreparedStatement ps = null;
        User user = new User();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,username);
            rs = ps.executeQuery();
            if(rs.next()){
                user.setId(rs.getString("id"));
                user.setUsername(rs.getString("name"));
                user.setPhone(rs.getString("phone"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

}
