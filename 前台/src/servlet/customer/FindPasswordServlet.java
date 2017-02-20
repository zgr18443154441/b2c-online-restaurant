package com.shxt.servlet.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.service.CustomerService;
/**
 * 验证密保信息等是否正确服务器
 * @author 张国荣
 * @ClassName: FindPasswordServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午10:32:47
 * @description 类描述
 */
@WebServlet("/findPassword.do")
public class FindPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerService cs = new CustomerService();
		String account = request.getParameter("UserName");
		String answer = request.getParameter("answer");
		String phonenumber = request.getParameter("phonenumber");
		if(cs.proveAnswer(account, answer)&&cs.provePhoneNumber(account, phonenumber)){
			request.setAttribute("account", account);
			request.getRequestDispatcher("/loginout/resetPassword.jsp").forward(request, response);
		}else{
			request.setAttribute("error", "验证信息有误");
			request.getRequestDispatcher("/loginout/forgetPassword.jsp").forward(request, response);
		}
	}

}
