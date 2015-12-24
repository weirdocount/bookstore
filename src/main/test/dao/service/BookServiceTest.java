package dao.service;

import com.weirdo.dataobject.BookResult;
import com.weirdo.service.BookService;
import com.weirdo.util.QueryCondition;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by DQ on 2015/12/21.
 */
public class BookServiceTest {

    @Test
    public void testGetBookResultByQueryCondition() throws Exception {
        QueryCondition queryCondition = new QueryCondition(50,60,5,1);
        BookResult result = new BookService().getBookResultByQueryCondition(queryCondition);
        System.out.println(result);
    }
}