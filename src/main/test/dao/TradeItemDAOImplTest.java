package dao;

import com.weirdo.dao.TradeItemDAO;
import com.weirdo.dao.impl.TradeItemDAOImpl;
import com.weirdo.dataobject.TradeItem;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by daiqiang on 2015/12/25.
 */
public class TradeItemDAOImplTest {

    TradeItemDAO tradeItemDAO = new TradeItemDAOImpl();

    @Test
    public void testInsert() throws Exception {
        TradeItem tradeItem = new TradeItem();
        tradeItem.setNum(1);
        tradeItem.setItemId(2);
        tradeItem.setBookId(2);
        tradeItemDAO.insert(tradeItem);
    }

    @Test
    public void testGetTradeItemsByTradeId() throws Exception {
        List<TradeItem> tradeItem = tradeItemDAO.getTradeItemsByTradeId(12);
        System.out.println("---"+tradeItem);
    }
}