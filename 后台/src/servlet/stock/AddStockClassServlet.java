package com.shxt.servlet.stock;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.shxt.service.StockCategoryService;
/**
 * 添加库存类别服务器
 * @author 张国荣
 * @ClassName: AddStockClassServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午9:05:09
 * @description 类描述
 */
@WebServlet("/addStockClass.do")
public class AddStockClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("addname"));
		String classId = new StockCategoryService().addStockClass(request.getParameter("addname"));
		response.setContentType("text/json;charset=utf-8");
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(classId));
		out.flush();
		out.close();
	}

}
