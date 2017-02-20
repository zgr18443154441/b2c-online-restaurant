package com.shxt.servlet.estimate;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.service.EmailService;
import com.shxt.service.EstimateService;
import com.shxt.service.GoodsService;
/**
 * 评价商品服务器
 * @author 张国荣
 * @ClassName: AddEstimateServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午10:39:28
 * @description 类描述
 */
@WebServlet("/addEstimate.do")
public class AddEstimateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("goods", new GoodsService().selEstimateGoods(request.getParameter("order_list")));
		request.setAttribute("list_id", request.getParameter("order_list"));
		request.getRequestDispatcher("/loginon/addEstimate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!"".equals(request.getParameter("email"))){
			new EmailService().addEmail((String)(request.getSession().getAttribute("id")), request.getParameter("email"));
		}
		new EstimateService().assessFinish(request.getParameter("list_id"));
		response.sendRedirect("loginon/finish.jsp");
	}

}
