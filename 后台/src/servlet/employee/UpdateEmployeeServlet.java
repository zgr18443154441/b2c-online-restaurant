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
 * 修改员工信息服务器
 * @author 张国荣
 * @ClassName: UpdateEmployeeServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午8:51:56
 * @description 类描述
 */
@WebServlet("/updateEmployee.do")
public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Map<String,String>> department_list = new DepartmentService().getDepartment();
		request.setAttribute("department_list", department_list);
		Employee em = new EmployeeService().selEmployee(request.getParameter("id"));
		request.setAttribute("em", em);
		request.setAttribute("id", request.getParameter("id"));
		request.setAttribute("sex", String.valueOf(em.getSex()));
		request.setAttribute("power", em.getRole());
		request.setAttribute("department", em.getDepartment());
		request.getRequestDispatcher("/employee/employeeUpdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FileUploadTool fut = new FileUploadTool(request);
		fut.upload();
		Employee e = new Employee();
		String id = fut.getParameter("id");
		String power = fut.getParameter("power");
		String real_name = fut.getParameter("real_name");
		String sex = fut.getParameter("sex");
		System.out.println(sex);
		String birthday = fut.getParameter("birthday");
		String email = fut.getParameter("email");
		String department = fut.getParameter("department");
		String photo = fut.getParameter("photo");
		if("1".equals(power)){
			if(new EmployeeService().testUserName(fut.getParameter("username"))){
				request.setAttribute("error", "该用户名已存在");
				request.getRequestDispatcher("/employee/employeeAdd.jsp").forward(request, response);
				return;
			}else{
				e.setId(Integer.parseInt(id));
				e.setRole(power.charAt(0));
				e.setBirthday(birthday);
				e.setDepartment(department);
				e.setEmail(email);
				e.setName(real_name);
				e.setPhoto(photo);
				e.setSex(sex.charAt(0));
				e.setUsername(fut.getParameter("username"));
				e.setPassword(fut.getParameter("password"));
				new EmployeeService().updateEmployee(e);
				response.sendRedirect("index/frame.jsp");
				return;
			}
		}else{
			e.setId(Integer.parseInt(id));
			e.setRole(power.charAt(0));
			e.setBirthday(birthday);
			e.setDepartment(department);
			e.setEmail(email);
			e.setName(real_name);
			e.setPhoto(photo);
			e.setSex(sex.charAt(0));
			new EmployeeService().updateEmployee(e);
			response.sendRedirect("index/frame.jsp");
			return;
		}
	}
}
