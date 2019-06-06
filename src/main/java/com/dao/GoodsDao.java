package com.dao;

import com.entity.Goods;

import java.util.List;

public interface GoodsDao {

    //获得商品列表
    List<Goods> getGoodsList(String scope);

    //添加商品

    //删除商品

    //修改商品
}
