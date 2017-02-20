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
 * 验证管理员用户名是否重复服务器
 * @author 张国荣
 * @ClassName: ManagerNameExistServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午8:50:28
 * @description 类描述
 */
@WebServlet("/managerNameExist.do")
public class ManagerNameExistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String username = new EmployeeService().testManagerName(request.getParameter("id"));
		out.print(username);
		out.flush();
		out.close();
	}

}
