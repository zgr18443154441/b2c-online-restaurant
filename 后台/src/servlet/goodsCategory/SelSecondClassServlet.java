package com.shxt.servlet.goodsCategory;

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
 * 查询商品小类别
 * @author 张国荣
 * @ClassName: SelSecondClassServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午9:00:02
 * @description 类描述
 */
@WebServlet("/selSecondClass.do")
public class SelSecondClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Map<String,String>> secondClass = new GoodsCategoryService().secondClass(request.getParameter("id"));
		response.setContentType("text/json;charset=utf-8");
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(secondClass));
		out.flush();
		out.close();
	}

}
