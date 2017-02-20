package com.shxt.servlet.goodsCategory;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.service.GoodsCategoryService;
/**
 * 查询商品目录服务器
 * @author 张国荣
 * @ClassName: SelGoodsCategoryServlet
 * @Version 1.0 
 * @Copyright 四海兴唐
 * @date 2016年8月14日 上午8:59:42
 * @description 类描述
 */
@WebServlet("/selGoodsCategory.do")
public class SelGoodsCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("firstClass", new GoodsCategoryService().firstClass());
		request.getRequestDispatcher("/goods/goodsCategorySel.jsp").forward(request, response);
	}

}
