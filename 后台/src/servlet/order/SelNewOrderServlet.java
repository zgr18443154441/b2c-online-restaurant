package com.shxt.servlet.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.service.OrderService;
/**
 * 查询新订单信息服务器
 * @author 张国荣
 * @ClassName: SelNewOrderServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午9:00:29
 * @description 类描述
 */
@WebServlet("/selNewOrder.do")
public class SelNewOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("newOrder", new OrderService().selNewOrder());
		request.getRequestDispatcher("/order/orderSel.jsp").forward(request, response);
	}

}
