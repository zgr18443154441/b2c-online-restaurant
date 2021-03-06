package com.shxt.servlet.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.service.CartService;
/**
 * 删除购物车记录服务器
 * @author 张国荣
 * @ClassName: DeleteCartServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午10:30:03
 * @description 类描述
 */
@WebServlet("/deleteCart.do")
public class DeleteCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		new CartService().deleteOneCart(request.getParameter("id"));
		response.sendRedirect("selCart.do");
	}

}
