package com.weirdo.dao;

import com.weirdo.dataobject.Book;
import com.weirdo.util.QueryCondition;

import java.util.List;

/**
 * Created by Administrator on 2015/12/17.
 */
public interface BookDAO {

    /**
     * 通过查询条件获取书
     * @param queryCondition
     * @return
     */
    List<Book> getBookListByQueryCondition(QueryCondition queryCondition);

    /**
     * 根据查询条件获取查询总数
     * @param queryCondition
     * @return
     */
    int getCountByQueryCondition(QueryCondition queryCondition);

    Book getBookById(Integer id);

}
