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
import com.shxt.service.GoodsService;
/**
 * 查询商品大类别
 * @author 张国荣
 * @ClassName: SelFirstClassServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午10:43:24
 * @description 类描述
 */
@WebServlet("/selFirstClass.do")
public class SelFirstClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		List<Map<String,String>> firstClass = new GoodsService().selFirstClass();
		Gson gson = new Gson();
		response.setContentType("text/json;cahrset=utf-8");
		out.print(gson.toJson(firstClass));
		out.flush();
		out.close();
	}

}
