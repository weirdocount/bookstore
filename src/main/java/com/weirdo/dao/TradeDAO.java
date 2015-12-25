package com.weirdo.dao;

import com.weirdo.dataobject.Trade;

import java.util.List;

/**
 * Created by daiqiang on 2015/12/25.
 */
public interface TradeDAO {
    /**
     * 插入数据
     * @param trade
     */
    void inset(Trade trade);

    /**
     * 根据用户ID获取交易记录
     * @param userId
     * @return
     */
    List<Trade> getTradesByUserId(Integer userId);
}
