package com.shxt.servlet.employee;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.model.Employee;
import com.shxt.service.EmployeeService;
/**
 * 查询员工信息服务器
 * @author 张国荣
 * @ClassName: ShowEmployeeServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午8:51:07
 * @description 类描述
 */
@WebServlet("/showEmployee.do")
public class ShowEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Employee> em_list = new EmployeeService().getEmployee();
		request.setAttribute("em_list", em_list);
		request.getRequestDispatcher("/employee/employeeSel.jsp").forward(request, response);
	}

}
