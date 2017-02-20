package com.shxt.servlet.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.service.OrderService;
/**
 * 确认订单服务器
 * @author 张国荣
 * @ClassName: FinishOrderServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午9:00:54
 * @description 类描述
 */
@WebServlet("/finishOrder.do")
public class FinishOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		new OrderService().finishOrder(request.getParameter("id"));
	}

}
