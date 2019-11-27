package com.OnlineShop.store.service.imp;

import com.OnlineShop.store.dao.GoodsDao;
import com.OnlineShop.store.dao.imp.GoodsDaoImpJdbc;
import com.OnlineShop.store.domain.Goods;
import com.OnlineShop.store.service.GoodsService;

import java.util.List;

public class GoodsServiceImp implements GoodsService {

    GoodsDao goodsDao = new GoodsDaoImpJdbc();

    @Override
    public List<Goods> queryAll() {
        return goodsDao.findAll();
    }

    @Override
    public List<Goods> queryByStartEnd(int start, int end) {
        return goodsDao.findStartEnd(start, end);
    }

    @Override
    public Goods querDetail(long goodsid) {
        return goodsDao.findByPk(goodsid);
    }

    public void create(Goods goods){

        goodsDao.create(goods);

    }
}
