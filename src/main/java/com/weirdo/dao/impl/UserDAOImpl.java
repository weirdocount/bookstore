package com.weirdo.dao.impl;

import com.weirdo.dao.UserDAO;
import com.weirdo.dataobject.User;

/**
 * Created by daiqiang on 2015/12/25.
 */
public class UserDAOImpl extends BaseDAO<User> implements UserDAO{

    /**
     * 根据用户ID获取用户信息
     *
     * @param userId
     * @return
     */
    public User getUser(Integer userId) {
        String sql = "select userid id,username,accountid from userinfo where userid = ?";
        return query(sql,userId);
    }

    /**
     * 通过用户名获取用户
     *
     * @param userName
     * @return
     */
    public User getUserByUserName(String userName) {
        String sql = "select userid id,username,accountid from userinfo where username = ?";
        return query(sql,userName);
    }
}
