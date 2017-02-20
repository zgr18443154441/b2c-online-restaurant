package com.shxt.servlet.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.service.CustomerService;
/**
 * 限制用户登录权限服务器
 * @author 张国荣
 * @ClassName: DefineCustomerServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午2:11:36
 * @description 类描述
 */
@WebServlet("/defineCustomer.do")
public class DefineCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		new CustomerService().defineCustomer(request.getParameter("id"));
	}

}
