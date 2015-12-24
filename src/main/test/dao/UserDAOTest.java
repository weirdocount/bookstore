package dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.weirdo.util.ConnectionContext;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by Administrator on 2015/12/16.
 */
public class UserDAOTest {

//    static {
//        try {
//            ConnectionContext.getInstance().bind(new ComboPooledDataSource("javawebapp").getConnection());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    @Test
    public  void testGet() throws SQLException {
//        System.out.println(new UserDAOImpl().getUser("Tom"));
    }

    @Test
    public  void testC3p0() throws SQLException {
        DataSource dataSource = new ComboPooledDataSource("javawebapp");
        System.out.println(dataSource.getConnection().toString());
    }
}
