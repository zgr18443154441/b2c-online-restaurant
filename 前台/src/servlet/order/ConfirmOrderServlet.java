package com.shxt.servlet.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.service.CartService;
import com.shxt.service.OrderService;
/**
 * 确认订单服务器
 * @author 张国荣
 * @ClassName: ConfirmOrderServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午10:44:38
 * @description 类描述
 */
@WebServlet("/confirmOrder.do")
public class ConfirmOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		new OrderService().addOrderList(request.getParameter("user_id"),request.getParameter("address_id"),request.getParameter("sum_price"),request.getParameter("remark"));
		new OrderService().addOrderGoods(request.getParameter("user_id"),new OrderService().selNewOrderListId());
		new CartService().deleteCart(request.getParameter("user_id"));
		response.sendRedirect("loginon/success.jsp");
	}

}
