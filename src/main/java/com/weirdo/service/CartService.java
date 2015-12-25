package com.weirdo.service;

import com.weirdo.dao.*;
import com.weirdo.dao.impl.*;
import com.weirdo.dataobject.*;

import java.sql.Date;
import java.util.Collection;

/**
 * Created by DQ on 2015/12/22.
 */
public class CartService {

    private BookDAO bookDAO = new BookDAOImpl();
    private AccountDAO accountDAO = new AccountDAOImpl();
    private TradeDAO tradeDAO = new TradeDAOImpl();
    private UserDAO userDAO = new UserDAOImpl();
    private TradeItemDAO tradeItemDAO = new TradeItemDAOImpl();
    /**
     * 购买一本书籍
     * @param cart
     * @param id
     * @return
     */
    public boolean buyBook(Cart cart,Integer id){
        boolean result = false;
        Book book = bookDAO.getBookById(id);
        if (book != null){
            CartItem item = null;
            if (cart.getMap().containsKey(id)){
                item = cart.getMap().get(id);
                item.setNum(item.getNum()+1);
            }else{
                item = new CartItem(book,1);
                cart.getMap().put(id,item);
            }
            //计算总的数量和金额
            cart.setTotalNum(cart.getTotalNum()+1);
            cart.setTotalMoney(cart.getTotalMoney()+book.getPrice());
            result = true;
        }
        return result;
    }

    /**
     * 删除指定购物车中的书籍
     * @param cart
     * @param id
     */
    public void removeItem(Cart cart, Integer id){
        CartItem item = cart.getMap().get(id);
        if (item != null){
            cart.getMap().remove(id);
            cart.setTotalNum(cart.getTotalNum()-item.getNum());
            cart.setTotalMoney(cart.getTotalMoney() - item.getMoney());
        }
    }

    /**
     * 清空购物车中的某个书籍
     * @param cart
     */
    public void clearItem(Cart cart){
        cart.getMap().clear();
        cart.setTotalMoney(0.0);
        cart.setTotalNum(0);
    }

    /**
     * 跟新购物车的数量
     * @param cart
     * @param id
     * @param num
     * @return
     */
    public boolean updateItem(Cart cart,Integer id,int num){
        boolean result = false;
        Book book = bookDAO.getBookById(id);
        if (book != null && cart.getMap().containsKey(id)){
            CartItem item = cart.getMap().get(id);
            //计算总的数量和金额
            cart.setTotalNum(cart.getTotalNum()+num - item.getNum());
            cart.setTotalMoney(cart.getTotalMoney()+book.getPrice()*num - item.getMoney());
            item.setNum(num);
            item.setMoney(num*book.getPrice());
            result = true;
        }
        return result;
    }

    /**
     * 购买商品
     * @param cart
     * @param userName
     * @param accountId
     */
    public void cash(Cart cart, String userName, String accountId){
        //1.更新账户余额
        accountDAO.updateBalance(Integer.parseInt(accountId),cart.getTotalMoney());

        //2.向Trade中插入一条数据
        Trade trade = new Trade();
        User user = userDAO.getUserByUserName(userName);
        trade.setUserId(user.getId());
        trade.setDate(new Date(new java.util.Date().getTime()));
        tradeDAO.inset(trade);

        //3.批量插入明细
        Collection<CartItem> items = cart.getItems();
        for (CartItem item : items){
            TradeItem tradeItem = new TradeItem();
            tradeItem.setBookId(item.getId());
            tradeItem.setNum(item.getNum());
            tradeItem.setItemId(trade.getTradeId());
            tradeItemDAO.insert(tradeItem);
        }

        //4.清空购物车
        clearItem(cart);
    }

}
