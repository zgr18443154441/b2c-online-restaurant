package com.shxt.servlet.restaurant;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.service.RestaurantService;
/**
 * 查询实体店信息服务器
 * @author 张国荣
 * @ClassName: SelRestaurantServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午9:04:11
 * @description 类描述
 */
@WebServlet("/selRestaurant.do")
public class SelRestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("rest_list", new RestaurantService().selRestList());
		request.getRequestDispatcher("/restaurant/selRestaurant.jsp").forward(request, response);
	}

}
