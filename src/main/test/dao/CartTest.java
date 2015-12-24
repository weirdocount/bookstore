package dao;

import com.weirdo.dataobject.Book;
import com.weirdo.dataobject.Cart;
import com.weirdo.dataobject.CartItem;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by DQ on 2015/12/23.
 */
public class CartTest {

    @Test
    public void testGetItems() throws Exception {
        Cart cart = new Cart();
        Book book = new Book();
        book.setId(1);
        book.setPrice(20);
        book.setTitle("haha");
        cart.getMap().put(1,new CartItem(book,1));
        Collection<CartItem> collection = cart.getItems();
//        System.out.println(collection.);
        for (CartItem c : collection){
            System.out.println(c.getTitle());
        }
    }
}