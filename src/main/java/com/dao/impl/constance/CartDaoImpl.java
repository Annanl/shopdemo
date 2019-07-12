package com.dao.impl.constance;

import com.dao.CartDao;
import com.dao.JdbcUtils_DBCP;
import com.entity.Goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDaoImpl implements CartDao {

    private Connection con;

    {
        try {
            con = JdbcUtils_DBCP.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void addGoods(String userId, String goodsId) {

    }

    @Override
    public void deleteGoods(String userId, String goodsId, String number) {

    }

    @Override
    public List<Goods> getCart(String userId) {
        ResultSet rs = null;
        String sql = "select * from cart where cart_userid=?";
        PreparedStatement ps = null;
        List<Goods> list = new ArrayList<Goods>();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Goods(
                        rs.getString("name"),
                        rs.getString("price"),
                        rs.getString("detail")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils_DBCP.release(con, ps, rs);
        }
        return list;
    }
}
