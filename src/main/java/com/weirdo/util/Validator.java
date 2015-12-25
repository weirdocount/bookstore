package com.weirdo.util;

import com.weirdo.dao.AccountDAO;
import com.weirdo.dao.UserDAO;
import com.weirdo.dao.impl.AccountDAOImpl;
import com.weirdo.dao.impl.UserDAOImpl;
import com.weirdo.dataobject.Account;
import com.weirdo.dataobject.Cart;
import com.weirdo.dataobject.User;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by daiqiang on 2015/12/25.
 */
public class Validator {


    /**
     * 校验用户是否存在
     * @return
     */
    public static String ValidateUser(String userName,String accountId){
        StringBuffer result = new StringBuffer();
        UserDAO userDAO = new UserDAOImpl();
        User user = userDAO.getUserByUserName(userName);
        if (user == null){
            result.append("用户不存在");
        }else {
            if (Integer.parseInt(accountId) != user.getAccountId()){
                result.append("该卡号不属于这个用户");
            }
        }
        return  result.toString();
    }

    /**
     * 验证输入不能为空
     * @param args
     * @return
     */
    public static String ValidateInput(String ...args){
        StringBuffer result = new StringBuffer();
        if (args != null) {
            for (String str : args){
                if (str == null){
                    result.append("输入不能为空");
                    break;
                }
            }
        } else {
            result.append("输入不能为空");
        }
        return result.toString();
    }

    /**
     * 校验用户余额
     * @param request
     * @param accountIdStr
     * @return
     */
    public static String ValidateMoney(HttpServletRequest request, String accountIdStr){
        StringBuffer result = new StringBuffer();
        Cart cart = CartUtil.getCart(request);
        AccountDAO accountDAO = new AccountDAOImpl();
        int accountId = -1;
        try {
            accountId = Integer.parseInt(accountIdStr);
        } catch (NumberFormatException e) {
        }
        Account account = accountDAO.getAccount(accountId);
        if (account == null){
            result.append("账户不存在");
        }else{
            if (cart.getTotalMoney() > account.getBalance()){
                result.append("用户余额不足");
            }
        }
        return result.toString();
    }

}
