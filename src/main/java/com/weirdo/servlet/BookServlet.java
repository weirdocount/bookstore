package com.weirdo.servlet;


import com.google.gson.Gson;
import com.weirdo.dataobject.Book;
import com.weirdo.dataobject.BookResult;
import com.weirdo.dataobject.Cart;
import com.weirdo.dataobject.CartItem;
import com.weirdo.service.BookService;
import com.weirdo.service.CartService;
import com.weirdo.util.CartUtil;
import com.weirdo.util.QueryCondition;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class BookServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private BookService bookService = new BookService();
	private CartService cartService = new CartService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String methodName = request.getParameter("method");

		try {
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			method.setAccessible(true);
			method.invoke(this, request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 根据搜索条件获取书籍
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
     */
	protected void getBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String minPriceStr = request.getParameter("minPrice");
		String maxPriceStr = request.getParameter("maxPrice");
		String pageNoStr = request.getParameter("pageNo");

		double minPrice = 0.0;
		if (minPriceStr != null) {
			try {
                minPrice = Double.parseDouble(minPriceStr);
            } catch (NumberFormatException e) {
            }
		}

		double maxPrice = Double.MAX_VALUE;
		if (maxPriceStr != null) {
			try {
                maxPrice = Double.parseDouble(maxPriceStr);
            } catch (NumberFormatException e) {
            }
		}
		int pageNo = 1;
		if (pageNoStr != null) {
			try {
				pageNo = Integer.parseInt(pageNoStr);
            } catch (NumberFormatException e) {
            }
		}
		QueryCondition queryCondition = new QueryCondition(minPrice,maxPrice,5,pageNo);
		BookResult result = bookService.getBookResultByQueryCondition(queryCondition);
		request.setAttribute("bookResult",result);
		request.setAttribute("condition",queryCondition);
		request.getRequestDispatcher("/WEB-INF/pages/books.jsp").forward(request,response);
	}

	/**
	 * 获取单个书籍
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
     */
	protected void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = -1;
		String idStr = request.getParameter("id");
		if (idStr != null){
			try {
				id = Integer.parseInt(idStr);
			} catch (NumberFormatException e) {
			}
		}
		Book book = null;
		if (id > 0){
			book = bookService.getBookById(id);
		}
		if (book != null) {
			request.setAttribute("book",book);
			request.getRequestDispatcher("/WEB-INF/pages/book.jsp").forward(request,response);
			return;
		}
		response.sendRedirect(request.getContextPath() + "/error-1.jsp");
	}

	/**
	 * 购买书籍
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
     */
	protected void buyBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String idStr = request.getParameter("id");
		Integer id = -1;
		if(idStr != null){
			try {
				id = Integer.parseInt(idStr);
			} catch (NumberFormatException e) {
			}
		}
		if(id > 0 ){
			Cart cart = CartUtil.getCart(request);
			boolean result = cartService.buyBook(cart,id);
			if (result) {
				getBooks(request,response);
				return;
			}
		}
		String msg = "购买商品出错";
		request.setAttribute("msg",msg);
		request.getRequestDispatcher("/error.jsp").forward(request,response);
	}

	/**
	 * 删除购物车中指定的书籍
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
     */
	protected void removeBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String idStr = request.getParameter("id");
		int id = -1;
		if (idStr != null){
			try {
				id = Integer.parseInt(idStr);
			} catch (NumberFormatException e) {
			}
		}
		if (id > 0){
			Cart cart = CartUtil.getCart(request);
			cartService.removeItem(cart,id);
			request.getRequestDispatcher("/cart.jsp").forward(request,response);
			return;
		}
		request.getRequestDispatcher(request.getContextPath()+"/error.jsp").forward(request,response);
	}

	/**
	 * 页面跳转
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
     */
	protected void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String dest = request.getParameter("dest");
		if(dest != null){
			request.getRequestDispatcher("/"+dest+".jsp").forward(request,response);
		}else {
			String msg = "您跳转的页面不存在";
			request.setAttribute("msg",msg);
			request.getRequestDispatcher(request.getContextPath()+"/error.jsp").forward(request,response);
		}
	}

	/**
	 * 清空购物车
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
     */
	protected void clearBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Cart cart = CartUtil.getCart(request);
		cartService.clearItem(cart);
		request.getRequestDispatcher("/WEB-INF/pages/emptycart.jsp").forward(request,response);
	}

	/**
	 * 修改购物车中指定书籍的数量
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
     */
	protected void updateBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String idStr = request.getParameter("id");
		String numStr = request.getParameter("num");
		int num = -1;
		Integer id = -1;
		if(idStr != null){
			try {
				id = Integer.parseInt(idStr);
			} catch (NumberFormatException e) {
			}
		}

		if(numStr != null){
			try {
				num = Integer.parseInt(numStr);
			} catch (NumberFormatException e) {
			}
		}

		if(id > 0 && num > 0){
			System.out.println("laile------");
			Cart cart = CartUtil.getCart(request);
			boolean result = cartService.updateItem(cart,id,num);
			if (result) {
				Map<String,Object> map = new HashMap<String, Object>();
				map.put("totalNum",cart.getTotalNum());
				map.put("totalMoney",cart.getTotalMoney());
				Gson gson = new Gson();
				String jsonStr = gson.toJson(map);
				System.out.println("------"+jsonStr);
				response.setContentType("text/javascript");
				response.getWriter().print(jsonStr);
				return;
			}
		}
		String msg = "修改商品数量出错";
		request.setAttribute("msg",msg);
		request.getRequestDispatcher("/error.jsp").forward(request,response);
	}
}
