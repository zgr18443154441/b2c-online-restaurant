package com.shxt.servlet.employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.service.EmployeeService;
/**
 * 验证密码是否正确服务器
 * @author 张国荣
 * @ClassName: TestOldPasswordServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午8:51:27
 * @description 类描述
 */
@WebServlet("/testOldPassword.do")
public class TestOldPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String message = new EmployeeService().testOldPassword(request.getParameter("id"),request.getParameter("oldpassword"));
		out.print(message);
		out.flush();
		out.close();
	}

}
