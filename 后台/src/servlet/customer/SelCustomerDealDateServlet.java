package com.shxt.servlet.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.service.CustomerService;
/**
 * 查询用户交易数据
 * @author 张国荣
 * @ClassName: SelCustomerDealDateServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午2:12:19
 * @description 类描述
 */
@WebServlet("/selCustomerDealDate.do")
public class SelCustomerDealDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("orderList", new CustomerService().getOneCustomerOrderList(request.getParameter("id")));
		request.getRequestDispatcher("/customer/customerDealDateSel.jsp").forward(request, response);
	}

}
