package com.shxt.servlet.goodsCategory;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.shxt.service.GoodsCategoryService;
/**
 * 添加商品小类别服务器
 * @author 张国荣
 * @ClassName: AddSecondClassServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午8:59:24
 * @description 类描述
 */
@WebServlet("/addSecondClass.do")
public class AddSecondClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String classId = new GoodsCategoryService().addSecondClass(request.getParameter("secondname"),request.getParameter("firstId"));
		response.setContentType("text/json;charset=utf-8");
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(classId));
		out.flush();
		out.close();
	}

}
