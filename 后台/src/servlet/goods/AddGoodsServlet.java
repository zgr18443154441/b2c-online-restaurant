package com.shxt.servlet.goods;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.model.Goods;
import com.shxt.service.GoodsCategoryService;
import com.shxt.service.GoodsService;
import com.shxt.service.PieceService;
import com.shxt.util.FileUploadTool;
/**
 * 添加商品服务器
 * @author 张国荣
 * @ClassName: AddGoodsServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午8:53:09
 * @description 类描述
 */
@WebServlet("/addGoods.do")
public class AddGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("firstName", new GoodsCategoryService().firstName());
		request.setAttribute("piece", new PieceService().selPiece());
		request.getRequestDispatcher("/goods/goodsAdd.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FileUploadTool fut = new FileUploadTool(request);
		fut.upload();
		Goods g = new Goods();
		g.setPiece_id(Integer.parseInt(fut.getParameter("piece")));
		g.setDiscount(Double.parseDouble(fut.getParameter("discount")));
		g.setFirst_id(Integer.parseInt(fut.getParameter("first_class")));
		g.setGoods_name(fut.getParameter("goods_name"));
		g.setPhoto(fut.getParameter("photo"));
		g.setPost_price(Double.parseDouble(fut.getParameter("post_price")));
		g.setSecond_id(Integer.parseInt(fut.getParameter("second_class")));
		new GoodsService().addGoods(g);
		response.sendRedirect("index/frame.jsp");
	}

}
