package dao;

import com.weirdo.dao.BookDAO;
import com.weirdo.dao.impl.BookDAOImpl;
import com.weirdo.dataobject.Book;
import com.weirdo.util.QueryCondition;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by DQ on 2015/12/21.
 */
public class BookDAOTest {

    BookDAO bookDAO = null;

    @Before
    public void setBookDao(){
        bookDAO = new BookDAOImpl();
    }
    @Test
    public void testGetBookListByQueryCondition() throws Exception {
        QueryCondition queryCondition = new QueryCondition(50,60,5,1);
        List<Book> result = bookDAO.getBookListByQueryCondition(queryCondition);
        System.out.println(result);
    }

    @Test
    public void testGetCountByQueryCondition() throws Exception {
        QueryCondition queryCondition = new QueryCondition(50,60,5,1);
        int result = bookDAO.getCountByQueryCondition(queryCondition);
        System.out.println(result);
    }

    @Test
    public void testGetBookById() throws Exception {
        Book result = bookDAO.getBookById(1);
        System.out.println(result);
    }
}