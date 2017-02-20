package com.shxt.servlet.stock;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.service.StockCategoryService;
/**
 * 查询库存类别服务器
 * @author 张国荣
 * @ClassName: SelStockClassServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午9:06:46
 * @description 类描述
 */
@WebServlet("/selStockClass.do")
public class SelStockClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Map<String,String>> stock_list = new StockCategoryService().stockMessage();
		request.setAttribute("stock_list", stock_list);
		request.getRequestDispatcher("/stock/stockCategory.jsp").forward(request, response);
	}

}
