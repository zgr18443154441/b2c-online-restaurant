package com.shxt.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shxt.model.Stock;
import com.shxt.service.EmailService;
import com.shxt.service.GoodsCategoryService;
import com.shxt.service.StockCategoryService;
import com.shxt.service.StockService;
import com.shxt.service.SystemService;
/**
 * 登录验证服务器
 * @author 张国荣
 * @ClassName: LoginServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午9:09:08
 * @description 类描述
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//验证信息
		String randomMessage = new SystemService().validate(request.getParameter("rand"), (String)request.getSession().getAttribute("RANDOM"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String message = new SystemService().login(username, password);
		if(message.equals("username")){
			request.setAttribute("error", "账号不存在");
			request.getRequestDispatcher("/index/login.jsp").forward(request, response);
			return;
		}else if(message.equals("password")){
			request.setAttribute("error", "密码有误");
			request.getRequestDispatcher("/index/login.jsp").forward(request, response);
			return;
		}else if(!randomMessage.equals("通过验证")){
			request.setAttribute("error", randomMessage);
			request.getRequestDispatcher("/index/login.jsp").forward(request, response);
			return;
		}else{
			HttpSession session = request.getSession();
			//评价：4条
			List<Map<String,String>> fourEstimate = new EmailService().getFourEstimate();
			if(!fourEstimate.isEmpty()){
				session.setAttribute("fourEstimate", fourEstimate);
			}
			//库存：4条
			List<Stock> fourStock = new StockService().getFourStock();
			session.setAttribute("fourStock", fourStock);
			//商品大类
			List<Map<String,String>> goodsCategory = new GoodsCategoryService().selGoodsCategory();
			if(!goodsCategory.isEmpty()){
				session.setAttribute("goodsCategory", goodsCategory);
			}
			//库存大类
			List<Map<String,String>> stockCategory = new StockCategoryService().selStockCategory();
			if(!stockCategory.isEmpty()){
				session.setAttribute("stockCategory", stockCategory);
			}
			//登录信息
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			session.setAttribute("real_name", message);
			request.getRequestDispatcher("/index/frame.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
