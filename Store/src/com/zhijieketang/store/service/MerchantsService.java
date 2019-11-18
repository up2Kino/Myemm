package com.zhijieketang.store.service;

import com.zhijieketang.store.domain.Merchants;

public interface MerchantsService {

    /**
     * 处理商家登录
     * @param merchants
     * @return 登录成功返回true,登录失败返回false
     */
    boolean login(Merchants merchants);

    /**
     * 处理商家注册
     * @param merchants
     * @throws ServiceException 注册失败抛出异常
     */
    void register(Merchants merchants) throws ServiceException;

}
