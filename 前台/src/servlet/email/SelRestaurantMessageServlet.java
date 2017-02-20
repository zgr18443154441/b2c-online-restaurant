package com.shxt.servlet.email;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.shxt.service.RestaurantService;
/**
 * 查询实体店信息服务器
 * @author 张国荣
 * @ClassName: SelRestaurantMessageServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午10:34:33
 * @description 类描述
 */
@WebServlet("/selRestaurantMessage.do")
public class SelRestaurantMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		Map<String,String> message = new RestaurantService().selmessage(request.getParameter("id"));
		Gson gson = new Gson();
		out.print(gson.toJson(message));
		out.flush();
		out.close();
	}

}
