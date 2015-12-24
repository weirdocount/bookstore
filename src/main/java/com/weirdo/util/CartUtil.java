package com.weirdo.util;

import com.weirdo.dataobject.Cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by DQ on 2015/12/22.
 */
public class CartUtil {
    public static Cart getCart(HttpServletRequest request){
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if(cart == null){
            cart = new Cart();
            session.setAttribute("cart",cart);
        }
        return cart;
    }
}
