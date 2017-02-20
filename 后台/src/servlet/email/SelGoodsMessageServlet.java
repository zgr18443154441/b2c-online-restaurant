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
import com.shxt.service.EmailService;
/**
 * 查看商品评价服务器
 * @author 张国荣
 * @ClassName: SelGoodsMessageServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午2:14:28
 * @description 类描述
 */
@WebServlet("/selGoodsMessage.do")
public class SelGoodsMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String,String> message = new EmailService().selOneEmail(request.getParameter("goods_id"));
		response.setContentType("text/json;charset=utf-8");
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(message));
		out.flush();
		out.close();
	}

}
