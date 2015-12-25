package com.weirdo.dao.impl;

import com.weirdo.dao.AccountDAO;
import com.weirdo.dataobject.Account;

/**
 * Created by daiqiang on 2015/12/25.
 */
public class AccountDAOImpl extends BaseDAO<Account> implements AccountDAO{
    /**
     * 获取账户信息
     *
     * @param accountId
     * @return
     */
    public Account getAccount(Integer accountId) {
        String sql = "SELECT accountid,balance from account WHERE accountid = ?";
        return query(sql,accountId);
    }

    /**
     * 支付金额
     *
     * @param accountId
     * @param amount
     */
    public void updateBalance(Integer accountId, double amount) {
        String sql = "UPDATE account SET balance = balance - ? where accountid = ?";
        update(sql,amount,accountId);
    }
}
