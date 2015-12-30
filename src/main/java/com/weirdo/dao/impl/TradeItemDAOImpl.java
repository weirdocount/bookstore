package com.weirdo.dao.impl;

import com.weirdo.dao.TradeItemDAO;
import com.weirdo.dataobject.TradeItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daiqiang on 2015/12/25.
 */
public class TradeItemDAOImpl extends BaseDAO<TradeItem> implements TradeItemDAO {
    /**
     * 插叙
     *
     * @param tradeItem
     */
    public void insert(TradeItem tradeItem) {
        String sql = "INSERT INTO tradeitem(bookid, quantity, tradeid) " +
                "VALUES(?,?,?)";
        tradeItem.setItemId((int)insert(sql,tradeItem.getBookId(),tradeItem.getNum(),tradeItem.getTradeId()));
    }

    /**
     * 根据tradeId获取购物车的详情
     *
     * @param tradeId
     * @return
     */
    public List<TradeItem> getTradeItemsByTradeId(Integer tradeId) {
        String sql = "SELECT itemid itemId, bookId, " +
                "quantity num, tradeId FROM tradeitem WHERE tradeid = ?";
        return new ArrayList<TradeItem>(queryForList(sql,tradeId));
    }
}
