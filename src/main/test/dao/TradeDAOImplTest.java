package dao;

import com.weirdo.dao.TradeDAO;
import com.weirdo.dao.impl.TradeDAOImpl;
import com.weirdo.dataobject.Trade;
import com.weirdo.dataobject.TradeItem;
import org.junit.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by daiqiang on 2015/12/25.
 */
public class TradeDAOImplTest {

    TradeDAO tradeDAO = new TradeDAOImpl();
    @Test
    public void testInset() throws Exception {
        Trade trade = new Trade();
        trade.setUserId(2);
        trade.setTradeId(2);
        trade.setDate(new Date(new java.util.Date().getTime()));
        tradeDAO.inset(trade);
    }

    @Test
    public void testGetTradesByUserId() throws Exception {
        List<Trade> items = tradeDAO.getTradesByUserId(1);
        System.out.println("----"+items);
    }
}