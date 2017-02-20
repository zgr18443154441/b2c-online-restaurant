package com.shxt.servlet.stock;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.model.Stock;
import com.shxt.service.PieceService;
import com.shxt.service.StockService;
/**
 * 查询库存信息服务器
 * @author 张国荣
 * @ClassName: SelStockServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午9:08:13
 * @description 类描述
 */
@WebServlet("/selStock.do")
public class SelStockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Stock> kindStock  = new StockService().getKindStock(request.getParameter("id"));
		request.setAttribute("piece", new PieceService().selPiece());
		request.setAttribute("kindStock", kindStock);
		request.getRequestDispatcher("/stock/stockSel.jsp").forward(request, response);
	}

}
