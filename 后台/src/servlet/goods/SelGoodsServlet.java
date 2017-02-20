package com.shxt.servlet.goods;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.model.Goods;
import com.shxt.service.GoodsCategoryService;
import com.shxt.service.GoodsService;
import com.shxt.service.PieceService;
/**
 * 查询商品服务器
 * @author 张国荣
 * @ClassName: SelGoodsServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午8:56:07
 * @description 类描述
 */
@WebServlet("/selGoods.do")
public class SelGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Goods> tenGoods = new GoodsService().secondTenGoods(request.getParameter("id"));
		request.setAttribute("tenGoods", tenGoods);
		request.setAttribute("piece", new PieceService().selPiece());
		request.setAttribute("firstName", new GoodsService().selFirstName(request.getParameter("id")));
		request.setAttribute("secondName", new GoodsCategoryService().secondName(request.getParameter("id")));
		request.getRequestDispatcher("/goods/goodsSel.jsp").forward(request, response);
	}

}
