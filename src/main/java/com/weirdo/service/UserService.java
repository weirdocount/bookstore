package com.weirdo.service;

import com.weirdo.dao.BookDAO;
import com.weirdo.dao.TradeDAO;
import com.weirdo.dao.TradeItemDAO;
import com.weirdo.dao.UserDAO;
import com.weirdo.dao.impl.BookDAOImpl;
import com.weirdo.dao.impl.TradeDAOImpl;
import com.weirdo.dao.impl.TradeItemDAOImpl;
import com.weirdo.dao.impl.UserDAOImpl;
import com.weirdo.dataobject.Trade;
import com.weirdo.dataobject.TradeItem;
import com.weirdo.dataobject.User;

import java.util.List;

/**
 * Created by daiqiang on 2015/12/29.
 */
public class UserService {

    private UserDAO userDAO = new UserDAOImpl();
    private TradeDAO tradeDAO = new TradeDAOImpl();
    private TradeItemDAO tradeItemDAO = new TradeItemDAOImpl();
    private BookDAO bookDAO = new BookDAOImpl();
    public List<Trade> getUserOrders(String username){
        User user = userDAO.getUserByUserName(username);
        if (user == null){
            return null;
        }

        int userid = user.getId();
        List<Trade> trades = tradeDAO.getTradesByUserId(userid);
        if (trades != null){
            for (Trade t:trades){
                List<TradeItem> tradeItems = tradeItemDAO.getTradeItemsByTradeId(t.getTradeId());
                if (tradeItems != null){
                    for (TradeItem tradeItem : tradeItems){
                        tradeItem.setBook(bookDAO.getBookById(tradeItem.getBookId()));
                    }
                }
                t.setTradeItems(tradeItems);
            }
        }
        return trades;
    }

}
