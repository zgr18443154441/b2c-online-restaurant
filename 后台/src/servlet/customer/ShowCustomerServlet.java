package com.shxt.servlet.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.model.Customer;
import com.shxt.service.CustomerService;
/**
 * 查询用户信息
 * @author 张国荣
 * @ClassName: ShowCustomerServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午2:13:51
 * @description 类描述
 */
@WebServlet("/showCustomer.do")
public class ShowCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Customer> allCustomer = new CustomerService().getAllCustomer();
		request.setAttribute("allCustomer", allCustomer);
		request.getRequestDispatcher("/customer/customerSel.jsp").forward(request, response);
	}

}
