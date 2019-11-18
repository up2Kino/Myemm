package com.zhijieketang.store.service;

import com.zhijieketang.store.domain.Goods;

import java.util.List;

public interface GoodsService {

    List<Goods> queryAll();

    List<Goods> queryByStartEnd(int start, int end);

    Goods querDetail(long goodsid);

}
