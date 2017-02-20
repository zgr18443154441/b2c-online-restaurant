package com.shxt.servlet.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.service.CartService;
/**
 * 清空购物车服务器
 * @author 张国荣
 * @ClassName: DropCartServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午10:29:50
 * @description 类描述
 */
@WebServlet("/dropCart.do")
public class DropCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		new CartService().dropCart((String)(request.getSession().getAttribute("id")));
		response.sendRedirect("selCart.do");
	}

}
