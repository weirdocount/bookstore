package com.weirdo.service;

import com.weirdo.dao.BookDAO;
import com.weirdo.dao.impl.BookDAOImpl;
import com.weirdo.dataobject.Book;
import com.weirdo.dataobject.Cart;
import com.weirdo.dataobject.CartItem;

/**
 * Created by DQ on 2015/12/22.
 */
public class CartService {

    BookDAO bookDAO = new BookDAOImpl();

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

    public void clearItem(Cart cart){
        cart.getMap().clear();
        cart.setTotalMoney(0.0);
        cart.setTotalNum(0);
    }

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
}
