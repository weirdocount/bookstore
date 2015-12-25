package dao;

import com.weirdo.dao.AccountDAO;
import com.weirdo.dao.impl.AccountDAOImpl;
import com.weirdo.dataobject.Account;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by daiqiang on 2015/12/25.
 */
public class AccountDAOImplTest {

    AccountDAO accountDAO = new AccountDAOImpl();

    @Test
    public void testGetAccount() throws Exception {
        Account account = accountDAO.getAccount(1);
        System.out.println("----"+account);
    }

    @Test
    public void testUpdateBalance() throws Exception {
        accountDAO.updateBalance(1,100);
    }
}