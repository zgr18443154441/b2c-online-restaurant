package com.shxt.servlet.employee;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.model.Employee;
import com.shxt.service.DepartmentService;
import com.shxt.service.EmployeeService;
import com.shxt.util.FileUploadTool;
/**
 * 添加员工服务器
 * @author 张国荣
 * @ClassName: AddEmployeeServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午2:15:02
 * @description 类描述
 */
@WebServlet("/addEmployee.do")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Map<String,String>> department_list = new DepartmentService().getDepartment();
		request.setAttribute("department_list", department_list);
		request.getRequestDispatcher("/employee/employeeAdd.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FileUploadTool fut = new FileUploadTool(request);
		fut.upload();
		Employee e = new Employee();
		String power = fut.getParameter("power");
		String real_name = fut.getParameter("real_name");
		String sex = fut.getParameter("sex");
		String birthday = fut.getParameter("birthday");
		String email = fut.getParameter("email");
		String department = fut.getParameter("department");
		String photo = fut.getParameter("photo");
		if("1".equals(power)){
			e.setRole(power.charAt(0));
			e.setBirthday(birthday);
			e.setDepartment(department);
			e.setEmail(email);
			e.setName(real_name);
			e.setPhoto(photo);
			e.setSex(sex.charAt(0));
			e.setUsername(fut.getParameter("username"));
			e.setPassword(fut.getParameter("password"));
			new EmployeeService().addEmployee(e);
			response.sendRedirect("index/frame.jsp");
			return;
		}else{
			e.setRole(power.charAt(0));
			e.setBirthday(birthday);
			e.setDepartment(department);
			e.setEmail(email);
			e.setName(real_name);
			e.setPhoto(photo);
			e.setSex(sex.charAt(0));
			new EmployeeService().addEmployee(e);
			response.sendRedirect("index/frame.jsp");
			return;
		}
	}

}
