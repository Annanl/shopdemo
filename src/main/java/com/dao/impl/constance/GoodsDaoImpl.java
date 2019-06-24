package com.dao.impl.constance;

import com.dao.JdbcUtils_DBCP;
import com.entity.Goods;
import com.entity.User;
import com.dao.GoodsDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDaoImpl implements GoodsDao {

    private Connection con;

    {
        try {
            con = JdbcUtils_DBCP.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Goods> getGoodsList(String scope) {
        if (scope.equals("")){
            ResultSet rs = null;
            String sql = "select * from goods";
            PreparedStatement ps = null;
            User user = new User();
            List<Goods> list = new ArrayList<Goods>();
            try {
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()){
                    list.add(new Goods(
                            rs.getString("name"),
                            rs.getString("price"),
                            rs.getString("detail")
                    ));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                JdbcUtils_DBCP.release(con,ps,rs);
            }
            return list;
        }else {
            ResultSet rs = null;
            String sql = "select * from goods where name like ?";
            PreparedStatement ps = null;
            User user = new User();
            ArrayList<Goods> list = new ArrayList<Goods>();
            try {
                ps = con.prepareStatement(sql);
                ps.setString(1,"%"+scope+"%");
                rs = ps.executeQuery();
                while (rs.next()){
                    list.add(new Goods(
                            rs.getString("name"),
                            rs.getString("price"),
                            rs.getString("detail")
                    ));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                JdbcUtils_DBCP.release(con,ps,rs);
            }
            return list;
        }
    }
}
