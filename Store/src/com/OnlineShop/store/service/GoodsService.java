package com.OnlineShop.store.service;

import com.OnlineShop.store.domain.Goods;

import java.util.List;

public interface GoodsService {

    List<Goods> queryAll();

    List<Goods> queryByStartEnd(int start, int end);

    Goods querDetail(long goodsid);

    void create(Goods goods);

    void update(Goods goods);
}
