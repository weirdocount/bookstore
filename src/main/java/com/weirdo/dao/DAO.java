package com.weirdo.dao;

import java.util.List;

/**
 * Created by Administrator on 2015/12/15.
 */
public interface DAO<T> {

    /**
     * 插入数据
     * @param sql
     * @param args
     * @return
     */
    long insert(String sql, Object... args);

    /**
     * 更新数据
     * @param sql
     * @param args
     */
    void update(String sql, Object... args);

    /**
     * 获取单个数据
     * @param sql
     * @param args
     * @return
     */
    T query(String sql, Object... args);


    /**
     * 获取列表
     * @param sql
     * @param args
     * @return
     */
    List<T> queryForList(String sql, Object... args);

    /**
     * 获取某个查询的值
     * @param sql
     * @param args
     * @param <V>
     * @return
     */
    <V> V getSingleVal(String sql, Object... args);

    /**
     * 批量操作
     * @param sql
     * @param params
     */
    void batch(String sql, Object[]... params);
}