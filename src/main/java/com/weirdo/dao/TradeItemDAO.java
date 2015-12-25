package com.weirdo.dao;

import com.weirdo.dataobject.Trade;
import com.weirdo.dataobject.TradeItem;

import java.util.List;

/**
 * Created by daiqiang on 2015/12/25.
 */
public interface TradeItemDAO {
    /**
     * 插叙
     * @param tradeItem
     */
    void insert(TradeItem tradeItem);

    /**
     * 根据tradeId获取购物车的详情
     * @param tradeId
     * @return
     */
    List<TradeItem> getTradeItemsByTradeId(Integer tradeId);
}
