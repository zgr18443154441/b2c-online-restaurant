package com.shxt.servlet.stock;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.service.StockService;
/**
 * 删除库存服务器
 * @author 张国荣
 * @ClassName: DeleteStockServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午9:05:43
 * @description 类描述
 */
@WebServlet("/deleteStock.do")
public class DeleteStockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		new StockService().deleteStock(request.getParameter("id"));
		response.sendRedirect("index/frame.jsp");
	}

}
