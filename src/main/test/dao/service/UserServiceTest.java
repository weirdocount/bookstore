package dao.service;

import com.weirdo.dataobject.Trade;
import com.weirdo.service.UserService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by daiqiang on 2015/12/29.
 */
public class UserServiceTest {

    @Test
    public void testGetUserOrders() throws Exception {
        UserService userService = new UserService();
        List<Trade> result = userService.getUserOrders("Tom");
        System.out.println(result.get(0).getTradeItems().get(0).getBook().getTitle());
    }
}