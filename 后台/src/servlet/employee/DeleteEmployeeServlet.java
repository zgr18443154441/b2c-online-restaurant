package com.shxt.servlet.employee;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.service.EmployeeService;
/**
 * 删除员工服务器
 * @author 张国荣
 * @ClassName: DeleteEmployeeServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午8:49:54
 * @description 类描述
 */
@WebServlet("/deleteEmployee.do")
public class DeleteEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		new EmployeeService().deleteEmployee(request.getParameter("id"));
		response.sendRedirect("index/frame.jsp");
	}
	

}
