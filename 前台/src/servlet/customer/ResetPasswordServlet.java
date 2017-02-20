package com.shxt.servlet.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.service.CustomerService;
/**
 * 重设密码服务器
 * @author 张国荣
 * @ClassName: ResetPasswordServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午10:31:44
 * @description 类描述
 */
@WebServlet("/resetPassword.do")
public class ResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		new CustomerService().resetPassword(request.getParameter("account"), request.getParameter("password"));
		response.sendRedirect("loginout/login.jsp");
	}

}
