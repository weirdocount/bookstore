package com.weirdo.dataobject;

import java.sql.Date;

/**
 * Created by daiqiang on 2015/12/25.
 */
public class Trade {
    private Integer tradeId;
    private Integer userId;
    private Date date;

    public Trade() {
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
                '}';
    }
}
