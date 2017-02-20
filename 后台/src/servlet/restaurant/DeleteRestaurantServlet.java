package com.shxt.servlet.restaurant;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.service.RestaurantService;
/**
 * 删除实体店服务器
 * @author 张国荣
 * @ClassName: DeleteRestaurantServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午9:03:13
 * @description 类描述
 */
@WebServlet("/deleteRestaurant.do")
public class DeleteRestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		new RestaurantService().deleteRestaurant(request.getParameter("id"));
		response.sendRedirect("index/frame.jsp");
	}

}
