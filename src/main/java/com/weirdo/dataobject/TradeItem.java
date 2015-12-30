package com.weirdo.dataobject;

import com.weirdo.dao.BookDAO;
import com.weirdo.dao.impl.BookDAOImpl;

/**
 * Created by daiqiang on 2015/12/25.
 */
public class TradeItem {

    private Integer itemId;
    private Integer bookId;
    private int num;
    private Integer tradeId;
    private Book book;

    public TradeItem() {
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Integer getTradeId() {
        return tradeId;
    }

    public void setTradeId(Integer tradeId) {
        this.tradeId = tradeId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "TradeItem{" +
                "itemId=" + itemId +
                ", bookId=" + bookId +
                ", num=" + num +
                ", tradeId=" + tradeId +
                ", book=" + book +
                '}';
    }
}
