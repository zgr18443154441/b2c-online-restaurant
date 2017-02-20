package com.shxt.servlet.goods;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.service.GoodsService;
/**
 * 查询热销商品服务器
 * @author 张国荣
 * @ClassName: SelHotGoodsServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午8:56:34
 * @description 类描述
 */
@WebServlet("/selHotGoods.do")
public class SelHotGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("hot_goods", new GoodsService().selHotGoods());
		request.getRequestDispatcher("goods/hotGoodsSel.jsp").forward(request, response);
	}

}
