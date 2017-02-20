package com.shxt.servlet.email;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.service.EmailService;
/**
 * 回复邮件服务器
 * @author 张国荣
 * @ClassName: ReplyEmailServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午2:14:02
 * @description 类描述
 */
@WebServlet("/replyEmail.do")
public class ReplyEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("email", new EmailService().selEmail(request.getParameter("id")));
		request.getRequestDispatcher("/email/emailReply.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		new EmailService().replyEmail(request.getParameter("id"), request.getParameter("reply"));
		response.sendRedirect("index/frame.jsp");
	}

}
