package dao;

import com.weirdo.dao.UserDAO;
import com.weirdo.dao.impl.UserDAOImpl;
import com.weirdo.dataobject.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by daiqiang on 2015/12/25.
 */
public class UserDAOImplTest {

    UserDAO userDAO = new UserDAOImpl();
    @Test
    public void testGetUser() throws Exception {
        User user = userDAO.getUser(1);
        System.out.println("---"+user);
    }
}