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
 * 查询密保问题服务器
 * @author 张国荣
 * @ClassName: SelQuestionServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午10:31:29
 * @description 类描述
 */
@WebServlet("/selQuestion.do")
public class SelQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print(new CustomerService().selQuestion(request.getParameter("account")));
		out.flush();
		out.close();
	}

}
