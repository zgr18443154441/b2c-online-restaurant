package com.shxt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.shxt.service.CustomerService;
import com.shxt.service.EmailService;
import com.shxt.service.OrderService;
/**
 * 查询首页提示信息服务器
 * @author 张国荣
 * @ClassName: SelDateServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午9:09:27
 * @description 类描述
 */
@WebServlet("/selDate.do")
public class SelDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		Map<String,String> date = new HashMap<>();
		date.put("email", new EmailService().countNewEmail());
		date.put("customer", new CustomerService().countNewCustomer());
		date.put("order", new OrderService().countNewOrder());
		Gson gson = new Gson();
		out.print(gson.toJson(date));
		out.flush();
		out.close();
	}

}
