package com.weirdo.dao;

import com.weirdo.dataobject.Account;

/**
 * Created by daiqiang on 2015/12/25.
 */
public interface AccountDAO {
    /**
     * 获取账户信息
     * @param accountId
     * @return
     */
    Account getAccount(Integer accountId);

    /**
     * 支付金额
     * @param accountId
     * @param amount
     */
    void updateBalance(Integer accountId, double amount);
}
