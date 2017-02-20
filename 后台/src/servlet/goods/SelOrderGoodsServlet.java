package com.shxt.servlet.goods;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.shxt.model.OrderGoods;
import com.shxt.service.CustomerService;
/**
 * 查询订单商品信息服务器
 * @author 张国荣
 * @ClassName: SelOrderGoodsServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午8:58:27
 * @description 类描述
 */
@WebServlet("/selOrderGoods.do")
public class SelOrderGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderGoods order_goods = new CustomerService().selOrderGoods(request.getParameter("goods_id"));
		response.setContentType("text/json;charset=utf-8");
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(order_goods));
		out.flush();
		out.close();
	}

}
