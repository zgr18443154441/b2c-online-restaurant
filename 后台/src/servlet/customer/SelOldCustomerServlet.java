package com.shxt.servlet.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.service.CustomerService;
/**
 * 查询用户排行榜
 * @author 张国荣
 * @ClassName: SelOldCustomerServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午2:13:34
 * @description 类描述
 */
@WebServlet("/selOldCustomer.do")
public class SelOldCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("old_customer", new CustomerService().selOldCustomer());
		request.getRequestDispatcher("/customer/OldCustomerSel.jsp").forward(request, response);
	}

}
