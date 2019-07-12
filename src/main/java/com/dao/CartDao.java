package com.dao;

import com.entity.Goods;

import java.util.List;

public interface CartDao {

    void addGoods(String userId,String goodsId);

    void deleteGoods(String userId,String goodsId,String number);

    List<Goods> getCart(String userId);

}
