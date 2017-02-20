package com.shxt.servlet.email;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.service.CustomerService;
import com.shxt.service.EmailService;
/**
 * 查看邮件服务器
 * @author 张国荣
 * @ClassName: SelEmailServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午2:14:15
 * @description 类描述
 */
@WebServlet("/selEmail.do")
public class SelEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("orderList",new EmailService().getOrderList());
		request.setAttribute("emailList", new EmailService().selEmailList());
		request.setAttribute("name", new CustomerService().getName());
		request.getRequestDispatcher("/email/emailSel.jsp").forward(request, response);
	}

}
