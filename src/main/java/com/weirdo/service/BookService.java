package com.weirdo.service;

import com.weirdo.dao.BookDAO;
import com.weirdo.dao.impl.BookDAOImpl;
import com.weirdo.dataobject.Book;
import com.weirdo.dataobject.BookResult;
import com.weirdo.dataobject.Cart;
import com.weirdo.util.QueryCondition;

/**
 * Created by DQ on 2015/12/21.
 */
public class BookService {

    private BookDAO bookDAO = new BookDAOImpl();

    /**
     * 通过查询条件获取书籍
     * @param queryCondition
     * @return
     */
    public BookResult getBookResultByQueryCondition(QueryCondition queryCondition){
        BookResult result = new BookResult();
        result.setBooks(bookDAO.getBookListByQueryCondition(queryCondition));
        result.setTotal(bookDAO.getCountByQueryCondition(queryCondition));
        result.setPageNo(queryCondition.getPageNo());
        result.setSize(queryCondition.getPageSize());
        return result;
    }

    /**
     * 通过ID获取对应的B信息
     * @param id
     * @return
     */
    public Book getBookById(Integer id){
        Book result = bookDAO.getBookById(id);
        return result;
    }


}
