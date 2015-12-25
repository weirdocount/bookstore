package com.weirdo.dao;

import com.weirdo.dataobject.User;

/**
 * Created by daiqiang on 2015/12/25.
 */
public interface UserDAO {

    /**
     * 根据用户ID获取用户信息
     * @param userId
     * @return
     */
    User getUser(Integer userId);

    /**
     * 通过用户名获取用户
     * @param userName
     * @return
     */
    User getUserByUserName(String userName);
}
