package com.shxt.servlet.stock;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.model.Stock;
import com.shxt.service.PieceService;
import com.shxt.service.StockCategoryService;
import com.shxt.service.StockService;
import com.shxt.util.FileUploadTool;
/**
 * 添加库存
 * @author 张国荣
 * @ClassName: AddStockServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午9:05:28
 * @description 类描述
 */
@WebServlet("/addStock.do")
public class AddStockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Map<String,String>> stock_category = new StockCategoryService().selStockCategory();
		List<Map<String,String>> piece = new PieceService().selPiece();
		request.setAttribute("stock_category", stock_category);
		request.setAttribute("piece", piece);
		request.getRequestDispatcher("/stock/stockAdd.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FileUploadTool fut = new FileUploadTool(request);
		fut.upload();
		Stock st = new Stock();
		st.setKindId(Integer.parseInt(fut.getParameter("kind")));
		st.setPieceId(Integer.parseInt(fut.getParameter("piece")));
		st.setName(fut.getParameter("stock_name"));
		st.setRest(Double.parseDouble(fut.getParameter("start")));
		st.setTop(Double.parseDouble(fut.getParameter("top")));
		new StockService().addStock(st);
		response.sendRedirect("index/frame.jsp");
	}

}
