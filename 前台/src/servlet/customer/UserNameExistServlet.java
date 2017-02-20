package com.shxt.servlet.customer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.service.CustomerService;
/**
 * 验证用户名是否存在服务器
 * @author 张国荣
 * @ClassName: UserNameExistServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午10:31:11
 * @description 类描述
 */
@WebServlet("/userNameExist.do")
public class UserNameExistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print(new CustomerService().userNameExist(request.getParameter("account")));
		out.flush();
		out.close();
	}

}
