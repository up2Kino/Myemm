package com.OnlineShop.store.web;

import com.OnlineShop.store.dao.GoodsDao;
import com.OnlineShop.store.dao.OrderDao;
import com.OnlineShop.store.dao.OrderLineItemDao;
import com.OnlineShop.store.dao.imp.GoodsDaoImpJdbc;
import com.OnlineShop.store.dao.imp.OrderDaoImpJdbc;
import com.OnlineShop.store.dao.imp.OrderLineItemDaoImpJdbc;
import com.OnlineShop.store.domain.Goods;
import com.OnlineShop.store.domain.OrderLineItem;
import com.OnlineShop.store.domain.Orders;
import com.OnlineShop.store.service.OrdersService;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrdersServiceImp implements OrdersService {

    GoodsDao goodsDao = new GoodsDaoImpJdbc();
    OrderDao orderDao = new OrderDaoImpJdbc();
    OrderLineItemDao orderLineItemDao = new OrderLineItemDaoImpJdbc();

    @Override
    public String submitOrders(List<Map<String, Object>> cart) {

        Orders orders = new Orders();
        Date date = new Date();
        // 订单Id
        String ordersid = String.valueOf(date.getTime())
                + String.valueOf((int) (Math.random() * 100));
        orders.setId(ordersid);
        orders.setOrderDate(date);
        orders.setStatus(1);
        orders.setTotal(0.0f);
        // 将订单信息插入到数据库中
        orderDao.create(orders);
        // 商品总金额
        double total = 0.0;

        for (Map item : cart) {
            // item结构 [商品id， 数量]
            Long goodsid = (Long) item.get("goodsid");
            Integer quantity = (Integer) item.get("quantity");
            Goods goods = goodsDao.findByPk(goodsid);
            // 小计金额
            double subtotal = quantity * goods.getPrice();
            total += subtotal;

            OrderLineItem lineItem = new OrderLineItem();
            lineItem.setQuantity(quantity);
            lineItem.setGoods(goods);
            lineItem.setOrders(orders);
            lineItem.setSubTotal(subtotal);

            // 将订单详细插入到数据库
            orderLineItemDao.create(lineItem);
        }

        orders.setTotal(total);
        // 更新订单数据库
        orderDao.modify(orders);

        return ordersid;
    }
}
