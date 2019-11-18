package com.zhijieketang.store.service.imp;

import com.zhijieketang.store.dao.MerchantsDao;
import com.zhijieketang.store.dao.imp.MerchantsDaoImpJdbc;
import com.zhijieketang.store.domain.Merchants;
import com.zhijieketang.store.service.MerchantsService;
import com.zhijieketang.store.service.ServiceException;

public class MerchantsServiceImp implements MerchantsService {

    MerchantsDao merchantsDao = new MerchantsDaoImpJdbc();

    @Override
    public boolean login(Merchants merchants) {

        Merchants dbMerchants = merchantsDao.findByPk(merchants.getId());
        if (dbMerchants != null &&
                dbMerchants.getPassword().equals(merchants.getPassword())) {
            // 把db返回的商家信息返回给表示层
            merchants.setName(dbMerchants.getName());
            merchants.setBirthday(dbMerchants.getBirthday());
            merchants.setAddress(dbMerchants.getAddress());
            merchants.setPhone(dbMerchants.getPhone());

            return true;
        }
        return false;
    }

    @Override
    public void register(Merchants merchants) throws ServiceException {

        Merchants dbMerchants = merchantsDao.findByPk(merchants.getId());

        if (dbMerchants != null) { //商家ID已经存在了
            throw new ServiceException("商家ID: " + merchants.getId() + "已经存在！");
        }

        // 注册开始
        merchantsDao.create(merchants);
    }
}
