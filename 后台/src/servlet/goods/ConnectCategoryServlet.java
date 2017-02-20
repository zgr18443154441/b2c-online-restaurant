package com.shxt.servlet.goods;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.shxt.service.GoodsCategoryService;
/**
 * 查询商品小类别服务器
 * @author 张国荣
 * @ClassName: ConnectCategoryServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午8:54:25
 * @description 类描述
 */
@WebServlet("/connectCategory.do")
public class ConnectCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Map<String,String>> secondName = new GoodsCategoryService().secondName(request.getParameter("id"));
		response.setContentType("text/json;charset=utf-8");
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(secondName));
		out.flush();
		out.close();
	}

}
