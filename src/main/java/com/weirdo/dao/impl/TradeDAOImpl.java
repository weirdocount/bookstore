package com.weirdo.dao.impl;

import com.weirdo.dao.TradeDAO;
import com.weirdo.dataobject.Trade;

import java.util.List;

/**
 * Created by daiqiang on 2015/12/25.
 */
public class TradeDAOImpl extends BaseDAO<Trade> implements TradeDAO {
    /**
     * 插入数据
     *
     * @param trade
     */
    public void inset(Trade trade) {
        String sql = "INSERT INTO trade (userid, tradetime) VALUES " +
                "(?, ?)";
        trade.setTradeId((int)insert(sql,trade.getUserId(),trade.getDate()));
    }

    /**
     * 根据用户ID获取交易记录
     *
     * @param userId
     * @return
     */
    public List<Trade> getTradesByUserId(Integer userId) {
        String sql = "select tradeid,userid,tradetime date from trade where userid = ?";
        return queryForList(sql,userId);
    }
}
