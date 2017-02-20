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
 * 验证用户名是否重复服务器
 * @author 张国荣
 * @ClassName: UserNameExistServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午8:52:29
 * @description 类描述
 */
@WebServlet("/userNameExist.do")
public class UserNameExistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(new EmployeeService().testUserName(request.getParameter("username"))){
			PrintWriter out = response.getWriter();
			out.print("0");
			out.flush();
			out.close();
		}
	}

}
