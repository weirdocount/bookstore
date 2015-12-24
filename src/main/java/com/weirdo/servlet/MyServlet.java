package com.weirdo.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created by daiqiang on 2015/12/21.
 */
public class MyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String methodName  = req.getParameter("method");
        Method method = null;
        if(methodName != null) {
            System.out.println(methodName);
            try {
                method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
                method.setAccessible(true);
                method.invoke(this,req,resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//        test(req,resp);

    }

    protected void test(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("test","test");
        req.getRequestDispatcher("/hello.jsp").forward(req,resp);
    }
}
