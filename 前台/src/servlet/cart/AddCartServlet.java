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
 * 向购物车中添加商品服务器
 * @author 张国荣
 * @ClassName: AddCartServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午10:30:21
 * @description 类描述
 */
@WebServlet("/addCart.do")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CartService cs = new CartService();
		HttpSession session = request.getSession();
		String user_id = (String)(session.getAttribute("id"));
		String goods_id = request.getParameter("id");
		String message = request.getParameter("message");
		switch (message) {
		case "add":
			cs.addCart(goods_id, user_id);
			break;
		case "plus":
			cs.plusCart(goods_id, user_id);
			break;
		case "minus":
			cs.minusCart(goods_id, user_id);
			break;
		case "delete":
			cs.deleteOneCart(goods_id, user_id);
			break;
		}
	}

}
