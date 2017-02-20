package com.shxt.servlet.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.service.OrderService;
/**
 * 确认送达服务器
 * @author 张国荣
 * @ClassName: GetOrderServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 下午6:45:29
 * @description 类描述
 */
@WebServlet("/getOrder.do")
public class GetOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		new OrderService().getOrder(request.getParameter("id"));
	}

}
