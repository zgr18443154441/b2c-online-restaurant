package com.shxt.servlet.employee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.service.EmployeeService;
/**
 * 取消员工登录权限服务器
 * @author 张国荣
 * @ClassName: ConcelPowerServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午8:49:20
 * @description 类描述
 */
@WebServlet("/concelPower.do")
public class ConcelPowerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		new EmployeeService().concelPower(request.getParameter("id"));
	}

}
