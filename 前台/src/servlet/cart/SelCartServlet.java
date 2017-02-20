package com.shxt.servlet.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shxt.service.CartService;
/**
 * 查询购物车服务器
 * @author 张国荣
 * @ClassName: SelCartServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午10:29:35
 * @description 类描述
 */
@WebServlet("/selCart.do")
public class SelCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setAttribute("cart", new CartService().selCart((String)(session.getAttribute("id"))));
		request.getRequestDispatcher("/loginon/cart.jsp").forward(request, response);
	}

}
