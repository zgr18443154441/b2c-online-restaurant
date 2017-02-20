package com.shxt.servlet.email;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.service.EmailService;
import com.shxt.service.RestaurantService;
/**
 * 发送邮件服务器
 * @author 张国荣
 * @ClassName: SendMessageServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午10:34:20
 * @description 类描述
 */
@WebServlet("/sendMessage.do")
public class SendMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("city", new RestaurantService().selcity());
		request.getRequestDispatcher("/loginon/sendMessage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!"".equals(request.getParameter("email"))){
			new EmailService().addEmail((String)(request.getSession().getAttribute("id")), request.getParameter("email"));
		}
		response.sendRedirect("loginon/send.jsp");
	}

}
