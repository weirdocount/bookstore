package com.weirdo.dao.impl;

import com.weirdo.dao.BookDAO;
import com.weirdo.dataobject.Book;
import com.weirdo.util.QueryCondition;

import java.util.List;

/**
 * Created by daiqiang on 2015/12/17.
 */
public class BookDAOImpl extends BaseDAO<Book> implements BookDAO{

    public List<Book> getBookListByQueryCondition(QueryCondition queryCondition) {
        String sql = "SELECT id,author,Title,Price,Publishingdate,Remark from mybooks " +
                "where Price BETWEEN ? and ?"+
                "LIMIT ?,?";
        return queryForList(sql,queryCondition.getMinPrice(),queryCondition.getMaxPrice()
                ,(queryCondition.getPageNo()-1)*queryCondition.getPageSize(),queryCondition.getPageSize());
    }

    public int getCountByQueryCondition(QueryCondition queryCondition) {
        String sql = "SELECT count(id) from mybooks " +
                "where Price BETWEEN ? and ? ";
        Long result = getSingleVal(sql,queryCondition.getMinPrice(),queryCondition.getMaxPrice());
        return result.intValue();
    }

    public Book getBookById(Integer id) {
        String sql = "SELECT id,author,Title,Price,Publishingdate,Remark from mybooks " +
                "where id = ?";
        return query(sql,id);
    }
}
