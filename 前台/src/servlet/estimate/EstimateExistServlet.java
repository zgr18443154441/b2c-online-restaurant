package com.shxt.servlet.estimate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shxt.service.EstimateService;
/**
 * 查询评价信息是否存在服务器
 * @author 张国荣
 * @ClassName: EstimateExistServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午10:38:02
 * @description 类描述
 */
@WebServlet("/estimateExist.do")
public class EstimateExistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String message = new EstimateService().estimateExist((String)(session.getAttribute("id")), request.getParameter("id"));
		out.print(message);
		out.flush();
		out.close();
	}

}
