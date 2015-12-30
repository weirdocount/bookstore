package com.weirdo.dataobject;

import java.sql.Date;
import java.util.List;

/**
 * Created by daiqiang on 2015/12/25.
 */
public class Trade {
    private Integer tradeId;
    private Integer userId;
    private Date date;
    private List<TradeItem> tradeItems;

    public Trade() {
    }

    public List<TradeItem> getTradeItems() {
        return tradeItems;
    }

    public void setTradeItems(List<TradeItem> tradeItems) {
        this.tradeItems = tradeItems;
    }

    public Integer getTradeId() {
        return tradeId;
    }

    public void setTradeId(Integer tradeId) {
        this.tradeId = tradeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "tradeId=" + tradeId +
                ", userId=" + userId +
                ", date=" + date +
                ", tradeItems=" + tradeItems +
                '}';
    }
}
