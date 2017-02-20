package com.shxt.servlet.stock;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.service.PieceService;
import com.shxt.service.StockService;
/**
 * 查询库存提示服务器
 * @author 张国荣
 * @ClassName: SelSeldomStockServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午9:06:11
 * @description 类描述
 */
@WebServlet("/selSeldomStock.do")
public class SelSeldomStockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("piece", new PieceService().selPiece());
		request.setAttribute("kindStock", new StockService().getSeldomStock());
		request.getRequestDispatcher("/stock/stockSel.jsp").forward(request, response);
	}

}
