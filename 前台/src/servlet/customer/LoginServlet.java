package com.shxt.servlet.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shxt.model.Customer;
import com.shxt.service.CustomerService;
/**
 * 登录验证服务器
 * @author 张国荣
 * @ClassName: LoginServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午10:32:13
 * @description 类描述
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = new CustomerService().testLogin(request.getParameter("account"), request.getParameter("password"));
		if(message.equals("pass")){
		Customer cus = new CustomerService().login(request.getParameter("account"));
		HttpSession session = request.getSession();
		session.setAttribute("id", String.valueOf(cus.getId()));
		session.setAttribute("username", cus.getUsername());
		session.setAttribute("real_name", cus.getReal_name());
		session.setAttribute("sex", cus.getSex());
		session.setAttribute("email", cus.getEmail());
		session.setAttribute("photo", cus.getPhoto());
		session.setAttribute("birthday", cus.getBirthday());
		response.sendRedirect("selAddress.do");
		return;
		}else if(message.equals("2")){
			request.setAttribute("error", "用户登录权限被禁止");
			request.getRequestDispatcher("/loginout/login.jsp").forward(request, response);
		}else{
			request.setAttribute("error", "用户名或密码有误");
			request.getRequestDispatcher("/loginout/login.jsp").forward(request, response);
		}
	}

}
