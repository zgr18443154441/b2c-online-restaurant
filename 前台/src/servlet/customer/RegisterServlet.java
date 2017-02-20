package com.shxt.servlet.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.model.Customer;
import com.shxt.service.CustomerService;
import com.shxt.util.FileUploadTool;
/**
 * 新用户注册服务器
 * @author 张国荣
 * @ClassName: RegisterServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午10:31:57
 * @description 类描述
 */
@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FileUploadTool fut = new FileUploadTool(request);
		fut.upload();
		Customer cus = new Customer();
		cus.setAnswer(fut.getParameter("answer"));
		cus.setQuestion(fut.getParameter("question"));
		cus.setBirthday(fut.getParameter("birthday"));
		cus.setEmail(fut.getParameter("email"));
		cus.setPhoto(fut.getParameter("photo"));
		cus.setReal_name(fut.getParameter("realname"));
		cus.setSex(fut.getParameter("sex").charAt(0));
		cus.setUsername(fut.getParameter("UserName"));
		cus.setPassword(fut.getParameter("password"));
		new CustomerService().register(cus);
		response.sendRedirect("loginout/login.jsp");
	}

}
